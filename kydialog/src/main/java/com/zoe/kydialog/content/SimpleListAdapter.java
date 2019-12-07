package com.zoe.kydialog.content;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoe.kydialog.R;
import com.zoe.kydialog.customview.RightView;

import java.util.ArrayList;
import java.util.List;

public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.ViewHolder> {

    /**
     * 显示的列表信息
     */
    private List<String> textList;

    /**
     * 对勾的位置
     */
    private int rightPosition;

    /**
     * 点击监听接口
     */
    private OnItemClickListener onItemClickListener;

    public SimpleListAdapter(List<String> textList,int rightPosition){
        this.textList = textList;
        if(textList == null){
            this.textList = new ArrayList<>();
        }
        this.rightPosition = rightPosition;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;  //子项的layout
        TextView textView;
        RightView rightView;    //对勾
        public ViewHolder(View view){
            super(view);
            itemView = view;
            textView = view.findViewById(R.id.kydialog_item_simple_list_text);
            rightView = view.findViewById(R.id.kydialog_litem_simple_list_rightView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_simple_list,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onClick(v,holder.getAdapterPosition());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(textList.get(position));    //设置文字
        if(position == rightPosition){  //设置对勾是否显示
            holder.rightView.setVisibility(View.VISIBLE);
        }else{
            holder.rightView.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * 设置点击监听
     * @param onItemClickListener 类内部的接口
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 点击接口
     */
    interface OnItemClickListener{
        void onClick(View v , int position);
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }
}
