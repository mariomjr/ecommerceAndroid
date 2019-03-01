package br.ufg.ecommerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.ufg.ecommerce.entity.Product;

public class AddProductActivity extends AppCompatActivity {

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference productsRef = mRootRef.child("products");

    private EditText etName;
    private EditText etDescription;
    private EditText etValue;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        etName = (EditText) findViewById(R.id.et_add_product_name);
        etDescription = (EditText) findViewById(R.id.et_add_product_desc);
        etValue = (EditText) findViewById(R.id.et_add_product_value);
        btnSave = (Button) findViewById(R.id.btn_add_product_save);
    }

    public void saveProduct(View v) {
        String key = productsRef.push().getKey();
        Product product = this.createProduct();
        productsRef.child(key).setValue(product).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Teste", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Product createProduct() {
        String name = etName.getText().toString();
        String desc = etDescription.getText().toString();
        Double value = Double.valueOf(etValue.getText().toString());
        return new Product(name, value, desc);
    }

    private void clearFields() {
        etName.setText("");
        etDescription.setText("");
        etValue.setText("");
    }
}
