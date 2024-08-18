package net.ammarafzal.practice;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.PackageManager;
import android.widget.Toast;

import java.util.List;

public class BroadcastHack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_broadcast_hack);
        Button arm_btn = findViewById(R.id.arm_btn);
        Button disarm_btn = findViewById(R.id.disarm_btn);

        if (arm_btn != null) {
            arm_btn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    if(isPackageExisted("com.apphacking.broadcastreceiver")){
                        Intent myIntent = new Intent();
                        myIntent.setAction("com.apphacking.broadcastreceiver.alarmState");
                        myIntent.putExtra("status", "arm");
                        sendBroadcast(myIntent);
                    }
                    else{
                        Toast.makeText(BroadcastHack.this, "Please install Alarm System APK",
                                Toast.LENGTH_LONG).show();
                    }

                }
            }));
        }
        if (disarm_btn != null) {
            disarm_btn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    if(isPackageExisted("com.apphacking.broadcastreceiver")){
                    Intent myIntent = new Intent();
                    myIntent.setAction("com.apphacking.broadcastreceiver.alarmState");
                    myIntent.putExtra("status", "disarm");
                    sendBroadcast(myIntent);
                    }
                    else{
                        Toast.makeText(BroadcastHack.this, "Please install Alarm System APK",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }));
        }
    }
    public boolean isPackageExisted(String targetPackage){
        List<ApplicationInfo> packages;
        PackageManager pm;

        pm = getPackageManager();
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if(packageInfo.packageName.equals(targetPackage))
                return true;
        }
        return false;
    }
}