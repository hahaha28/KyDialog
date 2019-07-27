package com.zoe.kydialog;

import android.view.View;

public interface KyAdapter {

    /**
     * 获取布局资源id
     * @return 布局资源id
     */
    int getResId();

    /**
     * 设置View的数据
     * @param view
     */
    void setViewData(View view);

}
