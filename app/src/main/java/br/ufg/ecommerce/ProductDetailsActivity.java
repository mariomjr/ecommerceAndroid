package br.ufg.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {
    private TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        this.id = (TextView) findViewById(R.id.tv_detail_name);
        String idString = getIntent().getExtras().getString("productId");
        id.setText(idString);
    }

    private void getProductDetails(String id) {

    }
}
