package com.akarbowy.partdefinersample.parts.content;


import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akarbowy.partdefinersample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentView extends FrameLayout {

    @BindView(R.id.content) TextView contentView;

    public ContentView(Context context) {
        super(context);
        ButterKnife.bind(this, inflate(context, R.layout.item_story_content, this));
        setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void setContent(String content) {
        contentView.setText(content);
    }
}
