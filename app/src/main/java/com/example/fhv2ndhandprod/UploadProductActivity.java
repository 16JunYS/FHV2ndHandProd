package com.example.fhv2ndhandprod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class UploadProductActivity extends AppCompatActivity{
    private EditText productNameEditText, productDescriptionEditText, productPriceEditText;
    private ImageView productImageView;
    private Button uploadButton;

    private Product newProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadproductgui);
        productNameEditText = (EditText) findViewById(R.id.productNameEditText);
        productDescriptionEditText = (EditText) findViewById(R.id.productDescriptionEditText);
        productImageView = (ImageView) findViewById(R.id.productImageView);
        productPriceEditText = (EditText) findViewById(R.id.productPriceEditText);
        uploadButton = (Button) findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                createNewProduct();
            }
        });
    }

    private void createNewProduct() {
        newProduct.setName(productNameEditText.getText().toString());
        newProduct.setDescription(productDescriptionEditText.getText().toString());
        //set Image
        newProduct.setPrice(Double.parseDouble(productPriceEditText.getText().toString()));

        if(validateNewProduct(newProduct)) {
            //save into db
        }
    }

    private boolean validateNewProduct(Product product) {
        if(product.getId() == 0) {
            return false;
        }

        if(product.getName() == null) {
            productNameEditText.setText("Enter a name");
            productNameEditText.setBackgroundColor(16711680);
            return false;
        }

        if(product.getPrice() <= 0) {
            productPriceEditText.setText("Set a price above 0");
            productPriceEditText.setBackgroundColor(16711680);
            return false;
        }
        return true;
    }
}
