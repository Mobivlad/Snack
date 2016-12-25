package dalyavskyy.dpl.drogobych.lviv.snack;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by vlad on 24.12.2016.
 */

public class Pictures {
    Canvas canvas;
    Paint paint;
    int x;
    int y;
    Bitmap bitmap;
    Pictures(){}

    public void drow() {
        canvas.drawBitmap(bitmap,x,y,paint);
    }
    public boolean isClicked(int x0,int y0){
        if(x0>x && x0<x+100 && y0>y && y0<y+200){
            return true;
        }
        return false;
    }
}
