package com.antelope.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> mFruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        //布局效果
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(mFruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits(){
        for (int i = 0; i< 2; i++){
            Fruit apple = new Fruit("Apple",R.drawable.ic_launcher_foreground);
            mFruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.ic_launcher_foreground);
            mFruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.ic_launcher_foreground);
            mFruitList.add(orange);
            Fruit pear = new Fruit("Pear",R.drawable.ic_launcher_foreground);
            mFruitList.add(pear);
            Fruit mango = new Fruit("Mango",R.drawable.ic_launcher_foreground);
            mFruitList.add(mango);
            Fruit cherry = new Fruit("Cherry",R.drawable.ic_launcher_foreground);
            mFruitList.add(cherry);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.ic_launcher_foreground);
            mFruitList.add(strawberry);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.ic_launcher_foreground);
            mFruitList.add(pineapple);
        }
    }
}
