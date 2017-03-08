package com.mingchu.mcreleaseworks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;


public class FoodValueItemViewProviderThree extends ItemViewProvider<UpLoadFoodMessageThree, FoodValueItemViewProviderThree.FoodItemHolder> {

    private MultiTypeAdapter mMultiTypeAdapter;
    private Items mItems;

    private static boolean isAdd = false;

    public FoodValueItemViewProviderThree() {
    }

    public FoodValueItemViewProviderThree(MultiTypeAdapter adapter, Items items) {
        this.mMultiTypeAdapter = adapter;
        this.mItems = items;
    }

    public FoodValueItemViewProviderThree(MultiTypeAdapter adapter, List<UpLoadFoodMessageThree> upLoadFoodMessageThrees) {


    }

    @NonNull
    @Override
    protected FoodItemHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.upload_layout, parent, false);
        return new FoodItemHolder(root);
    }


    @Override
    protected void onBindViewHolder(@NonNull final FoodItemHolder holder, final UpLoadFoodMessageThree upLoadFoodMessage) {
        if (upLoadFoodMessage.getKey() == null) {
            holder.mKey.setText("");
        }
        if (upLoadFoodMessage.getValue() == null) {
            holder.mValue.setText("");
        }

        holder.mKey.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }


    class FoodItemHolder extends RecyclerView.ViewHolder {

        private EditText mKey, mValue;

        public FoodItemHolder(View itemView) {
            super(itemView);

            mKey = (EditText) itemView.findViewById(R.id.upload2uselist_name);
            mValue = (EditText) itemView.findViewById(R.id.upload2uselist_value);
        }
    }
}
