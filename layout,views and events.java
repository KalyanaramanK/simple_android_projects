activiy_main.xml 
<?xml version="1.0" encoding="utf-8"?> 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:app="http://schemas.android.com/apk/res-auto" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
android:background="#FFF59D" 
tools:context="com.example.android.myapplication.MainActivity"> 
<!--Light Yellow Color--> 
<LinearLayout 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:orientation="vertical" 
android:id="@+id/l1" 
android:background="#FF9E80"> 
<!--Light Pink Color--> 
<TextView 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="ROEVER COLLEGE" 
android:textAllCaps="true" 
android:textSize="40dp" 
android:textColor="#F44336"/> 
</LinearLayout> 
<LinearLayout 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:orientation="horizontal" 
android:layout_below="@id/l1" 
android:background="#039BE5" 
android:id="@+id/l2"> 
<!--Light Blue Color--> 
<TextView 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="III BCA" 
android:textAllCaps="true" 
android:textSize="30dp" 
android:textColor="#76FF03" 
/> 
</LinearLayout> 
<RelativeLayout 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:layout_below="@id/l2" 
android:background="#7E57C2" 
> 
<!--Light Purple Color--> 
<Button 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="Toast 1" 
android:id="@+id/b1" 
/> 
<Button 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="Toast 2" 
android:layout_toRightOf="@id/b1" 
android:id="@+id/b2" 
/> 
<Button 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="Toast 3" 
android:layout_below="@id/b1" 
android:id="@+id/b3" 
/> 
<Button 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="Toast 4" 
android:layout_below="@id/b2" 
android:layout_toRightOf="@id/b3" 
/> 
</RelativeLayout> 
</RelativeLayout>


tput ScreenEvent Handling: 
Activity_main.xml 
<?xml version="1.0" encoding="utf-8"?> 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="match_parent" 
android:layout_height="match_parent" 
tools:context="MainActivity"> 
<ImageButton 
android:id="@+id/imageButton" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignParentTop="true" 
android:layout_centerHorizontal="true" 
android:layout_marginTop="20dp" 
android:src="@drawable/download" /> 
<Button 
android:id="@+id/button" 
android:layout_width="150dp" 
android:layout_height="wrap_content" 
android:layout_alignLeft="@+id/imageButton" 
android:layout_below="@+id/tv_java" 
android:layout_marginLeft="15dp" 
android:layout_marginTop="60dp" 
android:background="#3700B3" 
android:text="Change Color" 
android:textColor="@android:color/background_light" /> 
<TextView 
android:id="@+id/tv_welcome" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignRight="@+id/imageButton" 
android:layout_below="@+id/imageButton" 
android:layout_marginTop="40dp" 
android:text="Welcome to " 
android:textColor="#3700B3" 
android:textSize="40dp" /> 
<TextView 
android:id="@+id/tv_java" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_below="@+id/tv_welcome" 
android:layout_centerHorizontal="true" 
android:text="Android" 
android:textColor="#3700B3" 
android:textSize="40dp" /> 
</RelativeLayout> 
MainActivity.java 
package com.example.eventhandling; 
import android.os.Bundle; 
import android.app.Activity; 
import android.graphics.Color; 
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
public class MainActivity extends Activity { 
TextView welcome; 
TextView java; 
Button button; 
int i=0; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
welcome = (TextView)findViewById(R.id.tv_welcome); 
java = (TextView)findViewById(R.id.tv_java); 
button = (Button) findViewById(R.id.button); 
button.setOnClickListener(new View.OnClickListener() { 
@Override 
public void onClick(View arg0) { 
// TODO Auto-generated method stub 
if(i==0) { 
welcome.setTextColor(Color.BLACK); 
java.setTextColor(Color.BLACK); 
button.setBackgroundColor(Color.BLACK); 
} 
if(i==1) { 
welcome.setTextColor(Color.GREEN); 
java.setTextColor(Color.GREEN); 
button.setBackgroundColor(Color.GREEN); 
} 
if(i==2) { 
welcome.setTextColor(Color.BLUE); 
java.setTextColor(Color.BLUE); 
button.setBackgroundColor(Color.BLUE); 
} 
if(i==3) { 
welcome.setTextColor(Color.MAGENTA); 
java.setTextColor(Color.MAGENTA); 
button.setBackgroundColor(Color.MAGENTA); 
i=0; 
} 
i++; 
} 
}); 
}}