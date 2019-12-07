package com.zoe.kydialog.header;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zoe.kydialog.Constant;
import com.zoe.kydialog.KyAdapter;
import com.zoe.kydialog.R;

public class BriefHeaderAdapter implements KyAdapter {

    /**
     * 布局的View
     */
    private View view;

    /**
     * 标题的TextView
     */
    private TextView textView;

    /**
     * 显示的标题
     */
    private String title="标题";

    /**
     * 标题文字的文字，默认为{@linkplain Gravity}.CENTER
     */
    private int gravity = Gravity.CENTER;

    /**
     * 标题文字大小，默认为{@linkplain Constant}.TITLE_TEXT_SIZE
     */
    private float textSize=Constant.TITLE_TEXT_SIZE;

    /**
     * 字体颜色，默认为{@linkplain Constant}.COLOR_BLACK_HEIGHT_LIGHT
     */
    private int textColor=Constant.COLOR_BLACK_HEIGHT_LIGHT;

    public BriefHeaderAdapter(Context context){
        view = LayoutInflater.from(context)
                .inflate(R.layout.header_brief,null);
        textView=view.findViewById(R.id.kydialog_brief_header_title);
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
        TextView textView=view.findViewById(R.id.kydialog_brief_header_title);
        textView.setText(title);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textView.setTextColor(textColor);
        textView.setGravity(gravity);
    }

    /**
     * 设置标题文字颜色，默认为{@linkplain Constant}.COLOR_BLACK_HEIGHT_LIGHT
     * @param color 颜色
     * @return
     */
    public BriefHeaderAdapter setTextColor(int color){
        textView.setTextColor(color);
        return this;
    }

    /**
     * 设置标题，默认为“标题”
     * @param title 标题
     * @return
     */
    public BriefHeaderAdapter setTitle(String title){
        textView.setText(title);
        return this;
    }

    /**
     * 设置标题文字位置，默认为{@linkplain Gravity}.CENTER
     * @param gravity 标题文字位置，必须是{@linkplain Gravity}的常量
     * @return
     */
    public BriefHeaderAdapter setTitleGravity(int gravity){
        textView.setGravity(gravity);
        return this;
    }


}
