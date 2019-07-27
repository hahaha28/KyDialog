package com.zoe.example.kydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.zoe.kydialog.KyDialog;
import com.zoe.kydialog.briefdialog.BriefDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final BriefDialog dialog = new BriefDialog(MainActivity.this);
                dialog.setTitle("更新")
                        .setContent("微信v7.0.5新特性:\n" +
                                "-解决了一些已知问题\n" +
                                "请点击确定在线升级，如果升级失败，请到https://weixin.qq.com下载最新版本\n" +
                                "安装包大小：106.2MB")
                        .setCancelText("取消")
                        .setConfirmText("确定")
                        .setOnCancelClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.cancel();
                            }
                        })
                        .setOnConfirmClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.cancel();
                            }
                        })
                        .setCorner(true, true)
                        .setGravity(Gravity.CENTER)
                        .cancelHeader()
                        .cancelFooter();

                dialog.show();
            }
        });

    }
}
