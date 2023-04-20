package com.example.wallart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.wallart.databinding.ActivityGirdViewItemsBinding;
import com.example.wallart.databinding.ActivityMainBinding;

public class GirdViewItems extends AppCompatActivity {

    ActivityGirdViewItemsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGirdViewItemsBinding.inflate(getLayoutInflater());
        System.out.println(binding.getRoot());
        setContentView(R.layout.activity_gird_view_items);

        int[] flowerImages = {R.drawable.carimg1,R.drawable.carimg2,R.drawable.carimg3,R.drawable.carimg4};

        GridAdapter gridAdapter = new GridAdapter(GirdViewItems.this,flowerImages);
        binding.gridView.setAdapter(gridAdapter);



        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GirdViewItems.this,"Liked Images ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}