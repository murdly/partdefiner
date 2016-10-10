package com.akarbowy.partdefinersample.parts.content;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefinersample.Story;


public class ContentBinder implements Binder<ContentView> {

    private Story story;

    public ContentBinder(Story model) {
        this.story = model;
    }

    @Override public void prepare(ContentView view) {

    }

    @Override public void bind(ContentView view) {
        view.setContent(story.content);
    }

    @Override public void unbind(ContentView view) {

    }
}
