package com.zoe.kydialog.briefdialog;

import android.content.Context;
import android.view.Gravity;

import com.zoe.kydialog.KyDialog;
import com.zoe.kydialog.content.SimpleListContent;
import com.zoe.kydialog.header.BriefHeaderAdapter;

import java.util.List;

public class SimpleListDialog extends KyDialog {

    private SimpleListContent simpleListContent;
    private BriefHeaderAdapter briefHeaderAdapter;

    public SimpleListDialog(Context context) {
        super(context);
        simpleListContent = new SimpleListContent(context);
        briefHeaderAdapter = new BriefHeaderAdapter(context);
        setHeaderAdapter(briefHeaderAdapter);
        setContentAdapter(simpleListContent);

        //设置标题靠左
        briefHeaderAdapter.setTitleGravity(Gravity.LEFT);
        //设置圆角
        setCorner(30,30);
        //设置位置
        setGravity(Gravity.CENTER);
    }

    /**
     * 设置显示数据
     * @param textList textList
     * @param rightPosition 对勾的位置，可以写-1不显示
     * @return this
     */
    public SimpleListDialog setListData(List<String> textList,int rightPosition){
        simpleListContent.setData(textList,rightPosition);
        return this;
    }

    /**
     * 设置显示数据
     * @param textList textList
     * @return this
     */
    public SimpleListDialog setListData(List<String> textList){
        setListData(textList,-1);
        return this;
    }

    /**
     * 设置标题
     * @param title 标题
     * @return this
     */
    public SimpleListDialog setTitle(String title){
        briefHeaderAdapter.setTitle(title);
        return this;
    }

    /**
     * 设置标题位置，必须为Gravity类的常量，默认为Gravity.LEFT
     * @param gravity 必须为Gravity类的常量
     * @return this
     */
    public SimpleListDialog setTitleGravity(int gravity){
        briefHeaderAdapter.setTitleGravity(gravity);
        return this;
    }

}
