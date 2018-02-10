package com.rnandroidvisibilityissue;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

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

        Button buttonImage = (Button) view.findViewById(R.id.button_image);
        buttonImage.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                FrameLayout view = (FrameLayout) findViewById(R.id.my_image_container);
                view.removeAllViews();

                SimpleDraweeView draweeView = new SimpleDraweeView(context);
                Uri uri = Uri.parse("https://reactjs.org/logo-og.png");
                draweeView.setImageURI(uri);

                view.addView(draweeView);
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
