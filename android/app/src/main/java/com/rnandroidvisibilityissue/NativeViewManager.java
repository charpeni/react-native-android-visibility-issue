package com.rnandroidvisibilityissue;

import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class NativeViewManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "NativeView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public View createViewInstance(ThemedReactContext context) {
        return new NativeView(context, true);
    }
}
