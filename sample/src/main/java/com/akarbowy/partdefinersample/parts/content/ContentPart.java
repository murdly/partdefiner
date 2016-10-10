package com.akarbowy.partdefinersample.parts.content;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefiner.SinglePartDefinition;
import com.akarbowy.partdefinersample.Story;
import com.akarbowy.partdefinersample.parts.ViewType;


public class ContentPart implements SinglePartDefinition<Story, ContentView> {
    @Override public int getViewType() {
        return ViewType.CONTENT;
    }

    @Override public Binder<ContentView> createBinder(Story model) {
        return new ContentBinder(model);
    }

    @Override public boolean isNeeded(Story model) {
        return !model.content.isEmpty();
    }
}
