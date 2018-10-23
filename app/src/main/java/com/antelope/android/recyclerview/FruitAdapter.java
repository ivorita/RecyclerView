package com.antelope.android.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    //传入要展示的数据源，并赋值给一个全局变量mFruitList。
    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    //创建一个内部类ViewHolder，继承于RecyclerView.ViewHolder。
    static class ViewHolder extends RecyclerView.ViewHolder {
        //用来保存子项最外层布局的实例
        View fruitView;
        ImageView iv;
        TextView tv;

        /**
         * @param itemView ViewHolder的构造要传入一个View参数，这个参数通常就是RecyclerView子项的最外层布局
         */
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }

    }


    //用于创建ViewHolder实例
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //将item布局加载进来
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        //将view传入构造函数中
        final ViewHolder holder = new ViewHolder(view);
        //注册子项最外层布局的点击事件。
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户点击的position
                int position = holder.getAdapterPosition();
                //通过position拿到相应的Fruit实例。
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"clicked view " + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        //注册子项中ImageView的点击事件。
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"clicked image " + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        //最后将ViewHolder实例返回
        return holder;
    }

    //此方法用于对子项的数据进行赋值，会在每个子项滚动到屏幕时执行。
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Fruit fruit = mFruitList.get(position);
        viewHolder.iv.setImageResource(fruit.getImageId());
        viewHolder.tv.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}
