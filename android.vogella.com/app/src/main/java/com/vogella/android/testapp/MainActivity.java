package com.vogella.android.testapp;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.vogella.android.testapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    int[] images = new int[2];
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String textFieldValue ="";
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityHandlers handler = new MainActivityHandlers();
        binding.setHandler(handler);
        final RadioGroup group1 = (RadioGroup) findViewById(R.id.orientation);
        images[0] = R.drawable.ic_tethering;
        images[1] = R.drawable.ic_offline;
        this.imageView = (ImageView) findViewById(R.id.iconImage);

        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.horizontal:
                        group.setOrientation(LinearLayout.HORIZONTAL);
                        break;
                    case R.id.vertical:
                        group.setOrientation(LinearLayout.VERTICAL);
                        break;
                }
            }
        });

//        final Button button = (Button) findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                // Perform action on click
//                if(view.getId() == R.id.button2) {
//                    if(!flag){
//                        flag = true;
//                        imageView.setImageResource(images[0]);
//
//                    }else {
//                        flag = false;
//                        imageView.setImageResource(images[1]);
//                    }
//                }
//            }
//        });
    }

    public void imageClick(View view) {
        switch(view.getId()) {
            case R.id.button2:
                if(!flag){
                    flag = true;
                    imageView.setImageResource(images[0]);

                }else {
                    flag = false;
                    imageView.setImageResource(images[1]);
                }
                break;
            case R.id.iconImage:
                if(!flag){
                    flag = true;
                    imageView.setImageResource(images[0]);

                }else {
                    flag = false;
                    imageView.setImageResource(images[1]);
                }
                break;
        }

    }
}
