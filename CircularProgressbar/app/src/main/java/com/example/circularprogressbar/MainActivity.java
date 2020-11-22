package com.example.circularprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar circular_pro;
    private Button clickme_btn;
    private TextView status;

    private int progressStatus=0;
    private Handler handler= new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circular_pro=(ProgressBar)findViewById(R.id.progressbar_circular);
        clickme_btn=(Button)findViewById(R.id.progess_btn);
        status=(TextView)findViewById(R.id.text_status);

        clickme_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (progressStatus<100){
                            progressStatus +=1;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    circular_pro.setProgress(progressStatus);
                                    status.setText(progressStatus+"%");


                                }
                            });
                            try {
                                Thread.sleep(400);

                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }


                    }
                }).start();

            }
        });



    }
}