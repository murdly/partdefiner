package com.akarbowy.partdefinersample.parts.embed;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefiner.SinglePartDefinition;
import com.akarbowy.partdefinersample.Story;
import com.akarbowy.partdefinersample.parts.ViewType;

public class FileEmbedPart implements SinglePartDefinition<Story, FileEmbedView> {
    @Override public int getViewType() {
        return ViewType.EMBED_FILE;
    }

    @Override public Binder<FileEmbedView> createBinder(Story model) {
        return new FileEmbedBinder(model);
    }

    @Override public boolean isNeeded(Story model) {
        return model.fileName != null;
    }
}