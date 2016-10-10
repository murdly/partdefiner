package com.akarbowy.partdefinersample.parts.embed;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefinersample.Story;

public class FileEmbedBinder implements Binder<FileEmbedView> {
    private Story story;

    public FileEmbedBinder(Story model) {
        story = model;
    }

    @Override public void prepare(FileEmbedView view) {
    }

    @Override public void bind(FileEmbedView view) {
        view.setFilename(story.fileName);
    }

    @Override public void unbind(FileEmbedView view) {

    }
}
