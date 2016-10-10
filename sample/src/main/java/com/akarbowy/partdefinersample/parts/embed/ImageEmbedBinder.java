package com.akarbowy.partdefinersample.parts.embed;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefinersample.Story;


public class ImageEmbedBinder implements Binder<ImageEmbedView> {
    private Story story;

    public ImageEmbedBinder(Story model) {
        story = model;
    }

    @Override public void prepare(ImageEmbedView view) {

    }

    @Override public void bind(ImageEmbedView view) {
        view.setPreview(story.imagePreviewId);
    }

    @Override public void unbind(ImageEmbedView view) {

    }
}
