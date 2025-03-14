package nnminh.playground.watchstoreandroid.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.List;

import nnminh.playground.watchstoreandroid.R;
import nnminh.playground.watchstoreandroid.data.model.Product;

public class ProductGridAdapter extends RecyclerView.Adapter<ProductGridAdapter.ProductViewHolder> {

    private final Context context;
    private final List<Product> productList;
    private final DecimalFormat priceFormat = new DecimalFormat("#,### vnd");
    private final DecimalFormat soldFormat = new DecimalFormat("#,###");

    public ProductGridAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_activity_product_grid_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.txtProductName.setText(product.getName());
        holder.txtProductPrice.setText(priceFormat.format(product.getPrice()));
        holder.txtProductSold.setText(soldFormat.format(product.getSold()) + " sold");
        holder.txtProductRating.setText(String.format("%.1f ★", product.getRating()));

        // Load first image from assets using Glide
        if (!product.getAssets().isEmpty()) {
            Glide.with(context)
                    .load(product.getAssets().get(0))
                    .into(holder.imgProduct);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtProductName, txtProductPrice, txtProductSold, txtProductRating;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.productImage);
            txtProductName = itemView.findViewById(R.id.productName);
            txtProductPrice = itemView.findViewById(R.id.productPrice);
            txtProductSold = itemView.findViewById(R.id.productSold);
            txtProductRating = itemView.findViewById(R.id.productRating);
        }
    }
}