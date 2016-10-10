package com.akarbowy.partdefinersample;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.akarbowy.partdefiner.PartManager;
import com.akarbowy.partdefinersample.parts.ViewType;
import com.akarbowy.partdefinersample.parts.content.ContentPart;
import com.akarbowy.partdefinersample.parts.content.ContentView;
import com.akarbowy.partdefinersample.parts.embed.EmbedPart;
import com.akarbowy.partdefinersample.parts.embed.FileEmbedView;
import com.akarbowy.partdefinersample.parts.embed.ImageEmbedView;
import com.akarbowy.partdefinersample.parts.header.HeaderPart;
import com.akarbowy.partdefinersample.parts.header.HeaderView;
import com.akarbowy.partdefinersample.parts.separator.SeparatorPart;
import com.akarbowy.partdefinersample.parts.separator.SeparatorView;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.PartHolder> {

    private PartManager<Story> storyPartManager;

    public FeedAdapter() {
        storyPartManager = new PartManager<>();
        storyPartManager.add(new SeparatorPart());
        storyPartManager.add(new HeaderPart());
        storyPartManager.add(new ContentPart());
        storyPartManager.add(new EmbedPart());
        storyPartManager.add(new SeparatorPart());
    }

    public void setItems(List<Story> stories) {
        storyPartManager.setItemsForBinding(stories);
        notifyDataSetChanged();
    }

    @Override public PartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewType.SEPARATOR:
                return new PartHolder(new SeparatorView(parent.getContext()));
            case ViewType.HEADER:
                return new PartHolder(new HeaderView(parent.getContext()));
            case ViewType.CONTENT:
                return new PartHolder(new ContentView(parent.getContext()));
            case ViewType.EMBED_IMAGE:
                return new PartHolder(new ImageEmbedView(parent.getContext()));
            case ViewType.EMBED_FILE:
                return new PartHolder(new FileEmbedView(parent.getContext()));
            default:
                throw new RuntimeException("Unsupported view type.");
        }
    }

    @Override public void onBindViewHolder(PartHolder holder, int position) {
        storyPartManager.getBinder(position).bind(holder.partView);
    }

    @Override public int getItemCount() {
        return storyPartManager.getItemCount();
    }

    @Override public int getItemViewType(int position) {
        return storyPartManager.getItemViewType(position);
    }

    static class PartHolder extends RecyclerView.ViewHolder {
        View partView;

        PartHolder(View view) {
            super(view);
            this.partView = view;
        }
    }
}
