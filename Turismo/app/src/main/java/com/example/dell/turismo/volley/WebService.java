package com.example.dell.turismo.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v4.util.Pools;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by DELL on 22/05/2016.
 */
public class WebService {
    public static String server="http://11.11.11.105:3000/api/v1/";
    public static String autenticar=server+"usuario/login";
    private static WebService mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private WebService(Context context){
        mCtx = context;
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,
            new ImageLoader.ImageCache(){
                private final LruCache<String, Bitmap>
                    cache = new LruCache<String, Bitmap>(20);

                @Override
                public Bitmap getBitmap(String url){return cache.get(url); }

                @Override
                public void putBitmap(String url, Bitmap bitmap){cache.put(url, bitmap);}
            });
    }

    public static synchronized WebService getInstance(Context context){
        if (mInstance==null){
            mInstance= new WebService(context);
        }
        return mInstance;
    }
    public RequestQueue getRequestQueue(){
        if (mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <I> void addToRequestQueue(Request<I> req){
        getRequestQueue().add(req);
    }
    public ImageLoader getmImageLoader() {
        return mImageLoader;
    }
}