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

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView = (TextView) findViewById(R.id.text);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                        try {
                            sleep(3*1000);
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



        Animation myAnim = AnimationUtils.loadAnimation(Splash.this, R.anim.my_anim);
        textView.setTypeface(tf);
        textView.startAnimation(myAnim);


    }
}
