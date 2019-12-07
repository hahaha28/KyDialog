package com.zoe.example.kydialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

//                final SimpleListDialog dialog = new SimpleListDialog(v.getContext())
//                        .setTitle("平和程度")
//                        .setListData(Arrays.asList("平和","一般","浮躁"),1);
                final BriefDialog dialog = new BriefDialog(v.getContext());

                dialog.show();
            }
        });

    }
}
