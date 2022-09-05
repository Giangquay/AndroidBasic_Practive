package com.example.androidlist.ListSwipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlist.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    List<ItemObject> objectList;

    public ItemAdapter(List<ItemObject> objectList) {
        this.objectList = objectList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,null,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        ItemObject itemObject=objectList.get(position);
        if (itemObject==null)
        {
            return;
        }
        holder.iItem.setText(itemObject.getName());
    }

    @Override
    public int getItemCount() {
        if (objectList!=null)
        {
            return objectList.size();
        }
        return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        TextView iItem;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            iItem=itemView.findViewById(R.id.textView);
        }
    }
}
