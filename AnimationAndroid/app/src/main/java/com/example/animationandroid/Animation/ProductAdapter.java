package com.example.animationandroid.Animation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animationandroid.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private Context context;
    private ArrayList<Product> mlistProduct;

    public ProductAdapter(Context context) {
        this.context = context;
        this.mlistProduct = mlistProduct;
    }
    public void setData(ArrayList<Product> list)
    {
        mlistProduct=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listfloding,null,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mlistProduct.get(position);
        if (product==null)
        {
            return;
        }
        holder.tvContentProduce.setText(product.getContent());
        holder.tvTitleProduce.setText(product.getTitle());
        holder.flodingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.flodingCell.toggle(false);
            }
        });
    }
    public void replace()
    {
        context=null;
    }
    @Override
    public int getItemCount() {
        return mlistProduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
       private FoldingCell flodingCell;
        private TextView tvTitleProduce;
        private TextView tvContentProduce;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            flodingCell=itemView.findViewById(R.id.folding_cell);
            tvTitleProduce=itemView.findViewById(R.id.tv_title_product);
            tvContentProduce=itemView.findViewById(R.id.tv_content_product);
        }
    }
}
