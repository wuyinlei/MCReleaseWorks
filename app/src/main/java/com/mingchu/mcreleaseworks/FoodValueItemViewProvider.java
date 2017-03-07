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

import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;


public class FoodValueItemViewProvider extends ItemViewProvider<UpLoadFoodMessage, FoodValueItemViewProvider.FoodItemHolder> {

    private MultiTypeAdapter mMultiTypeAdapter;
    private Items mItems;

    private static boolean isAdd = false;
    private static boolean isAdd_one = true;

    public FoodValueItemViewProvider() {
    }

    public FoodValueItemViewProvider(MultiTypeAdapter adapter, Items items) {
        this.mMultiTypeAdapter = adapter;
        this.mItems = items;
    }

    @NonNull
    @Override
    protected FoodItemHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.upload_layout, parent, false);
        return new FoodItemHolder(root);
    }


    @Override
    protected void onBindViewHolder(@NonNull final FoodItemHolder holder, final UpLoadFoodMessage upLoadFoodMessage) {
        if (upLoadFoodMessage.getKey() == null) {
            holder.mKey.setText("");
        }
        if (upLoadFoodMessage.getValue() == null) {
            holder.mValue.setText("");
        }

        isAdd_one = !holder.mKey.hasFocus();


        holder.mKey.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                boolean focusable = holder.mKey.hasFocusable();


                int indexOf = mItems.indexOf(upLoadFoodMessage);

                int position = holder.getLayoutPosition();
                int mode = upLoadFoodMessage.getMODE();

                int pos = 0;

                for (int i = 0; i < mItems.size(); i++) {
                    if (mItems.get(i) instanceof UpLoadFoodMessage)
                        if (((UpLoadFoodMessage) mItems.get(i)).getMODE() == mode)
                            pos++;
                }


                isAdd = pos == position;

                if (isAdd)

                {


                    if (s.length() > 0) {


                        switch (upLoadFoodMessage.getMODE()) {


                            case UpLoadFoodMessage.INGRAEDIENTS:
                                Toast.makeText(holder.itemView.getContext(), "我是主料", Toast.LENGTH_SHORT).show();

                                upLoadFoodMessage.setKey(s.toString());

                                mItems.add(indexOf, new UpLoadFoodMessage(1));

                                mMultiTypeAdapter.notifyItemChanged(indexOf, 1);

                                break;
                            case UpLoadFoodMessage.ACCESSORIES:
                                Toast.makeText(holder.itemView.getContext(), "我是辅料", Toast.LENGTH_SHORT).show();

                                mItems.add(indexOf, new UpLoadFoodMessage(2));
                                break;

                            case UpLoadFoodMessage.SEASONING:
                                Toast.makeText(holder.itemView.getContext(), "我是调料", Toast.LENGTH_SHORT).show();

                                mItems.add(indexOf, new UpLoadFoodMessage(2));
                                break;

                            case UpLoadFoodMessage.METHOD:
                                Toast.makeText(holder.itemView.getContext(), "我是做法", Toast.LENGTH_SHORT).show();
                                mItems.add(indexOf, new UpLoadFoodMessage(2));

                                break;
                        }
                    }
                }
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
