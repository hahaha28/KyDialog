package com.zoe.kydialog.briefdialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.zoe.kydialog.BaseDialog;
import com.zoe.kydialog.KyDialog;

public class BriefDialog extends BaseDialog {

    private BriefHeaderAdapter headerAdapter;
    private BriefContentAdapter contentAdapter;
    private BriefFooterAdapter footerAdapter;

    public BriefDialog(Context context){
        super(context);
        headerAdapter=new BriefHeaderAdapter();
        contentAdapter=new BriefContentAdapter();
        footerAdapter=new BriefFooterAdapter();
        setHeaderAdapter(headerAdapter)
                .setContentAdapter(contentAdapter)
                .setFooterAdapter(footerAdapter);
    }


    /**
     * 设置取消按钮的监听事件
     * @param listener 取消按钮监听
     * @return
     */
    public BriefDialog setOnCancelClickListener(View.OnClickListener listener){
        footerAdapter.setOnCancelClickListener(listener);
        return this;
    }

    /**
     * 设置确定按钮的监听事件
     * @param listener 确定按钮监听
     * @return
     */
    public BriefDialog setOnConfirmClickListener(View.OnClickListener listener){
        footerAdapter.setOnConfirmClickListener(listener);
        return this;
    }

    /**
     * 设置对话框标题
     * @param title 标题
     * @return
     */
    public BriefDialog setTitle(String title){
        headerAdapter.setTitle(title);
        return this;
    }

    /**
     * 设置对话框内容
     * @param content 内容
     * @return
     */
    public BriefDialog setContent(String content){
        contentAdapter.setContent(content);
        return this;
    }

    /**
     * 设置取消按钮的文字
     * @param cancelText 取消按钮的文字，默认为“取消”
     * @return
     */
    public BriefDialog setCancelText(String cancelText){
        footerAdapter.setCancelText(cancelText);
        return this;
    }

    /**
     * 设置确定按钮的文字，默认为“确定”
     * @param confirmText 确定按钮的文字
     * @return
     */
    public BriefDialog setConfirmText(String confirmText){
        footerAdapter.setConfirmText(confirmText);
        return this;
    }

}
