package com.zoe.kydialog.content;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zoe.kydialog.KyAdapter;
import com.zoe.kydialog.R;

import java.util.List;

public class SimpleListContent implements KyAdapter {

    /**
     * 布局的View
     */
    private View view;

    /**
     * 展示的textList
     */
    private List<String> textList;

    /**
     * 打对勾的位置
     */
    private int rightPosition;

    /**
     * RecyclerView
     */
    private final RecyclerView recyclerView;
    private final LinearLayoutManager layoutManager;

    public SimpleListContent(Context context){
        view = LayoutInflater.from(context)
                .inflate(R.layout.content_list_simple,null);
        recyclerView = view.findViewById(R.id.kydialog_content_simple_list_RV);
        layoutManager = new LinearLayoutManager(context);
    }

    @Override
    public View getView() {
        SimpleListAdapter adapter = new SimpleListAdapter(textList,rightPosition);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    /**
     * 设置显示数据
     * @param textList 文字列表
     * @param rightPosition 对勾的位置，可以-1不显示
     */
    public void setData(List<String> textList,int rightPosition){
        this.textList = textList;
        this.rightPosition = rightPosition;
    }

}
