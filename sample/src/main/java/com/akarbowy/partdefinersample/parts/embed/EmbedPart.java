package com.akarbowy.partdefinersample.parts.embed;


import com.akarbowy.partdefiner.GroupPartDefinition;
import com.akarbowy.partdefiner.PartDefinition;
import com.akarbowy.partdefinersample.Story;

import java.util.ArrayList;
import java.util.List;

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
