package com.example.heroes;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.heroes.url.Url;


public class LoadImgStrictActivity extends AppCompatActivity{

    private ImageView imgProfile;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContenView(R.layout.activity_load_image_strict_mode);
        imgProfile=findViewById(R.id.imgPhoto);
        loadFromURL();
    }

    private void StrictMode()
    {
        android.os.StrictMode.ThreadPolicy policy =
                new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }

    private void loadFromURL(){
        StrictMode();
        try{
            String imgURL = "https://www.gstatic.com/webp/gallery3/1.sm.png";
            Url url = new Url(imgURL);
            imgProfile.setImageBitmap(BitmapFactory.decodeStream((InputStream)url.getContent()));
        } catch (IOException e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}
