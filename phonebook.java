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
android:id="@+id/result" 
android:layout_width="fill_parent" 
android:layout_height="60dp" 
android:layout_alignParentLeft="true" 
android:layout_alignParentRight="true" 
android:layout_centerVertical="true" 
/> 
<Button 
android:id="@+id/btn" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignParentLeft="true" 
android:layout_alignParentRight="true" 
android:layout_alignParentTop="true" 
android:layout_marginTop="39dp" 
android:text="Pick Contact" /> 
</RelativeLayout> 
MainActivity.java 
package com.example.phonebook; 
import android.os.Bundle; 
import android.provider.ContactsContract; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.Menu; 
import android.view.View; 
import android.widget.Button;public class MainActivity extends Activity { 
private static int PICK_CONTACT = 0; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
Button btn = (Button) findViewById(R.id.btn); 
btn.setOnClickListener(new View.OnClickListener() { 
@Override 
public void onClick(View arg0) { 
pickContact(); 
} 
private void pickContact() { 
Intent intent = new Intent(Intent.ACTION_PICK, 
ContactsContract.Contacts.CONTENT_URI); 
startActivityForResult(intent, PICK_CONTACT); 
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
Manifest.xml 
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
package="com.example.phonebook" 
android:versionCode="1" 
android:versionName="1.0" > 
<uses-sdk 
android:minSdkVersion="8" 
android:targetSdkVersion="18" /> 
<uses-permission android:name="android.permission.READ_CONTACTS" /> 
<application 
android:allowBackup="true" 
android:icon="@drawable/ic_launcher" 
android:label="@string/app_name" 
android:theme="@style/AppTheme" > 
<activity 
android:name="com.example.phonebook.MainActivity" 
android:label="@string/app_name" > 
<intent-filter> 
<action android:name="android.intent.action.MAIN" /> 
<category android:name="android.intent.category.LAUNCHER" /> 
</intent-filter> 
</activity> 
</application> 
</manifest>