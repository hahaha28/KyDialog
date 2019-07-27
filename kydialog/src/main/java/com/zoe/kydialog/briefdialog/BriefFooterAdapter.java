package com.zoe.kydialog.briefdialog;

import android.view.View;
import android.widget.TextView;

import com.zoe.kydialog.KyAdapter;
import com.zoe.kydialog.R;

public class BriefFooterAdapter implements KyAdapter {

    private final int resId= R.layout.footer_brief;
    private String cancelText="取消";
    private String confirmText="确定";
    private View.OnClickListener onCancelClickListener;
    private View.OnClickListener onConfirmClickListener;

    @Override
    public int getResId() {
        return resId;
    }

    @Override
    public void setViewData(View view) {
        TextView cancelTextView=view.findViewById(R.id.kydialog_brief_footer_cancle);
        TextView confirmTextView=view.findViewById(R.id.kydialog_brief_footer_confim);
        cancelTextView.setText(cancelText);
        confirmTextView.setText(confirmText);
        cancelTextView.setOnClickListener(onCancelClickListener);
        confirmTextView.setOnClickListener(onConfirmClickListener);
    }

    public BriefFooterAdapter setCancelText(String cancelText) {
        this.cancelText = cancelText;
        return this;
    }

    public BriefFooterAdapter setConfirmText(String confirmText) {
        this.confirmText = confirmText;
        return this;
    }

    public void setOnCancelClickListener(View.OnClickListener onCancelClickListener) {
        this.onCancelClickListener = onCancelClickListener;
    }

    public void setOnConfirmClickListener(View.OnClickListener onConfirmClickListener) {
        this.onConfirmClickListener = onConfirmClickListener;
    }
}
