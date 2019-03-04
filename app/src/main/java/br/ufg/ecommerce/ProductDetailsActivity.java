package br.ufg.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import br.ufg.ecommerce.entity.Product;

public class ProductDetailsActivity extends AppCompatActivity {
    private TextView id;
    private TextView name;
    private TextView price;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        this.id = (TextView) findViewById(R.id.tv_detail_name_product_id);
        this.name = (TextView) findViewById(R.id.tv_detail_name_product_name);
        this.price = (TextView) findViewById(R.id.tv_detail_name_product_price);
        this.description = (TextView) findViewById(R.id.tv_detail_name_product_description);
        String jsonProduct = getIntent().getExtras().getString("jsonProduct");
        Product product = new Product();
        product = new Gson().fromJson(jsonProduct, Product.class);
        this.id.setText(product.getId());
        this.name.setText(product.getName());
        this.price.setText(product.getPrice().toString());
        this.description.setText(product.getDescription());

    }

    private void getProductDetails(String id) {

    }
}
