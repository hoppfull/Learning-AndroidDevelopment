package com.example.hoppf.ex14_masterdetail;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class GeneralAdapter<T, U extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<U> {
    private final T[] items;
    private final @LayoutRes int id;
    private final Builder<T, U> builder;

    public GeneralAdapter(T[] items, @LayoutRes int id, Builder<T, U> builder) {
        this.items = items;
        this.id = id;
        this.builder = builder;
    }

    @Override
    public U onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(id, parent, false);
        return builder.viewHolderBuilder(viewGroup);
    }

    @Override
    public void onBindViewHolder(U holder, int position) {
        builder.viewHolderBinder(holder, items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public interface Builder<T, U extends RecyclerView.ViewHolder> {
        U viewHolderBuilder(ViewGroup viewGroup);
        void viewHolderBinder(U viewHolder, T item);
    }
}
