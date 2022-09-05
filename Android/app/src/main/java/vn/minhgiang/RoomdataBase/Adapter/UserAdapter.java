package vn.minhgiang.RoomdataBase.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.minhgiang.RoomdataBase.DTO.User;
import vn.minhgiang.list.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> mlistUser;
    private iClickItemUser iClickItemUserRecycleAdapter;
    public interface iClickItemUser
    {
        void update(User user);

        void delete(User user);
    }

    public UserAdapter(iClickItemUser iClickItemUserRecycleAdapter) {
        this.iClickItemUserRecycleAdapter = iClickItemUserRecycleAdapter;
    }

    public void setData(List<User> list)
    {
        this.mlistUser=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_user,null,false);
        return new  UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            User user = mlistUser.get(position);
            if (user==null)
            {
                return;
            }

            holder.tvUsername.setText(user.getUserName());
            holder.tvAddress.setText(user.getAddress());
            holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickItemUserRecycleAdapter.update(user);
                }
            });
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickItemUserRecycleAdapter.delete(user);
                }
            });
    }

    @Override
    public int getItemCount() {
        if (mlistUser!=null)
        {
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvUsername;
        private TextView tvAddress;
        private Button btnUpdate;
        private Button btnDelete;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername=itemView.findViewById(R.id.nameUser);
            tvAddress=itemView.findViewById(R.id.nameAddress);
            btnUpdate=itemView.findViewById(R.id.btnUpdateRoom);
            btnDelete=itemView.findViewById(R.id.btnDeleteRoom);
        }
    }
}
