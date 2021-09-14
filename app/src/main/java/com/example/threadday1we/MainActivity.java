package com.example.threadday1we;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button mBtnButton1,mBtnButton2;
WorkerThread workerThread;

private Runnable taskOne = new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Log.d("Task-1", "value = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};
private Runnable taskTwo = new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Log.d("Task-2", "value = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     initviews();
    }

    private void initviews() {
    mBtnButton1 = findViewById(R.id.btnButton1);
    mBtnButton2 = findViewById(R.id.btnButton2);
    workerThread = new WorkerThread();
    mBtnButton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            workerThread.addTaskToMessageQueue(taskOne);
        }
    });
    mBtnButton2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            workerThread.addTaskToMessageQueue(taskTwo);
        }
    });
    }
}