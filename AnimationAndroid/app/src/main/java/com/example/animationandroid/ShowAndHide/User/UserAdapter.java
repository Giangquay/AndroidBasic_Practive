package com.example.animationandroid.ShowAndHide.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animationandroid.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<ViewHolderUser>{
    Context context;
    List<String> list;

    public UserAdapter(Context context,List<String>list) {
        this.context = context;
        this.list=list;
        notifyDataSetChanged();
    }
    public void replace()
    {
        context=null;
    }
    @NonNull
    @Override
    public ViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdanhsachuser,parent,false);
        return new ViewHolderUser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUser holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class ViewHolderUser extends RecyclerView.ViewHolder{

    TextView textView;
    public ViewHolderUser(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.ViewUser);
    }
}
