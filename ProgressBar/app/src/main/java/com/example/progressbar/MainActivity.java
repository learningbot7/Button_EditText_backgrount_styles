package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar_determinate,progressBar_indeterminate;
    private Button determinate_btn,indeterminate_btn;
    private int progressStatus=0;
    private TextView status;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar_determinate=(ProgressBar)findViewById(R.id.progressbar_determinate);
        progressBar_indeterminate=(ProgressBar)findViewById(R.id.progressbar_indeterminate);
        determinate_btn=(Button)findViewById(R.id.determinate_btn);
        indeterminate_btn=(Button)findViewById(R.id.indeterminate_btn);
        status=(TextView)findViewById(R.id.status);

        //for determinate progress bar
        determinate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar_determinate.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus <100){
                            progressStatus +=1;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    progressBar_determinate.setProgress(progressStatus);
                                    status.setText(progressStatus+"/"+progressBar_determinate.getMax());

                                }
                            });
                            try {
                                Thread.sleep(200);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }

                        }

                    }
                }).start();
            }
        });
        //for indeterminate
        indeterminate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar_indeterminate.setVisibility(View.VISIBLE);
            }
        });


    }
}