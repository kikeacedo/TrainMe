package u_tad.quique.com.trainme.presentation.activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import u_tad.quique.com.trainme.R;
import u_tad.quique.com.trainme.presentation.interfaces.ISplashScreenPresenter;
import u_tad.quique.com.trainme.presentation.presenters.SplashScreenPresenter;
import u_tad.quique.com.trainme.utils.Constants;

/*
 * @author Quique Acedo Dorado 
 * @date 20/4/16
 * @subject Programacion Plataformas Moviles
 */
public class SplashScreenActivity extends AppCompatActivity{

    // Set the duration of the splash screen
    private static final long DELAY = Constants.ANIMATION_TIME;
    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

//        App ap = App.getInstance();
//
//        isLogin = App.getInstance().getSharedPreferences().getBoolean("login",false);

        ISplashScreenPresenter a = new SplashScreenPresenter();

        isLogin = a.isLoggin();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isLogin = true;

                if(isLogin) {
                    Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                }else{
                    Intent mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(mainIntent);
                }//if-else

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        }, DELAY);

    }//onCreate

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }//onPause

}//class
