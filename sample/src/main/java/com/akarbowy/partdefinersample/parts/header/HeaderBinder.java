package com.akarbowy.partdefinersample.parts.header;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefinersample.Story;


public class HeaderBinder implements Binder<HeaderView> {

    private Story story;

    public HeaderBinder(Story model) {
        story = model;
    }

    @Override public void prepare(HeaderView view) {

    }

    @Override public void bind(HeaderView view) {
        view.setAvatarColor(story.avatarColor);
        view.setTitle(story.title);
        view.setDate(story.date);
    }

    @Override public void unbind(HeaderView view) {

    }
}
