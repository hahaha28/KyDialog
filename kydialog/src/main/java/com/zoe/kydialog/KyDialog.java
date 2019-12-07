package com.zoe.kydialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.zoe.kydialog.rclayout.RCRelativeLayout;

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
    private int topCornerRadius ;
    private int bottomCornerRadius;

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
        //设置window背景
        window.setDimAmount(0.4f);
        window.setWindowAnimations(R.style.Dialog_Center_Brief_Anim);
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
        //获取RCLayout，设置圆角
        RCRelativeLayout rcRelativeLayout = rootView.findViewById(R.id.rclayout);
        rcRelativeLayout.setTopLeftRadius(topCornerRadius);
        rcRelativeLayout.setTopRightRadius(topCornerRadius);
        rcRelativeLayout.setBottomLeftRadius(bottomCornerRadius);
        rcRelativeLayout.setBottomRightRadius(bottomCornerRadius);

        decorView.addView(rootView);    //添加rootView到decorView
        //设置顶部、内容、底部
        ViewGroup headerContainer = rootView.findViewById(R.id.kydialog_header_container);
        ViewGroup contentContainer = rootView.findViewById(R.id.kydialog_content_container);
        ViewGroup footerContainer = rootView.findViewById(R.id.kydialog_footer_container);
        if(headerAdapter != null){
            View headerView=headerAdapter.getView();
            headerContainer.addView(headerView);
        }
        if(contentAdapter != null){
            View contentView=contentAdapter.getView();
            contentContainer.addView(contentView);
        }
        if(footerAdapter != null){
            View footerView=footerAdapter.getView();
            footerContainer.addView(footerView);
        }

    }

    /**
     * 设置对话框的圆角
     * @param topRadius 顶部圆角半径
     * @param bottomRadius 底部圆角半径
     */
    public void setCorner(int topRadius,int bottomRadius){
        topCornerRadius = topRadius;
        bottomCornerRadius = bottomRadius;
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
