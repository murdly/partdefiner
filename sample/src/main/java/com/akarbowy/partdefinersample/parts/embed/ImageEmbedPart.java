package com.akarbowy.partdefinersample.parts.embed;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefiner.SinglePartDefinition;
import com.akarbowy.partdefinersample.Story;
import com.akarbowy.partdefinersample.parts.ViewType;

public class ImageEmbedPart implements SinglePartDefinition<Story, ImageEmbedView> {
    @Override public int getViewType() {
        return ViewType.EMBED_IMAGE;
    }

    @Override public Binder<ImageEmbedView> createBinder(Story model) {
        return new ImageEmbedBinder(model);
    }

    @Override public boolean isNeeded(Story model) {
        return model.imagePreviewId != -1;
    }
}
