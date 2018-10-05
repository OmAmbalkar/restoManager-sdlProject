package com.example.chira.restomanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    ArrayList<String> mDataSet  ;
    Cart cart = new Cart();
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {

        }
    };

    public RecyclerAdapter(ArrayList<String> myDataSet){
        mDataSet = new ArrayList<>() ;
        mDataSet = myDataSet;
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, int position) {

        holder.itemTextView.setText(mDataSet.get(position));
        holder.countButton.setText("0");
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = Integer.parseInt(holder.countButton.getText().toString());
                if(c != 0)
                    c--;
                holder.countButton.setText(String.valueOf(c));
                cart.setItemQuantity(c);

            }
        });
        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = Integer.parseInt(holder.countButton.getText().toString());
                c++;
                holder.countButton.setText(String.valueOf(c));
                cart.setItemQuantity(c);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTextView;
        public Button plusButton;
        public Button minusButton;
        public TextView countButton;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.itemName);
            plusButton = itemView.findViewById(R.id.plus);
            minusButton = itemView.findViewById(R.id.minus);
            countButton = itemView.findViewById(R.id.textView4);
        }
    }
}
