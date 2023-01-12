package com.example.flutter_native_view_sample_java;

import android.content.Context;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.platform.PlatformView;
import java.util.Map;

class SurfaceNativeView implements PlatformView, SurfaceHolder.Callback {
    @NonNull private final SurfaceView surfaceView;
    @NonNull private final int id;

    SurfaceNativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
        surfaceView = new SurfaceView(context);
        surfaceView.getHolder().addCallback(this);
        surfaceView.setBackgroundColor(Color.rgb(111, 255, 255));
        this.id = id;
    }

    @NonNull
    @Override
    public View getView() {
        System.out.println("SurfaceNativeView: getView: "+id);
        return surfaceView;
    }

    @Override
    public void onFlutterViewAttached(@NonNull View flutterView) {
        System.out.println("SurfaceNativeView: onFlutterViewAttached: "+id);

        PlatformView.super.onFlutterViewAttached(flutterView);
    }

    @Override
    public void onFlutterViewDetached() {
        System.out.println("SurfaceNativeView: onFlutterViewDetached: "+id);

        PlatformView.super.onFlutterViewDetached();
    }

    @Override
    public void dispose() {
        System.out.println("SurfaceNativeView: disposing: "+id);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        System.out.println("SurfaceNativeView: surfaceCreated: "+id);

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        System.out.println("NativeView: surfaceChanged: "+id);

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        System.out.println("NativeView: surfaceDestroyed: "+id);

    }
}
