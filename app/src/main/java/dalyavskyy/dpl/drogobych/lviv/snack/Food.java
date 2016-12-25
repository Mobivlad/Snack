package dalyavskyy.dpl.drogobych.lviv.snack;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by vlad on 23.12.2016.
 */

public class Food {
    Canvas canvas;
    Paint paint;
    int x;
    int y;
    int r=10;
    Food(){}
    public double getLength(int x1,int x2,int y1,int y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }

    public void drow(){
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x,y,r,paint);
        paint.setColor(Color.RED);
    }
    public void isEaten(Snack snack){
        Circle head=snack.body.get(snack.body.size()-1);
        if(getLength(head.getX(),x,head.getY(),y)<head.getR()+r) {
            Draw.food.setX(50+MainActivity.getWidgtRandom(MainActivity.widgt-100));
            Draw.food.setY(MainActivity.getWidgtRandom(MainActivity.height-300)+40);
            Draw.snack.addCircle();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
