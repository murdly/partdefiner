package com.akarbowy.partdefinersample.parts.separator;

import android.content.Context;
import android.widget.FrameLayout;

import com.akarbowy.partdefinersample.R;

public class SeparatorView extends FrameLayout {

    public SeparatorView(Context context) {
        super(context);
        inflate(context, R.layout.item_story_separator, this);
    }
}
