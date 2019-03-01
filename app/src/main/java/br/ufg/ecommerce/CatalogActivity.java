package br.ufg.ecommerce;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import br.ufg.ecommerce.adapter.CatalogItemAdapter;
import br.ufg.ecommerce.entity.Product;

public class CatalogActivity extends AppCompatActivity {
    private ArrayList<Product> products;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.products = getProducts();
        recyclerView = (RecyclerView) findViewById(R.id.rv_products_items);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new CatalogItemAdapter(this, this.products);
        recyclerView.setAdapter(mAdapter);

    }

    private ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Produto 1", 122.5, "Descrição 1"));
        products.add(new Product("Produto 2", 22.5, "Descrição 2"));
        products.add(new Product("Produto 3", 182.7, "Descrição 3"));
        products.add(new Product("Produto 4", 12.5, "Descrição 4"));
        products.add(new Product("Produto 5", 52.0, "Descrição 5"));
        products.add(new Product("Produto 6", 12.5, "Descrição 4"));
        products.add(new Product("Produto 7", 12.5, "Descrição 4"));
        products.add(new Product("Produto 8", 12.5, "Descrição 4"));
        products.add(new Product("Produto 9", 12.5, "Descrição 4"));


        return products;
    }

}
