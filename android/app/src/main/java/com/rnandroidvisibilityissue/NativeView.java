package com.rnandroidvisibilityissue;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class NativeView extends RelativeLayout {
    public NativeView(final Context context, Boolean isFromReact) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout, this);

        Button buttonFrameInvisible = (Button) view.findViewById(R.id.button_frame_invisible);
        final View frameInvisible = view.findViewById(R.id.frame_invisible);
        buttonFrameInvisible.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                frameInvisible.setVisibility(frameInvisible.isShown() ? View.INVISIBLE: View.VISIBLE);
            }
        });

        Button buttomFrameGone = (Button) view.findViewById(R.id.button_frame_gone);
        final View frameGone = view.findViewById(R.id.frame_gone);
        buttomFrameGone.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                frameGone.setVisibility(frameGone.isShown() ? View.GONE: View.VISIBLE);
            }
        });

        Button buttonNativeActivity = (Button) view.findViewById(R.id.button_native_activity);

        if (isFromReact) {
            buttonNativeActivity.setOnClickListener(new OnClickListener() {
                @Override public void onClick(View v) {
                    Intent myIntent = new Intent(context, NativeViewActivity.class);
                    context.startActivity(myIntent);
                }
            });
        } else {
            buttonNativeActivity.setVisibility(View.GONE);
        }
    }
}
