package com.zoe.kydialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class KyDialog extends Dialog {

    /**
     * 对话框头部布局
     */
    private KyAdapter headerAdapter;

    /**
     * 对话框内容布局
     */
    private KyAdapter contentAdapter;

    /**
     * 对话框底部布局
     */
    private KyAdapter footerAdapter;

    /**
     * 对话框的圆角
     */
    private boolean topCorner;
    private boolean bottomCorner;

    /**
     * 对话框的位置，默认为中间
     */
    private int gravity = Gravity.CENTER;

    public KyDialog(Context context) {
        super(context);
    }

    public KyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected KyDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        //设置window位置
        Window window = getWindow();
        window.setGravity(gravity);
        //获取屏幕大小
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Point screenSize = new Point();
        wm.getDefaultDisplay().getSize(screenSize);
        //初始化decorView
        FrameLayout decorView = (FrameLayout) window.getDecorView();
        decorView.removeAllViews();
        decorView.setBackgroundColor(0x00000000);
        decorView.setPadding(0, 0, 0, 0);
        //加载布局
        View rootView = layoutInflater    //这是最上层（除decorView）的view
                .inflate(R.layout.base_container, decorView, false);
        //设置rootView大小
        ViewGroup.LayoutParams l;
        switch (gravity) {
            case Gravity.TOP:
            case Gravity.BOTTOM:
                l = new ViewGroup.LayoutParams(screenSize.x, ViewGroup.LayoutParams.WRAP_CONTENT);
                break;
            case Gravity.CENTER:
                l = new ViewGroup.LayoutParams(screenSize.x / 5 * 4, ViewGroup.LayoutParams.WRAP_CONTENT);
                break;
            default:
                l = new ViewGroup.LayoutParams(screenSize.x / 5 * 4, ViewGroup.LayoutParams.WRAP_CONTENT);
                break;
        }
        rootView.setLayoutParams(l);
        //设置rootView圆角
        if(topCorner && bottomCorner){
            rootView.setBackgroundResource(R.drawable.shape_corner);
        }else if(topCorner){
            rootView.setBackgroundResource(R.drawable.shape_corner_top);
        }else if(bottomCorner){
            rootView.setBackgroundResource(R.drawable.shape_corner_bottom);
        }
        decorView.addView(rootView);    //添加rootView到decorView
        //设置顶部、内容、底部
        ViewGroup headerContainer = rootView.findViewById(R.id.kydialog_header_container);
        ViewGroup contentContainer = rootView.findViewById(R.id.kydialog_content_container);
        ViewGroup footerContainer = rootView.findViewById(R.id.kydialog_footer_container);
        if(headerAdapter != null){
            View headerView=layoutInflater.inflate(headerAdapter.getResId(),headerContainer,false);
            headerAdapter.setViewData(headerView);
            headerContainer.addView(headerView);
        }
        if(contentAdapter != null){
            View contentView=layoutInflater.inflate(contentAdapter.getResId(),contentContainer,false);
            contentAdapter.setViewData(contentView);
            contentContainer.addView(contentView);
        }
        if(footerAdapter != null){
            View footerView=layoutInflater.inflate(footerAdapter.getResId(),footerContainer,false);
            footerAdapter.setViewData(footerView);
            footerContainer.addView(footerView);
        }

    }

    /**
     * 设置对话框是否有边角
     * @param topCorner 顶部是否有圆角
     * @param bottomCorner 底部是否有圆角
     */
    public void setCorner(boolean topCorner,boolean bottomCorner){
        this.topCorner=topCorner;
        this.bottomCorner=bottomCorner;
    }

    /**
     * 设置对话框出现的位置，要用Gravity类的常量,默认为Gravity.CENTER
     *
     * @param gravity
     */
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public KyAdapter getHeaderAdapter() {
        return headerAdapter;
    }

    public void setHeaderAdapter(KyAdapter headerAdapter) {
        this.headerAdapter = headerAdapter;
    }

    public KyAdapter getContentAdapter() {
        return contentAdapter;
    }

    public void setContentAdapter(KyAdapter contentAdapter) {
        this.contentAdapter = contentAdapter;
    }

    public KyAdapter getFooterAdapter() {
        return footerAdapter;
    }

    public void setFooterAdapter(KyAdapter footerAdapter) {
        this.footerAdapter = footerAdapter;
    }
}
