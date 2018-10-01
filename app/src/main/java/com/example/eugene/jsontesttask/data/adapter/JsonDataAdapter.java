package com.example.eugene.jsontesttask.data.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eugene.jsontesttask.R;
import com.example.eugene.jsontesttask.data.model.JsonDataModel;

import java.util.List;

public class JsonDataAdapter extends RecyclerView.Adapter<JsonDataAdapter.ViewHolder> {
    private final List<JsonDataModel> jsonDataModelList;

    public JsonDataAdapter(final List<JsonDataModel> jsonDataModelList) {
        this.jsonDataModelList = jsonDataModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_json_data, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(jsonDataModelList.get(i));
    }

    @Override
    public int getItemCount() {
        return jsonDataModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView name;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvID);
            name = itemView.findViewById(R.id.tvName);
        }

        void bind(final JsonDataModel item) {
            id.setText(String.valueOf(item.getId()));
            name.setText(item.getName());
        }
    }
}
