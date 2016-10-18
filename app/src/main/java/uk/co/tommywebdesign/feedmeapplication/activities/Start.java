package uk.co.tommywebdesign.feedmeapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uk.co.tommywebdesign.feedmeapplication.R;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_act);
        Thread timer =new Thread(){

            public void run(){

                try{
                    sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent beginApplication = new Intent("uk.co.tommy.COORD");
                    startActivity(beginApplication);

                }



            }
        };
        timer.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
