package com.tokopedia.productsearch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.activeandroid.query.From;
import com.activeandroid.query.Select;
import com.squareup.picasso.Picasso;
import com.tokopedia.productsearch.R;
import com.tokopedia.productsearch.model.Product;
import com.tokopedia.productsearch.model.ProductResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by eriksuprayogi on 5/22/16.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private static final String TAG = ProductListAdapter.class.getSimpleName();
    private List<Product> products = new ArrayList<>();
        private Context context;

        public ProductListAdapter(Context context) {
            this.context = context;
        }

    public void setProducts(List<Product> products) {
        if (products == null) {
            products = new ArrayList<>();
        }
        this.products = products;
        storeData(products);
        notifyDataSetChanged();
    }

    public void addProducts(List<Product> products) {
        if (products == null) {
            products = new ArrayList<>();
        }
        this.products.addAll(products);
        notifyItemInserted(this.products.size());
        notifyDataSetChanged();
        storeData(products);
        Log.d(TAG, "Item iserted "+this.products.size());
    }

    private void storeData(List<Product> products){
        for (Product product : products){
            From from = new Select().from(Product.class).where("product_id = ?", product.getProduct_id());
            if(!from.exists()){
                product.save();
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.product_name.setText(product.getProduct_name());
        holder.product_price.setText(product.getProduct_price());
        holder.product_store.setText(product.getShop_name());
        Picasso.with(context).load(product.getProduct_image()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        ImageView image;
        TextView product_name;
        TextView product_price;
        TextView product_store;

        public ViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            product_name = (TextView) v.findViewById(R.id.product_name);
            product_price = (TextView) v.findViewById(R.id.product_price);
            product_store = (TextView) v.findViewById(R.id.product_store);
        }

    }


}
