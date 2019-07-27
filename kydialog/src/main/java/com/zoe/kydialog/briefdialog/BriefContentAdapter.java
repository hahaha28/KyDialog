package com.zoe.kydialog.briefdialog;

import android.view.View;
import android.widget.TextView;

import com.zoe.kydialog.KyAdapter;
import com.zoe.kydialog.R;

public class BriefContentAdapter implements KyAdapter {

    private final int resId= R.layout.content_brief;
    private String content="";

    @Override
    public int getResId() {
        return resId;
    }

    @Override
    public void setViewData(View view) {
        TextView textView=view.findViewById(R.id.kydialog_brief_content_text);
        textView.setText(content);
    }

    public BriefContentAdapter setContent(String content){
        this.content=content;
        return this;
    }
}
