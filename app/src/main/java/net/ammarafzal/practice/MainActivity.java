package net.ammarafzal.practice;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button intent_hack = findViewById(R.id.intent_hack);
        Button broadcast_hack = findViewById(R.id.broadcast_hack);
        Button webview_screen = findViewById(R.id.webview_screen);
        Button path_triversal = findViewById(R.id.path_triversal);
        if (intent_hack != null) {
            intent_hack.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    Intent myIntent = new Intent(MainActivity.this, IntentHack.class);
                    startActivity(myIntent);
                }
            }));
        }
        if (broadcast_hack != null) {
            broadcast_hack.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    Intent myIntent = new Intent(MainActivity.this, BroadcastHack.class);
                    startActivity(myIntent);
                }
            }));
        }
        if (webview_screen != null) {
            webview_screen.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    Intent myIntent = new Intent(MainActivity.this, CustomWebView.class);
                    startActivity(myIntent);
                }
            }));
        }
        if (path_triversal != null) {
            path_triversal.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    Intent myIntent = new Intent(MainActivity.this, PathTriversal.class);
                    startActivity(myIntent);
                }
            }));
        }
    }
}