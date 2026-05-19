package com.example.humanitasconnect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ActionViewHolder> {

    private List<ActionModel> actionList;

    public ActionAdapter(List<ActionModel> actionList) {
        this.actionList = actionList;
    }

    @NonNull
    @Override
    public ActionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_action, parent, false);
        return new ActionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionViewHolder holder, int position) {
        ActionModel action = actionList.get(position);
        holder.tvTitle.setText(action.getTitle());
        holder.tvDescription.setText(action.getDescription());
        holder.tvTarget.setText("Cilj: " + action.getTarget() + " KM");
    }

    @Override
    public int getItemCount() {
        return actionList.size();
    }


    public void filterList(List<ActionModel> filteredList) {
        this.actionList = filteredList;
        notifyDataSetChanged();
    }

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvTarget;

        public ActionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTarget = itemView.findViewById(R.id.tvTarget);
        }
    }
}