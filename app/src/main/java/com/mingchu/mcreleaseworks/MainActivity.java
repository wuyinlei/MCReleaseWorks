package com.mingchu.mcreleaseworks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    Items items = new Items();

    MultiTypeAdapter adapter;
    List<UpLoadFoodMessage> mMessages = new ArrayList<>();
    List<UpLoadFoodMessageOne> mUpLoadFoodMessageOnes = new ArrayList<>();
    List<UpLoadFoodMessageTwp> mUpLoadFoodMessageTwps = new ArrayList<>();
    List<UpLoadFoodMessageThree> mUpLoadFoodMessageThrees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        adapter = new MultiTypeAdapter();
        adapter.applyGlobalMultiTypePool();

        adapter.register(UpLoadFoodMessage.class,new FoodValueItemViewProvider(adapter,mMessages,items));
        adapter.register(UpLoadFoodMessageOne.class,new FoodValueItemViewProviderOne(adapter,mUpLoadFoodMessageOnes));

        adapter.register(UpLoadFoodMessageTwp.class,new FoodValueItemViewProviderTwo(adapter,mUpLoadFoodMessageTwps));

        adapter.register(UpLoadFoodMessageThree.class,new FoodValueItemViewProviderThree(adapter,mUpLoadFoodMessageThrees));



        loadData();

        assertAllRegistered(adapter, items);
        mRecyclerView.setAdapter(adapter);

    }

    private void loadData() {
        Category category_one = new Category("主料",R.mipmap.fooddetails_materials);
        items.add(category_one);
        mMessages.add(new UpLoadFoodMessage());
        for (UpLoadFoodMessage message : mMessages) {
            items.add(message);
        }

        Category category_two = new Category("辅料",R.mipmap.fooddetails_accessories);
        items.add(category_two);
        mUpLoadFoodMessageOnes.add(new UpLoadFoodMessageOne());
        for (UpLoadFoodMessageOne upLoadFoodMessageOne : mUpLoadFoodMessageOnes) {
            items.add(upLoadFoodMessageOne);
        }

        Category category_three = new Category("调料",R.mipmap.fooddetails_seasoning);
        items.add(category_three);
        mUpLoadFoodMessageTwps.add(new UpLoadFoodMessageTwp());
        for (UpLoadFoodMessageTwp upLoadFoodMessageTwp : mUpLoadFoodMessageTwps) {
            items.add(upLoadFoodMessageTwp);
        }

        Category category_four = new Category("做法",R.mipmap.icon_step);
        items.add(category_four);
        mUpLoadFoodMessageThrees.add(new UpLoadFoodMessageThree());
        for (UpLoadFoodMessageThree upLoadFoodMessageThree : mUpLoadFoodMessageThrees) {
            items.add(upLoadFoodMessageThree);
        }

        adapter.setItems(items);
        adapter.notifyDataSetChanged();

    }
}
