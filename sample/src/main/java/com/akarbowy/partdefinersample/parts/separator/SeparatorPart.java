package com.akarbowy.partdefinersample.parts.separator;


import com.akarbowy.partdefiner.Binder;
import com.akarbowy.partdefiner.SinglePartDefinition;
import com.akarbowy.partdefinersample.Story;
import com.akarbowy.partdefinersample.parts.ViewType;

public class SeparatorPart implements SinglePartDefinition<Story, SeparatorView> {
    @Override public int getViewType() {
        return ViewType.SEPARATOR;
    }

    @Override public Binder<SeparatorView> createBinder(Story model) {
        return new SeparatorBinder();
    }

    @Override public boolean isNeeded(Story model) {
        return true;
    }
}
