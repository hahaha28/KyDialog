package com.zoe.kydialog;

import android.content.Context;
import android.view.Gravity;

public class BaseDialog {

    protected KyDialog kyDialog;


    public BaseDialog(Context context){
        kyDialog=new KyDialog(context);
    }

    public void show(){
        kyDialog.show();
    }

    public void cancel(){
        kyDialog.cancel();
    }


    /**
     * 设置对话框出现的位置，要用Gravity类的常量,默认为Gravity.CENTER
     *
     * @param gravity Gravity类的常量
     */
    public BaseDialog setGravity(int gravity) {
        kyDialog.setGravity(gravity);
        return this;
    }

    public BaseDialog cancelHeader(){
        kyDialog.setHeaderAdapter(null);
        return this;
    }

    public BaseDialog cancelFooter(){
        kyDialog.setFooterAdapter(null);
        return this;
    }

    public BaseDialog setHeaderAdapter(KyAdapter headerAdapter) {
        kyDialog.setHeaderAdapter(headerAdapter);
        return this;
    }

    public BaseDialog setContentAdapter(KyAdapter contentAdapter) {
        kyDialog.setContentAdapter(contentAdapter);
        return this;
    }

    public BaseDialog setFooterAdapter(KyAdapter footerAdapter) {
        kyDialog.setFooterAdapter(footerAdapter);
        return this;
    }


}
