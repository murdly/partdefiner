package com.akarbowy.partdefinersample.parts.header;

import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefiner.SinglePartDefinition;
import com.akarbowy.partdefinersample.Story;
import com.akarbowy.partdefinersample.parts.ViewType;

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
