package dalyavskyy.dpl.drogobych.lviv.snack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by vlad on 22.12.2016.
 */
class Draw extends View {
    static final int high_limit=100;
    static final int low_limit =1060;
    static int color = Color.RED;
    Paint paint;
    final Bitmap uper = BitmapFactory.decodeResource(getResources(), R.drawable.up);
    final Bitmap down = BitmapFactory.decodeResource(getResources(), R.drawable.down);
    final Bitmap left = BitmapFactory.decodeResource(getResources(), R.drawable.left);
    final Bitmap right = BitmapFactory.decodeResource(getResources(), R.drawable.right);
    static Snack snack = new Snack(3,200,100,20);
    static Food food = new Food();
    static Pictures pup = new Pictures();
    static Pictures pdown = new Pictures();
    static Pictures pleft = new Pictures();
    static Pictures pright = new Pictures();
    public Draw(Context context) {
        super(context);
        pup.bitmap=uper;
        pdown.bitmap=down;
        pleft.bitmap=left;
        pright.bitmap=right;
        food.setX(220);
        food.setY(200);
    }
    void setColor(Canvas canvas){
        canvas.drawColor(color);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint=new Paint();
        setColor(canvas);
        paint.setTextSize(40);
        paint.setColor(Color.BLUE);
        canvas.drawText("Score: "+String.valueOf(MainActivity.score),0,30,paint);
        paint.setColor(Color.WHITE);
        canvas.drawLine(0,40,MainActivity.widgt,40,paint);
        paint.setColor(Color.GREEN);
        pup.canvas=canvas;
        pup.paint=paint;
        pdown.canvas=canvas;
        pdown.paint=paint;
        pleft.canvas=canvas;
        pleft.paint=paint;
        pright.canvas=canvas;
        pright.paint=paint;
        //up
        pup.bitmap=uper;
        pup.x=0;
        pup.y=canvas.getHeight()-60-64;
        pup.drow();
        //up
        //down
        pdown.bitmap=down;
        pdown.x=120;
        pdown.y=canvas.getHeight()-60-64;
        pdown.drow();
        //down
        //right
        pright.bitmap=right;
        pright.x=canvas.getWidth()-128;
        pright.y=canvas.getHeight()-60-64;
        pright.drow();
        //right
        //left
        pleft.bitmap=left;
        pleft.x=canvas.getWidth()-2*128;
        pleft.y=canvas.getHeight()-60-64;
        pleft.drow();
        //left
        paint.setColor(Color.WHITE);
        canvas.drawLine(0,MainActivity.height-200,MainActivity.widgt,MainActivity.height-200,paint);
        paint.setColor(Color.RED);
        food.canvas=canvas;
        food.paint=paint;
        food.drow();

        snack.canvas=canvas;
        snack.paint=paint;
        snack.drowBody();


        invalidate();
    }
}