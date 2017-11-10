package com.volianskyi.taras.vk_app_091117;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tarasvolianskyi on 10.11.17.
 */

class ListOfVideoAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ListOfVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListOfVideoViewHolder myHolder = (ListOfVideoViewHolder) holder;
        myHolder.tvText.setText("Item - " + position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private class ListOfVideoViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public ListOfVideoViewHolder(View view) {

            super(view);
            tvText = (TextView) view.findViewById(android.R.id.text1);
        }
    }
}
