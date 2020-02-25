package tw.com.hy123.mygithubtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
import java.util.LinkedList;

import androidx.annotation.Nullable;

public class MyView extends View {
    private LinkedList<LinkedList<HashMap<String,Float>>> lines;
    private Paint paint;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.RED);

        lines = new LinkedList<>();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(4);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(LinkedList<HashMap<String,Float>> line: lines) {
            for (int i = 1; i < line.size(); i++) {
                HashMap<String, Float> p0 = line.get(i - 1);
                HashMap<String, Float> p1 = line.get(i);
                canvas.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"), paint);
            }

        }

    }

    public void clear(){
        lines.clear();
        invalidate(); //repaint
    }

    public void undo(){
        if(lines.size()>0){
            lines.removeLast();
            invalidate();
        }
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() ==MotionEvent.ACTION_DOWN){
            Log.v("chris","Down");
            setFirstPoint(event);
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            Log.v("chris","Up");
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            Log.v("chris","Move");
            setMovePoint(event);

        }



        float x = event.getX(),y = event.getY();

        Log.v("chris","Touch on:"+x+":"+y);
//        super.onTouchEvent(event);
        return true;


    }

    private void setFirstPoint(MotionEvent event){
        LinkedList<HashMap<String,Float>> line = new LinkedList<>();

        float x = event.getX(),y = event.getY();
        HashMap<String,Float> point = new HashMap<String,Float>();
        point.put("x",x);
        point.put("y",y);
        line.add(point);
        lines.add(line);
    }

    private void setMovePoint(MotionEvent event){
        float x = event.getX(),y = event.getY();
        HashMap<String,Float> point = new HashMap<String,Float>();
        point.put("x",x);
        point.put("y",y);
        lines.getLast().add(point);

        invalidate();
    }


}
