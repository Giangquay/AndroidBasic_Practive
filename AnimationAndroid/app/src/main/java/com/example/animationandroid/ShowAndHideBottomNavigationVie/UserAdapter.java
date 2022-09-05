package com.example.animationandroid.ShowAndHideBottomNavigationVie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationandroid.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewholder>{
    private List<String> mlist;

    public void setData(List<String> mlist)
    {
        this.mlist=mlist;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user,parent,false);
        return new UserViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewholder holder, int position) {
        String userName=mlist.get(position);
        holder.name.setText(userName);
    }

    @Override
    public int getItemCount() {
        if (mlist!=null)
        {
            return mlist.size();
        }
        return 0;
    }

    class UserViewholder extends RecyclerView.ViewHolder{
        TextView name;
        public UserViewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.TexViewName);
        }
    }
}
