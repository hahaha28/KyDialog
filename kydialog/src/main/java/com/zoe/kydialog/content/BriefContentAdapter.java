package com.zoe.kydialog.content;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoe.kydialog.Constant;
import com.zoe.kydialog.KyAdapter;
import com.zoe.kydialog.R;

public class BriefContentAdapter implements KyAdapter {

    /**
     * 布局的View
     */
    private View view;

    /**
     * 布局中的TextView
     */
    private TextView textView;

    /**
     * 内容文字，默认为""
     */
    private String content="";

    /**
     * 字体大小，默认为{@linkplain Constant}.TEXT_SIZE_SMALL
     */
    private float textSize= Constant.TEXT_SIZE_SMALL;

    /**
     * 文字颜色，默认为{@linkplain Constant}.COLOR_BLACK_NORMAL
     */
    private int textColor = Constant.COLOR_BLACK_NORMAL;

    public BriefContentAdapter(Context context){
        view = LayoutInflater.from(context)
                .inflate(R.layout.content_brief,null);
        textView = view.findViewById(R.id.kydialog_brief_content_text);
    }

    @Override
    public View getView() {
        return view;
    }

    /**
     * 设置View的数据
     * @param view
     */
    private void setViewData(View view){
        TextView textView=view.findViewById(R.id.kydialog_brief_content_text);
        textView.setText(content);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        textView.setTextColor(textColor);
    }

    /**
     * 设置内容文字
     * @param content 展示的内容
     * @return
     */
    public BriefContentAdapter setContent(String content){
        textView.setText(content);
        return this;
    }

    /**
     * 设置字体大小
     * @param textSize 字体大小
     * @return
     */
    public BriefContentAdapter setTextSize(float textSize){
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        return this;
    }

    /**
     * 设置文字颜色
     * @param color
     * @return
     */
    public BriefContentAdapter setTextColor(int color){
        textView.setTextColor(color);
        return this;
    }

}
