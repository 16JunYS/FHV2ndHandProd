package com.example.fhv2ndhandprod;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URI;

public class UploadProductActivity extends AppCompatActivity{
    private EditText productNameEditText, productDescriptionEditText, productPriceEditText;
    private String ImagePath;
    private ImageView productImageView;
    private Button uploadButton;

    private Product newProduct;

    private int GALLERY = 1, CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadproduct);
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

    public void upload_image(View view) {

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
    public void selectPhotoFromGallery(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }
    public void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //get Image data & set it in ImageView
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == this.RESULT_CANCELED) return;
        if(requestCode == GALLERY) { //uploaded from Gallery
            if(data != null) {
                Uri ProdUri = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                /*
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), ProdUri);
                    ImagePath = saveImage(bitmap);
                    Toast.makeText(UploadProductActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    productImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(UploadProductActivity.this, "Failed.", Toast.LENGTH_SHORT).show();
                }
                */
            }
        }
        else if(requestCode == CAMERA) { //uploaded from Camera
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");

            productImageView.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(UploadProductActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();

        }
    }
    private String saveImage(Bitmap bitmap) {

        return "";
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
