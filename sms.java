Activity_sms.xml 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:paddingBottom="@dimen/activity_vertical_margin" 
android:paddingLeft="@dimen/activity_horizontal_margin" 
android:paddingRight="@dimen/activity_horizontal_margin" 
android:paddingTop="@dimen/activity_vertical_margin" 
tools:context=".MainActivity" > 
<Button 
android:id="@+id/btnSendSMS" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignParentTop="true" 
android:layout_centerHorizontal="true" 
android:layout_marginTop="30dp" 
android:text="Send SMS" /> 
</RelativeLayout> 
MainActivity.java 
package com.example.sms; 
import android.os.Bundle; 
import android.app.Activity; 
import android.telephony.SmsManager; 
import android.view.Menu; 
import android.view.View; 
import android.widget.Button; 
public class MainActivity extends Activity { 
Button btnSendSMS; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
btnSendSMS = (Button)findViewById(R.id.btnSendSMS); 
btnSendSMS.setOnClickListener(new View.OnClickListener() { 
@Overridepublic void onClick(View arg0) { 
sendSMS("5556","Roever College"); 
} 
private void sendSMS(String phonenumber, String message) { 
SmsManager sms = SmsManager.getDefault(); 
sms.sendTextMessage(phonenumber, null, message, null, 
null); 
} 
}); 
} 
} 
AndroidManifest.xml 
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
package="com.example.sms" 
android:versionCode="1" 
android:versionName="1.0" > 
<uses-sdk 
android:minSdkVersion="8" 
android:targetSdkVersion="18" /> 
<uses-permission android:name="android.permission.SEND_SMS"/> 
<application 
android:allowBackup="true" 
android:icon="@drawable/ic_launcher" 
android:label="@string/app_name" 
android:theme="@style/AppTheme" > 
<activity 
android:name="com.example.sms.SMSActivity" 
android:label="@string/app_name" > 
<intent-filter> 
<action android:name="android.intent.action.MAIN" /> 
<category android:name="android.intent.category.LAUNCHER" /> 
</intent-filter> 
</activity> 
</application> 
</manifest>