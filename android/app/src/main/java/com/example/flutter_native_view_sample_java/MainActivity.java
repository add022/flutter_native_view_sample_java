package com.example.flutter_native_view_sample_java;

import android.os.StrictMode;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

public class MainActivity extends FlutterActivity {
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .build());

        flutterEngine
                .getPlatformViewsController()
                .getRegistry()
                .registerViewFactory("surface_native_view", new SurfaceNativeViewFactory());

        flutterEngine
                .getPlatformViewsController()
                .getRegistry()
                .registerViewFactory("texture_native_view", new TextureNativeViewFactory());
    }
}
