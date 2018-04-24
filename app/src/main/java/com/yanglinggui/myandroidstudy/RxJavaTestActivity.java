package com.yanglinggui.myandroidstudy;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RxJavaTestActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        imageView = findViewById(R.id.imageview);

        Observable<Drawable> mObservable = Observable.create(new Observable.OnSubscribe<Drawable>() {

            @Override
            public void call(Subscriber<? super Drawable> subscriber) {

                try {
                    URL mUrl = new URL("http://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png");
                    InputStream is;
                    HttpURLConnection mConnect = (HttpURLConnection)mUrl.openConnection();
                   // HttpURLConnection();
                    mConnect.setDoInput(true);
                    mConnect.connect();
                    is = mConnect.getInputStream();

                    android.util.Log.i("qiao-yang", "---> ...1.");
                    OkHttpClient mClient = new OkHttpClient();
                    android.util.Log.i("qiao-yang", "---> ....2");
                    Request mRequest = new Request.Builder().url("http://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png").build();
                    android.util.Log.i("qiao-yang", "---> ....3");
                    //is = mClient.newCall(mRequest).execute().body().byteStream();


                    android.util.Log.i("qiao-yang", "---> ....4");
                    Drawable drawable = Drawable.createFromStream(is, "img");
                    subscriber.onNext(drawable);
                } catch (Exception e) {
                    android.util.Log.i("qiao-yang", "e = " + e.getMessage());
                    subscriber.onError(e);
                }
            }
        });

        mObservable = mObservable.subscribeOn(Schedulers.io());
        mObservable = mObservable.observeOn(AndroidSchedulers.mainThread());

        Subscriber<Drawable> mSubscriber = new Subscriber<Drawable>() {
            @Override
            public void onCompleted() {
                Toast.makeText(getApplicationContext(), "onComplete", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNext(Drawable drawable) {
                imageView.setImageDrawable(drawable);
                Toast.makeText(getApplicationContext(), "onNext", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable t) {
                Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
                android.util.Log.i("qiao-yang", "t = " + t.getMessage());
            }

        };

        mObservable.subscribe(mSubscriber);

/*        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {

                try {
                    Drawable drawable = Drawable.createFromStream(new URL("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2502144641,437990411&fm=80&w=179&h=119&img.JPEG").openStream(), "src");
                    subscriber.onNext(drawable);
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        })
                // 指定 subscribe() 所在的线程，也就是上面call()方法调用的线程
                .subscribeOn(Schedulers.io())
                // 指定 Subscriber 回调方法所在的线程，也就是onCompleted, onError, onNext回调的线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Drawable>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        android.util.Log.i("qiao-yang", e.toString());
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }
                });*/
        //https://blog.csdn.net/u014137988/article/details/53538446
    }
}
