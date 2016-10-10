package com.akarbowy.partdefinersample.parts.embed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.akarbowy.partdefinersample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageEmbedView extends FrameLayout {

    @BindView(R.id.image_preview) ImageView imageView;

    public ImageEmbedView(Context context) {
        super(context);
        ButterKnife.bind(this, inflate(context, R.layout.item_story_embed_image, this));
        setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
    }

    public void setPreview(int resId) {
        imageView.setImageResource(resId);
    }

}
