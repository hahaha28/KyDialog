package com.zoe.kydialog.briefdialog;

import android.view.View;
import android.widget.TextView;

import com.zoe.kydialog.KyAdapter;
import com.zoe.kydialog.R;

public class BriefHeaderAdapter implements KyAdapter {

    private final int resId= R.layout.header_brief;
    private String title="标题";

    @Override
    public int getResId() {
        return resId;
    }

    @Override
    public void setViewData(View view) {
        TextView textView=view.findViewById(R.id.kydialog_brief_header_title);
        textView.setText(title);
    }

    public BriefHeaderAdapter setTitle(String title){
        this.title=title;
        return this;
    }

}
