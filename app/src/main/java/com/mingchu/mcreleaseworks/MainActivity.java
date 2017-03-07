package com.mingchu.mcreleaseworks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    Items items = new Items();

    MultiTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();

        adapter.register(UpLoadFoodMessage.class,new FoodValueItemViewProvider(adapter,items));


        loadData();

        assertAllRegistered(adapter, items);
        mRecyclerView.setAdapter(adapter);

    }

    private void loadData() {
        Category category_one = new Category("主料",R.mipmap.fooddetails_materials);
        items.add(category_one);
        items.add(new UpLoadFoodMessage(1));

        Category category_two = new Category("辅料",R.mipmap.fooddetails_accessories);
        items.add(category_two);
        items.add(new UpLoadFoodMessage(2));

        Category category_three = new Category("调料",R.mipmap.fooddetails_seasoning);
        items.add(category_three);
        items.add(new UpLoadFoodMessage(3));

        Category category_four = new Category("做法",R.mipmap.icon_step);
        items.add(category_four);
        items.add(new UpLoadFoodMessage(4));

        adapter.setItems(items);
        adapter.notifyDataSetChanged();

    }
}
