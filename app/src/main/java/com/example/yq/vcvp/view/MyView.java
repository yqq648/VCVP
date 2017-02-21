package com.example.yq.vcvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;

import com.example.yq.vcvp.model.MyModel;

/**
 * Created by yq on 2017/2/21.
 */

public //视图
class MyView extends View {
    MyModel model;

    public MyView(Context context) {
        super(context);
        model = new MyModel(10,10,40,40);
    }
    //控制器更改的数据
    public boolean move(int action){
        if(action== KeyEvent.KEYCODE_DPAD_LEFT){
            model.x = model.x-5;
            invalidate();//刷新界面
            return true;
        }else if (action== KeyEvent.KEYCODE_DPAD_RIGHT){
            model.x = model.x+5;
            invalidate();//刷新界面
            return true;
        }
        return false;
    }

    @Override//rect矩形
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Rect rect = new Rect(model.x,model.y,
                model.x+model.width,model.y+model.height);
        canvas.drawRect(rect,new Paint());
    }
}
