package br.ufg.ecommerce.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.ufg.ecommerce.ProductDetailsActivity;
import br.ufg.ecommerce.R;
import br.ufg.ecommerce.entity.Product;

public class CatalogItemAdapter extends RecyclerView.Adapter<CatalogItemAdapter.ViewHolder> {
    private ArrayList<Product> products;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View v;

        public TextView tvName;
        public TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            tvName = v.findViewById(R.id.item_product_name);
            tvDescription = v.findViewById(R.id.item_product_description);
        }
    }

    public CatalogItemAdapter(Context ctx, ArrayList<Product> products) {
        this.context = ctx;
        this.products = products;
    }

    @NonNull
    @Override
    public CatalogItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.catalog_item_view, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Product product = this.products.get(i);
        viewHolder.tvName.setText(product.getName());
        viewHolder.tvDescription.setText(String.valueOf(product.getPrice()));
        viewHolder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click: " + product.getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("productId", product.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }
}
