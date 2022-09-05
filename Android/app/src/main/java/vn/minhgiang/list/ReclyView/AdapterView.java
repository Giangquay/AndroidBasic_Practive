package vn.minhgiang.list.ReclyView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.minhgiang.list.Item;
import vn.minhgiang.list.R;

import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder>{
    private List<Item> items;
    private Item item;
//    private Context mcontext;
    private MyItemClick<Item> itemClick;
    public AdapterView(List<Item> items,MyItemClick<Item> itemClick) {
//        Context context
        this.items = items;
//        this.mcontext = context;
        this.itemClick=itemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Item item = items.get(position);
            if (item==null)
            {
                return;
            }
        holder.im_item.setImageResource(item.getmImage());
        holder.tv_name.setText(item.getmName());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.OnclickItemListener(item);
            }
        });
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onclick(View view, int position, boolean isLongclick) {
//                if(isLongclick)
//                {
//                    Toast.makeText(mcontext, "Long Click: ", Toast.LENGTH_SHORT).show();
//                }else
//                {
//                    Intent intent = new Intent(mcontext,MainActivity.class);
////                    Bundle bundle = new Bundle();
////                    bundle.putSerializable("dulieu",item.getmName());
////                    intent.putExtras(bundle);
//                    intent.putExtra("dulieu",item.getmName());
//                    mcontext.startActivity(intent);
//
//                }
//            }
//        });
    }
//    public void replease()
//    {
//        mcontext=null;
//    }
    @Override
    public int getItemCount() {
        if (items!=null)
        {
            return items.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder
//            implements View.OnClickListener,View.OnLongClickListener
    {

        ImageView im_item;
        TextView tv_name;
        LinearLayout layoutItem;
        private ItemClickListener itemClickListener;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im_item = itemView.findViewById(R.id.im_item);
            tv_name = itemView.findViewById(R.id.tv_name);
            layoutItem=itemView.findViewById(R.id.layoutItem);
//            itemView.setOnLongClickListener(this);
//            itemView.setOnClickListener(this);
        }
//        public void setItemClickListener(ItemClickListener itemClickListener)
//        {
//            this.itemClickListener = itemClickListener;
//        }
//        @Override
//        public void onClick(View v) {
//            itemClickListener.onclick(v,getAdapterPosition(),false);
//        }
//
//        @Override
//        public boolean onLongClick(View v) {
//            itemClickListener.onclick(v,getAdapterPosition(),true);
//            return true;
//        }
    }
}
