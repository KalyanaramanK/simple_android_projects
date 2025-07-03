Activity_first.xml 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:paddingBottom="@dimen/activity_vertical_margin" 
android:paddingLeft="@dimen/activity_horizontal_margin" 
android:paddingRight="@dimen/activity_horizontal_margin" 
android:paddingTop="@dimen/activity_vertical_margin" 
tools:context=".First" > 
<EditText 
android:id="@+id/editText1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignParentLeft="true" 
android:layout_alignParentTop="true" 
android:layout_marginLeft="30dp" 
android:layout_marginTop="33dp" 
android:ems="10" 
android:inputType="textPersonName" /> 
<Button 
android:id="@+id/button1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignLeft="@+id/editText1" 
android:layout_below="@+id/editText1" 
android:layout_marginLeft="48dp" 
android:layout_marginTop="49dp" 
android:text="GO" /> 
</RelativeLayout> 
Second_activity.xml 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:paddingBottom="@dimen/activity_vertical_margin" 
android:paddingLeft="@dimen/activity_horizontal_margin" 
android:paddingRight="@dimen/activity_horizontal_margin" 
android:paddingTop="@dimen/activity_vertical_margin" 
tools:context=".SecondActivity" > 
<TextView 
android:id="@+id/textView1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignParentLeft="true" 
android:layout_alignParentTop="true" 
android:layout_marginLeft="92dp" 
android:layout_marginTop="97dp" 
android:text="Large Text" 
android:textAppearance="?android:attr/textAppearanceLarge"/> 
<Button 
android:id="@+id/button1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignLeft="@+id/textView1" 
android:layout_below="@+id/textView1" 
android:layout_marginTop="32dp" 
android:text="Finish" /> 
</RelativeLayout> 
First.java 
package com.example.intent; 
import android.os.Bundle; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.Menu; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
public class First extends Activity { 
EditText et; 
Button btn; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_first); 
et= (EditText) findViewById(R.id.editText1); 
btn = (Button) findViewById(R.id.button1); 
btn.setOnClickListener(new View.OnClickListener() {@Override 
public void onClick(View arg0) { 
// TODO Auto-generated method stub 
Intent myintent = new 
Intent(getApplicationContext(),Second.class); 
myintent.putExtra("myname", et.getText().toString()); 
startActivity (myintent); 
} 
}); 
} 
@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
// Inflate the menu; this adds items to the action bar if it is present. 
getMenuInflater().inflate(R.menu.first, menu); 
return true; 
} 
} 
Second.java 
package com.example.intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
import android.app.Activity; 
public class Second extends Activity { 
TextView tv; 
Button btn; 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_second); 
tv = (TextView) findViewById(R.id.textView1); 
btn =(Button) findViewById(R.id.button1); 
tv.setText(getIntent().getStringExtra("myname").toString()); 
btn.setOnClickListener(new View.OnClickListener() {@Override 
public void onClick(View arg0) { 
finish(); 
} 
}); 
} 
} 
AndroidManifest.xml 
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
package="com.example.intent" 
android:versionCode="1" 
android:versionName="1.0" > 
<uses-sdk 
android:minSdkVersion="8" 
android:targetSdkVersion="18" /> 
<application 
android:allowBackup="true" 
android:icon="@drawable/ic_launcher" 
android:label="@string/app_name" 
android:persistent="true" 
android:theme="@style/AppTheme" android:requiredForAllUsers="true"> 
<activity 
android:name="com.example.intent.First" 
android:label="@string/app_name" > 
<intent-filter> 
<action android:name="android.intent.action.MAIN" /> 
<category android:name="android.intent.category.LAUNCHER" /> 
</intent-filter> 
</activity> 
<activity android:name=".Second"></activity> 
</application> 
</manifest>