package dalyavskyy.dpl.drogobych.lviv.snack;

/**
 * Created by vlad on 22.12.2016.
 */

public class Circle {
    private int x;
    private int y;
    private int r;
    public Circle(int x,int y,int r){
        this.x=x;
        this.y=y;
        this.r=r;
    }
    public Circle cpy(){
        return new Circle(x,y,r);
    }
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getR() {
        return r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }
}
