package app.techieni3.com.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                        try {
                            sleep(3*1000);

                            finish();

                        }catch (Exception e){
                            e.printStackTrace();
                        }
            }
        });

        Typeface tf = Typeface.createFromAsset(getAssets(),"scriptmtbold.ttf");



        Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.my_anim);
        textView.setTypeface(tf);
        textView.startAnimation(myAnim);

    }
}
