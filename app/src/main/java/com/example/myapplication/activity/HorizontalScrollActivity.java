package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class HorizontalScrollActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private String[] descripton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll2);
        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);

        Bundle extras = getIntent().getExtras();
        descripton = extras.getStringArray("text");

        linearLayout = findViewById(R.id.linear1);
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        setView(layoutInflater);

    }



    public void setView(LayoutInflater layoutInflater)
    {
        for (int i=0; i<descripton.length; i++)
        {

            View view = layoutInflater.inflate(R.layout.horizontal_view, linearLayout, false);
            TextView tv = view.findViewById(R.id.desc);
            tv.setText(descripton[i]);

            linearLayout.addView(view);

        }
    }
}


