Activity_first.xml 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:paddingBottom="@dimen/activity_vertical_margin" 
android:paddingLeft="@dimen/activity_horizontal_margin" 
android:paddingRight="@dimen/activity_horizontal_margin" 
android:paddingTop="@dimen/activity_vertical_margin" 
tools:context=".FirstActivity" > 
<EditText 
android:id="@+id/edit_username" 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:layout_alignParentTop="true" 
android:layout_marginTop="27dp" 
android:ems="10" 
android:hint="Enter Username" > 
<requestFocus /> 
</EditText> 
<EditText 
android:id="@+id/edit_password" 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:layout_below="@+id/edit_username" 
android:layout_centerHorizontal="true" 
android:layout_marginTop="48dp" 
android:ems="10" 
android:hint="Enter Password" /> 
<Button 
android:id="@+id/button1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_below="@+id/edit_password" 
android:layout_centerHorizontal="true" 
android:layout_marginTop="16dp" 
android:onClick="callCheck" 
android:text="Check" /> 
</RelativeLayout> 
Activity_second.xml 
<?xml version="1.0" encoding="utf-8"?> 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
android:layout_width="match_parent" 
android:layout_height="match_parent" > 
<TextView 
android:id="@+id/tv_username" 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:layout_alignParentTop="true" 
android:layout_centerHorizontal="true" 
android:layout_marginTop="72dp" 
android:textAppearance="?android:attr/textAppearanceMedium" /> 
</RelativeLayout> 
FirstActivity.java 
package com.example.loginpage; 
import android.os.Bundle; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.Menu; 
import android.view.View; 
import android.widget.EditText; 
import android.widget.Toast; 
public class FirstActivity extends Activity { 
EditText uName,pwd; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_first); 
uName = (EditText) findViewById(R.id.edit_username); 
pwd = (EditText) findViewById(R.id.edit_password); 
} 
public void callCheck(View v) { 
if (uName.getText().toString().equalsIgnoreCase("ram") && 
pwd.getText().toString().equalsIgnoreCase("ram")) { 
Intent i = new Intent (this,Second.class); 
i.putExtra("UserName",uName.getText().toString()); 
startActivity(i); 
} else { 
Toast.makeText(getBaseContext(),"Either username & password is 
incorrect", Toast.LENGTH_SHORT).show(); 
} 
} 
@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
// Inflate the menu; this adds items to the action bar if it is present. 
getMenuInflater().inflate(R.menu.first, menu); 
return true; 
} 
} 
Second.java 
package com.example.loginpage; 
import android.os.Bundle; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.Menu; 
import android.widget.TextView; 
public class Second extends Activity { 
TextView tvUname, pwd; 
Intent oldIntent; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_second); 
tvUname = (TextView) findViewById(R.id.tv_username); 
pwd =(TextView) findViewById(R.id.edit_password); 
oldIntent = getIntent(); 
tvUname.setText(oldIntent.getStringExtra("UserName")); 
} 
} 
AndroidManifest.xml 
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
package="com.example.loginpage" 
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
android:name="com.example.loginpage.FirstActivity" 
android:label="@string/app_name" > 
<intent-filter> 
<action android:name="android.intent.action.MAIN" /> 
<category android:name="android.intent.category.LAUNCHER" /> 
</intent-filter> 
</activity> 
<activity android:name="Second"></activity> 
</application> 
</manifest>