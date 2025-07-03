Create Application which uses the concept of Services and Background Threats 
Activity_main.xml 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:paddingBottom="@dimen/activity_vertical_margin" 
android:paddingLeft="@dimen/activity_horizontal_margin" 
android:paddingRight="@dimen/activity_horizontal_margin" 
android:paddingTop="@dimen/activity_vertical_margin" 
tools:context=".MainActivity" > 
<TextView 
android:id="@+id/textView1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignParentLeft="true" 
android:layout_alignParentTop="true" 
android:layout_marginLeft="80dp" 
android:layout_marginTop="71dp" 
android:text="Large Text" 
android:textAppearance="?android:attr/textAppearanceLarge" /> 
</RelativeLayout> 
MainActivity.java 
package com.example.myservice; 
import android.os.Bundle; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.Menu; 
import android.view.View; 
import android.widget.TextView; 
public class MainActivity extends Activity { 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
final TextView text = (TextView) findViewById(R.id.textView1); 
text.setOnClickListener(new View.OnClickListener() { 
@Override 
public void onClick(View v) { 
if (text.getText().toString().equals("Started")) { 
text.setText("Stopped"); 
stopService(new Intent(MainActivity.this,service.class)); 
} else { 
text.setText("Started"); 
startService(new Intent(MainActivity.this,service.class)); 
} 
} 
}); 
} 
@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
// Inflate the menu; this adds items to the action bar if it is present. 
getMenuInflater().inflate(R.menu.main, menu); 
return true; 
} 
} 
Service.java 
package com.example.myservice; 
import android.app.Service; 
import android.content.Intent; 
import android.os.IBinder; 
import android.widget.Toast; 
public class service extends Service { 
@Override 
public IBinder onBind(Intent intent) { 
return null; 
} 
@Override 
public int onStartCommand(Intent intent, int flags, int startId) { 
Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show(); 
return START_STICKY; 
} 
@Override 
public void onDestroy() { 
super.onDestroy(); 
Toast.makeText(this, "Service destroyed by user.", Toast.LENGTH_LONG).show(); 
} 
}AndroidManifest.xml 
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
package="com.example.myservice" 
android:versionCode="1" 
android:versionName="1.0" > 
<uses-sdk 
android:minSdkVersion="8" 
android:targetSdkVersion="18" /> 
<application 
android:allowBackup="true" 
android:icon="@drawable/ic_launcher" 
android:label="@string/app_name" 
android:theme="@style/AppTheme" > 
<activity 
android:name="com.example.myservice.MainActivity" 
android:label="@string/app_name" > 
<intent-filter> 
<action android:name="android.intent.action.MAIN" /> 
<category android:name="android.intent.category.LAUNCHER" /> 
</intent-filter> 
</activity> 
<service android:name = ".service"/> 
</application> 
</manifest>