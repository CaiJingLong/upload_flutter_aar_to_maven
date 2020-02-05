package top.kikt.flutterhost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import io.flutter.app.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.view.FlutterMain;

public class MainActivity extends AppCompatActivity {

  boolean flutterInited = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.bt_to_flutter).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (!flutterInited) {
          FlutterMain.startInitialization(getApplicationContext());
          FlutterMain.ensureInitializationComplete(getApplicationContext(), null);
        }
        Intent intent = new Intent(MainActivity.this, FlutterActivity.class);
        startActivity(intent);
      }
    });

    initFlutterEngine();
  }

  void initFlutterEngine() {
    FlutterMain.startInitialization(getApplicationContext());
    FlutterMain.ensureInitializationCompleteAsync(getApplicationContext(), null, new Handler(), new Runnable() {
      @Override
      public void run() {
        flutterInited = true;
      }
    });
  }
}
