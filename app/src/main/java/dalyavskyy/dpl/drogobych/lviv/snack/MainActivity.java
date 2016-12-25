package dalyavskyy.dpl.drogobych.lviv.snack;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int getWidgtRandom(int a){
        return new Random().nextInt(a);
    }
    static int widgt;
    static int height;
    static int score=0;
    static int dir=6;
    AlertDialog.Builder ad;
    Handler h;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        context = MainActivity.this;
        setContentView(new Draw(this));
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        height=display.getHeight();
        widgt=display.getWidth();
        //
        //
        h=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                AlertDialog.Builder ad1 = new AlertDialog.Builder(context);
                ad1.setTitle("You lose.");
                ad1.setMessage("Your score is "+String.valueOf(score)+".");
                ad1.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            System.exit(0);
                        }
                    }
                });
                ad1.setCancelable(false);
                ad1.show();
            }
        };
        ad = new AlertDialog.Builder(context);
        ad.setTitle("Start");  // заголовок
        ad.setMessage("Click start to start:"); // сообщение
        ad.setPositiveButton("Start", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        {
                            for(;;){
                                Draw.snack.doStep(dir);
                                Draw.food.isEaten(Draw.snack);
                                if(Draw.snack.Boom(Draw.snack)){

                                    break;

                                };
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                            h.sendEmptyMessage(1);

                        }
                    }
                }).start();
            }
        });
        ad.setCancelable(false);
        ad.show();
        //
        //Toast.makeText(getApplicationContext(),String.valueOf(height)+"x"+String.valueOf(widgt),Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= ((int) event.getX());
        int y = (int) event.getY();
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            //Toast.makeText(getApplicationContext(),String.valueOf(x)+" "+String.valueOf(y),Toast.LENGTH_SHORT).show();
            if(Draw.pup.isClicked(x,y) && dir!=2){
                dir=8;
                //Toast.makeText(getApplicationContext(),"UP",Toast.LENGTH_SHORT).show();
            }
            if(Draw.pdown.isClicked(x,y) && dir!=8){
                dir=2;
                //Toast.makeText(getApplicationContext(),"DOWN",Toast.LENGTH_SHORT).show();
            }
            if(Draw.pleft.isClicked(x,y) && dir!=6){
                dir=4;
                //Toast.makeText(getApplicationContext(),"LEFT",Toast.LENGTH_SHORT).show();
            }
            if(Draw.pright.isClicked(x,y) && dir!=4){
                dir=6;
                //Toast.makeText(getApplicationContext(),"RIGHT",Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

}
