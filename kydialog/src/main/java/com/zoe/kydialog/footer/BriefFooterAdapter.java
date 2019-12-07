package com.zoe.kydialog.footer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoe.kydialog.KyAdapter;
import com.zoe.kydialog.R;

public class BriefFooterAdapter implements KyAdapter {

    /**
     * 布局的View
     */
    private View view;
    /**
     * 取消的textView
     */
    private TextView cancelTextView;
    /**
     * 确定的TextView
     */
    private TextView confirmTextView;
    private String cancelText="取消";
    private String confirmText="确定";
    private View.OnClickListener onCancelClickListener;
    private View.OnClickListener onConfirmClickListener;

    public BriefFooterAdapter(Context context){
        view = LayoutInflater.from(context)
                .inflate(R.layout.footer_brief,null);
        cancelTextView=view.findViewById(R.id.kydialog_brief_footer_cancle);
        confirmTextView=view.findViewById(R.id.kydialog_brief_footer_confim);
    }

    @Override
    public View getView() {
        return view;
    }

    /**
     * 设置View的数据
     * @param view
     */
    public void setViewData(View view) {
        TextView cancelTextView=view.findViewById(R.id.kydialog_brief_footer_cancle);
        TextView confirmTextView=view.findViewById(R.id.kydialog_brief_footer_confim);
        cancelTextView.setText(cancelText);
        confirmTextView.setText(confirmText);
        cancelTextView.setOnClickListener(onCancelClickListener);
        confirmTextView.setOnClickListener(onConfirmClickListener);
    }

    public BriefFooterAdapter setCancelText(String cancelText) {
        cancelTextView.setText(cancelText);
        return this;
    }

    public BriefFooterAdapter setConfirmText(String confirmText) {
        confirmTextView.setText(confirmText);
        return this;
    }

    public void setOnCancelClickListener(View.OnClickListener onCancelClickListener) {
        cancelTextView.setOnClickListener(onCancelClickListener);
    }

    public void setOnConfirmClickListener(View.OnClickListener onConfirmClickListener) {
        confirmTextView.setOnClickListener(onConfirmClickListener);
    }
}
