package com.yanglinggui.myandroidstudy;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTestActivity extends Activity {

    private String url = "http://www.wanandroid.com/banner/json";
    private TextView mTextView;
    private OkHttpClient mClient;
    private Request mRequest;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_okhttp);
        mTextView = findViewById(R.id.show);
        mClient = new OkHttpClient();
        //OkHttpClient mClient1 = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).build();
        //OkHttpClient mClient2  =mClient.newBuilder().build();
        mRequest = new Request.Builder().url(url).build();
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mTextView.setText((String) msg.obj);
            }
        };
    }

    protected void onClick(View v) throws Exception {
        if (v.getId() == R.id.execute) {
            //mTextView.setText((mClient.newCall(mRequest).execute()).body().toString());
            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {
                    try {
                        return mClient.newCall(mRequest).execute().body().toString();
                    } catch (Exception e) {

                    }
                    return "Error";
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    mTextView.setText(s);
                }
            }.execute();
        } else {
            mClient.newCall(mRequest).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //Toast.makeText(OkHttpTestActivity.this,"onFailure",Toast.LENGTH_SHORT).show();
                    Message m = mHandler.obtainMessage();
                    m.obj = "onFailure";
                    mHandler.sendMessage(m);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Message m = mHandler.obtainMessage();
                    m.obj = response.body().toString();
                    //mTextView.setText(response.body().toString());
                    mHandler.sendMessage(m);
                }
            });
        }
    }
}
