package com.example.wallart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageModel> modelClasslist;
    private RecyclerView recyclerView;
    Adapter adapter;
    CardView mnature , manimals , mcar , mspace , mtrending ;

    EditText editText ;
    ImageButton search;

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SettingFragment settingsFragment = new SettingFragment();
    LikedFragment LikedFragment = new LikedFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recyclerview);
        mnature = findViewById(R.id.nature);
        manimals = findViewById(R.id.animals);
        mcar = findViewById(R.id.car);
        mspace = findViewById(R.id.space);
        mtrending = findViewById(R.id.trending);

        editText = findViewById(R.id.edittext);
        search=findViewById(R.id.search);


        modelClasslist = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        recyclerView.setHasFixedSize(true);
        adapter = new Adapter(getApplicationContext() , modelClasslist);
        recyclerView.setAdapter(adapter);
        findphotos();

        mnature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "nature";
                getSearchimage(query);
            }
        });

        manimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "animals";
                getSearchimage(query);
            }
        });

        mcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "car";
                getSearchimage(query);
            }
        });

        mspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "space";
                getSearchimage(query);
            }
        });

        mtrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "trending";
                getSearchimage(query);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = editText.getText().toString().trim().toLowerCase();
                if (query.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Something", Toast.LENGTH_SHORT).show();
                }
                else {
                    getSearchimage(query);
                }
            }
        });


        bottomNavigationView  = findViewById(R.id.bottom_navigation);

        //getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;

                    case R.id.like:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,LikedFragment).commit();
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
                        return true;
                }

                return false;
            }
        });





    }
    public void Show_Activity(MenuItem item){
        Intent intent=new Intent(this.getApplicationContext(),MainActivity3.class);
        startActivity(intent);
    }

    public void Show_Setting(MenuItem item){
        Intent intent = new Intent(this.getApplicationContext(),Settings.class);
        startActivity(intent);
    }

    private void getSearchimage(String query) {

        ApiUtilities.getApiInterface().getSearchImage(query ,  1 , 80).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {


                modelClasslist.clear();
                if(response.isSuccessful())
                {

                    modelClasslist.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
                else {

                    Toast.makeText(MainActivity.this, "Not Able to get Images", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });

    }

    private void findphotos() {

        modelClasslist.clear();
        ApiUtilities.getApiInterface().getImage(1,80).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {

                if(response.isSuccessful())
                {

                    modelClasslist.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
                else {

                    Toast.makeText(MainActivity.this, "Not Able to get Images", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {

            }
        });



    }
}