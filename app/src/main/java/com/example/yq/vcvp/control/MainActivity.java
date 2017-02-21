package com.example.yq.vcvp.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.yq.vcvp.view.MyView;

public class MainActivity extends AppCompatActivity {
    MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
    }

    @Override//控制control
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        myView.move(keyCode);
        return super.onKeyDown(keyCode, event);
    }
}
