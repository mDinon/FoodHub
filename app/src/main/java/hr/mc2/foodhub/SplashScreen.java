package hr.mc2.foodhub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Matija on 3.4.2016..
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int splashDelay = 1500;
        setContentView(R.layout.splash);
       // android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        // Micanje action bara
        //actionBar.hide();
        // Pokretanje MainActivity-a nakon odgode od splashDelay sekundi
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashDelay);
    }


}
