package app.techieni3.com.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Splash extends AppCompatActivity {

    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run()  {
                        try {
                            sleep(5*1000);
                            Intent i = new Intent(Splash.this,MainActivity.class);
                            startActivity(i);

                            finish();

                        }catch (Exception e){
                            e.printStackTrace();
                        }
            }


        });
            th.start();
        Typeface tf = Typeface.createFromAsset(getAssets(),"scriptmtbold.ttf");



        Animation  leftToRight = AnimationUtils.loadAnimation(Splash.this, R.anim.left_to_right);
        textView1.setTypeface(tf);
        textView1.startAnimation(leftToRight);

        Animation upToDown = AnimationUtils.loadAnimation(Splash.this, R.anim.up_to_down);
        textView2.setTypeface(tf);
        textView2.startAnimation(upToDown);

        Animation rightToLeft = AnimationUtils.loadAnimation(Splash.this, R.anim.right_to_left);
        textView3.setTypeface(tf);
        textView3.startAnimation(rightToLeft);


    }
}
