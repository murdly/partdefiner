package com.akarbowy.partdefinersample.parts.header;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akarbowy.partdefinersample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderView extends RelativeLayout {

    @BindView(R.id.avatar) ImageView avatarView;
    @BindView(R.id.text_author) TextView authorView;
    @BindView(R.id.text_date) TextView dateView;

    public HeaderView(Context context) {
        super(context);
        ButterKnife.bind(this, inflate(context, R.layout.item_story_header, this));
    }

    public void setAvatarColor(int color) {
        avatarView.setBackgroundColor(color);
    }

    public void setTitle(String author) {
        authorView.setText(author);
    }

    public void setDate(String date) {
        dateView.setText(date);
    }

}
