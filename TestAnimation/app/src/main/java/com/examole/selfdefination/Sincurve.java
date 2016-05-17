package com.examole.selfdefination;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.nfc.Tag;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Danieljet on 2016/5/6.
 */
public class Sincurve  extends SurfaceView implements  Runnable,SurfaceHolder.Callback{

     private SurfaceHolder holder;  //surface初始化
     private Canvas canvas;         //用于绘图的画布
     private boolean mIsDrawing;    //子线程标志位
     private Path mpath ;
     private Paint mpaint ;       //画笔
     private float  x = 0 ;      //横坐标
     private float  y = 0 ;      //纵坐标

    //重写方法
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
                     mIsDrawing = true;
                     mpath.moveTo(0,400);
                     new Thread(this).start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
                mIsDrawing = false;
    }

    public Sincurve(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview();
    }

    public Sincurve(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    public Sincurve(Context context) {
        super(context);
        initview();
    }

    @Override
    public void run() {
         while(mIsDrawing){

             draw();
             x += 1;
             y = (int)(100 * Math.sin(x * 4 * Math.PI/180) + 400);
             mpath.lineTo(x,y);
             Log.i(VIEW_LOG_TAG,"d");
         }
    }
   //初始化正弦曲线图
    public void initview(){

        holder = getHolder();       //初始化surfacefolder
        holder.addCallback(this);   //注册回掉方法
        mpath = new Path();
        mpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mpaint.setColor(Color.RED);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(10);
        mpaint.setStrokeCap(Paint.Cap.ROUND);
        mpaint.setStrokeJoin(Paint.Join.ROUND);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);



    }

    public void draw(){

        try {
            canvas = holder.lockCanvas();  //获得一个画布
            //drawsomething,SurfaceView 背景
            canvas.drawColor(Color.WHITE);
            canvas.drawPath(mpath,mpaint);

        }catch(Exception o){

        }finally {
            if(canvas != null){
                holder.unlockCanvasAndPost(canvas);   //画布内容提交
            }
        }


    }
}
