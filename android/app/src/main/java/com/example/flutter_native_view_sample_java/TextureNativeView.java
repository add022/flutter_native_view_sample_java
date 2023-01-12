package com.example.flutter_native_view_sample_java;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

import io.flutter.plugin.platform.PlatformView;

class TextureNativeView implements PlatformView, TextureView.SurfaceTextureListener {
    @NonNull private final TextureView textureView;
    @NonNull private final int id;

    TextureNativeView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
        textureView = new TextureView(context);
        textureView.setSurfaceTextureListener(this);
        this.id = id;
    }

    @NonNull
    @Override
    public View getView() {
        System.out.println("TextureNativeView: getView: "+id);
        return textureView;
    }

    @Override
    public void onFlutterViewAttached(@NonNull View flutterView) {
        System.out.println("TextureNativeView: onFlutterViewAttached: "+id);

        PlatformView.super.onFlutterViewAttached(flutterView);
    }

    @Override
    public void onFlutterViewDetached() {
        System.out.println("TextureNativeView: onFlutterViewDetached: "+id);

        PlatformView.super.onFlutterViewDetached();
    }

    @Override
    public void dispose() {
        System.out.println("TextureNativeView: disposing: "+id);
    }

    @Override
    public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
        System.out.println("TextureNativeView: onSurfaceTextureAvailable: "+id);
    }

    @Override
    public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
        System.out.println("TextureNativeView: onSurfaceTextureSizeChanged: "+id);
    }

    @Override
    public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
        System.out.println("TextureNativeView: onSurfaceTextureDestroyed: "+id);

        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {
        System.out.println("TextureNativeView: onSurfaceTextureUpdated: "+id);
    }
}
