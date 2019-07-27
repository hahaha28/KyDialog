package com.zoe.example.kydialog;

import android.view.View;

import com.zoe.kydialog.KyAdapter;

public class TestAdapter implements KyAdapter {

    private int resId=R.layout.test;

    @Override
    public int getResId() {
        return resId;
    }

    @Override
    public void setViewData(View view) {

    }
}
