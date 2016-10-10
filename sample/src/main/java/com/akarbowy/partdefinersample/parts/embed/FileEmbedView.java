package com.akarbowy.partdefinersample.parts.embed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akarbowy.partdefinersample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileEmbedView extends FrameLayout {

    @BindView(R.id.file_name) TextView textView;

    public FileEmbedView(Context context) {
        super(context);
        ButterKnife.bind(this, inflate(context, R.layout.item_story_embed_file, this));
        setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
    }

    public void setFilename(String name) {
        textView.setText(name);
    }

}
