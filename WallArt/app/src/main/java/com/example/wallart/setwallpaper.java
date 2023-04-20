package com.example.wallart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;

public class setwallpaper extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    Button set;


    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();

    DownloadFragment DownloadFragment = new DownloadFragment();

    WallpaperLikedFragment WallpaperLikedFragment = new WallpaperLikedFragment();


    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setwallpaper);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final WallpaperManager wallpapermanager = WallpaperManager.getInstance(getApplicationContext());
        set = findViewById(R.id.setwallpaper);
        imageView = findViewById(R.id.finalimage);
        intent = getIntent();

        String url = intent.getStringExtra("image");
        Glide.with(getApplicationContext()).load(url).into(imageView);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                    wallpapermanager.setBitmap(bitmap);
                    Toast.makeText(setwallpaper.this, "Set Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }


            }
        });


        bottomNavigationView  = findViewById(R.id.bottom_navigation1);

        //getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){

                    case R.id.download:

                        Toast.makeText(setwallpaper.this, "Image is Downloaded", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,DownloadFragment).commit();
                        return true;

                    case R.id.like2:
                        Toast.makeText(setwallpaper.this, "Wallpaper Liked", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,WallpaperLikedFragment).commit();
                        return true;
                    case R.id.creator:
                        Toast.makeText(setwallpaper.this, "Creator Details", Toast.LENGTH_SHORT).show();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
                        //return true;

                    case R.id.more:
                        Toast.makeText(setwallpaper.this, "More Settings About Wallpaper", Toast.LENGTH_SHORT).show();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
                        //return true;
                }

                return false;
            }
        });


    }

    public void Download_image(MenuItem item){
        Toast.makeText(this, "Downloaded", Toast.LENGTH_SHORT).show();
    }

    public void Liked_Image(MenuItem item){

        Toast.makeText(this, "Liked", Toast.LENGTH_SHORT).show();
    }

    public void Creator_Image(MenuItem item){

        //Toast.makeText(this, "Creator", Toast.LENGTH_SHORT).show();
        Intent browserintent = new Intent(Intent.ACTION_VIEW);
        browserintent.setData(Uri.parse("https://www.pexels.com/"));
        browserintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(browserintent);
    }

    public void More_image(MenuItem item){

        Toast.makeText(this, "More Setting About Image", Toast.LENGTH_SHORT).show();
    }
}