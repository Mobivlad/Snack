package dalyavskyy.dpl.drogobych.lviv.snack;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 22.12.2016.
 */

public class Snack {
    static final int RIGHT=6;
    static final int LEFT=4;
    static final int UP=8;
    static final int DOWN=2;
    Canvas canvas;
    Paint paint;
    int size;
    List<Circle> body=new ArrayList<>();
    Circle ea;
    public Snack(int size,int x,int y,int r){
        this.size=size;
        for(int i=0;i<size;i++){
            body.add(new Circle(x+(i)*r,y,r));
        }
        ea=body.get(body.size()-1).cpy();
        ea.setR(5);
        ea.setX(ea.getX()+5);
        ea.setY(ea.getY()-5);
    }
    public void drowBody(){
        paint.setColor(Color.GREEN);
        for(int i=0;i<size;i++){
            canvas.drawCircle(body.get(i).getX(),body.get(i).getY(),body.get(i).getR(),paint);
        }
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(ea.getX(),ea.getY(),ea.getR(),paint);
        paint.setColor(Color.RED);

    }
    public void addCircle(){
        Circle c=body.get(body.size()-1).cpy();
        switch(MainActivity.dir){
            case LEFT: {
                c.setX(c.getX()-c.getR());
                break;
            }
            case RIGHT:{
                c.setX(c.getX()+c.getR());
                break;
            }
            case UP: {
                c.setY(c.getY()-c.getR());
                break;
            }
            case DOWN:{
                c.setY(c.getY()+c.getR());
                break;
            }
        }
        body.add(c);
        MainActivity.score++;
        ea=body.get(body.size()-1).cpy();
        ea.setR(5);
        ea.setX(ea.getX()+5);
        ea.setY(ea.getY()-5);
        size++;
    }
    public double getLength(int x1,int x2,int y1,int y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    public boolean Boom(Snack snack){
        Circle head=snack.body.get(snack.body.size()-1);
        Object[] snake = snack.body.toArray();
        for(int i=0;i<snake.length-1;i++){
            Circle p=(Circle)(snake[i]);
            int x=p.getX();
            int y=p.getY();
            if(getLength(x,head.getX(),y,head.getY())<head.getR()){
                return true;
            }
        }
        return false;

    }
    public void doStep(int dir){
        Circle k=body.get(body.size()-1);
        switch(dir){
            case LEFT: {
                Circle c=new Circle(k.getX()-k.getR(), k.getY(), k.getR());
                if(c.getX()<0){
                    c.setX(c.getX()+MainActivity.widgt);
                }
                body.add(c);
                break;
            }
            case RIGHT:{
                Circle c=new Circle(k.getX()+k.getR(), k.getY(), k.getR());
                if(c.getX()>MainActivity.widgt){
                    c.setX(c.getX()-MainActivity.widgt);
                }
                body.add(c);
                break;
            }
            case UP: {
                Circle c=new Circle(k.getX(), k.getY()-k.getR(), k.getR());
                if(c.getY()<=40){
                    c.setY(c.getY()-40);
                    c.setY(MainActivity.height-200+c.getY()-c.getR());
                }
                body.add(c);
                break;
            }
            case DOWN:{
                Circle c=new Circle(k.getX(), k.getY()+k.getR(), k.getR());
                if(c.getY()>=MainActivity.height-200){
                    c.setY(c.getY()%(MainActivity.height-200));
                    c.setY(c.getY()+60);
                }
                body.add(c);
                break;
            }
        }

        ea=body.get(body.size()-1).cpy();
        ea.setR(5);
        ea.setX(ea.getX()+5);
        ea.setY(ea.getY()-5);
        body.remove(0);
    }

}
