package com.rnandroidvisibilityissue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class NativeViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new NativeView(getApplicationContext(), false);
        setContentView(view);
    }
}
