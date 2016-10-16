# partdefiner
Helps you split your RecyclerView or ListView items into separated parts.
<br />Based on facebook article about [Fast Rendering News Feed on Android](https://code.facebook.com/posts/879498888759525/fast-rendering-news-feed-on-android/).

![alt tag](images/part_split.png)

## Usage
### Defining part
Step 1: create a custom view for your part
```java
public class HeaderView extends RelativeLayout {

    @BindView(R.id.avatar) ImageView avatarView;
    @BindView(R.id.text_author) TextView authorView;
    @BindView(R.id.text_date) TextView dateView;

    public HeaderView(Context context) {
        super(context);
        ButterKnife.bind(this, inflate(context, R.layout.item_story_header, this));
    }

    public void setAvatarColor(int color) {
        avatarView.setBackgroundColor(color);
    }

    public void setTitle(String author) {
        authorView.setText(author);
    }

    public void setDate(String date) {
        dateView.setText(date);
    }
}
```
Step 2: implement a `Binder` which binds model with your custom view
```java
public class HeaderBinder implements Binder<HeaderView> {

    private Story story;

    public HeaderBinder(Story model) {
        story = model;
    }

    @Override public void prepare(HeaderView view) { }

    @Override public void bind(HeaderView view) {
        view.setAvatarColor(story.avatarColor);
        view.setTitle(story.title);
        view.setDate(story.date);
    }

    @Override public void unbind(HeaderView view) { }
}
```
Step 3: wire them together by implementing `SinglePartDefinition`
```java
public class HeaderPart implements SinglePartDefinition<Story, HeaderView> {
    @Override public int getViewType() {
        return ViewType.HEADER;
    }

    @Override public Binder<HeaderView> createBinder(Story model) {
        return new HeaderBinder(model);
    }

    @Override public boolean isNeeded(Story model) {
        return true;
    }
}
```
or if you need to group several parts into one, implement `GroupPartDefinition` instead:
```java
public class EmbedPart implements GroupPartDefinition<Story> {

    @Override public boolean isNeeded(Story model) {
        return model.imagePreviewId != -1 || model.fileName != null;
    }

    @Override public List<PartDefinition<Story>> getChildren(Story model) {
        List<PartDefinition<Story>> parts = new ArrayList<>();
        parts.add(new ImageEmbedPart());
        parts.add(new FileEmbedPart());
        return parts;
    }
}
```
Step 4: use it with your adapter. See `FeedAdapter.java` in sample project.


## Real life example app
See example code [here](https://github.com/murdly/tagop). You can also download the app from google play:<br />
<a href='https://play.google.com/store/apps/details?id=com.akarbowy.tagop'>
<img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="280"/></a>

## Download
via Gradle:
```groovy
compile 'com.akarbowy:partdefiner:1.0'
```
or Maven:
```xml
<dependency>
  <groupId>com.akarbowy</groupId>
  <artifactId>partdefiner</artifactId>
  <version>1.0</version>
</dependency>
```