package com.example.asal.firebase_exe;

import com.firebase.client.Firebase;

/**
 * Created by asal on 2017-10-20.
 */

public class Database extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
