activity_main.xml 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" 
xmlns:tools="http://schemas.android.com/tools" 
android:layout_width="wrap_content" 
android:layout_height="match_parent" 
android:paddingBottom="@dimen/activity_vertical_margin" 
android:paddingLeft="@dimen/activity_horizontal_margin" 
android:paddingRight="@dimen/activity_horizontal_margin" 
android:paddingTop="@dimen/activity_vertical_margin" 
tools:context=".MainActivity" > 
<TextView 
android:id="@+id/tvage" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignLeft="@+id/tvdob" 
android:layout_alignParentBottom="true" 
android:text="@string/medium_text" 
android:textAppearance="?android:attr/textAppearanceMedium" /> 
<TextView 
android:id="@+id/tvdob" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_above="@+id/tvage" 
android:layout_alignParentLeft="true" 
android:layout_marginBottom="44dp" 
android:text="@string/medium_text" 
android:textAppearance="?android:attr/textAppearanceMedium" /> 
<DatePicker 
android:id="@+id/picker" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignLeft="@+id/tvdob" 
android:layout_alignParentTop="true" 
android:spinnersShown="true" 
android:calendarViewShown="false" /> 
<Button 
android:id="@+id/btnsubmit" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignRight="@+id/picker" 
android:layout_below="@+id/picker" 
android:layout_marginTop="124dp" 
android:text="Select" /> 
<EditText 
android:id="@+id/editText1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_above="@+id/tvdob" 
android:layout_alignLeft="@+id/tvdob" 
android:layout_marginBottom="18dp" 
android:ems="10" 
android:hint="Enter ur Name" /> 
</RelativeLayout> 
MainActivity.java 
package com.example.agedemo; 
import java.util.Calendar; 
import android.os.Bundle; 
import android.app.Activity; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.DatePicker; 
import android.widget.TextView; 
public class MainActivity extends Activity { 
DatePicker picker; 
Button btnsubmit; 
TextView tvdob, tvage; 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
picker = (DatePicker) findViewById(R.id.picker); 
btnsubmit = (Button) findViewById(R.id.btnsubmit); 
tvdob = (TextView) findViewById(R.id.tvdob); 
tvage =(TextView) findViewById(R.id.tvage); 
btnsubmit.setOnClickListener(new OnClickListener() {@Override 
public void onClick(View view) { 
// TODO Auto-generated method stub 
tvdob.setText(getDateofBirth()); 
tvage.setText(currentDate()); 
} 
private CharSequence currentDate() { 
// TODO Auto-generated method stub 
StringBuilder todaydate=new StringBuilder(); 
//get today's date 
Calendar today=Calendar.getInstance(); 
//calculate age by subtracting today's date year from the 
user's (picker object) selected date year 
int age=today.get(Calendar.YEAR)-picker.getYear(); 
if (today.get(Calendar.MONTH) < picker.getYear()) { 
age--; 
} else if (today.get(Calendar.MONTH) == picker.getYear() 
&& 
today.get(Calendar.DAY_OF_MONTH) < picker.getYear()) { 
age--; 
} 
todaydate.append("Age: "); 
todaydate.append(String.valueOf(age)); 
return todaydate.toString(); 
} 
private CharSequence getDateofBirth() { 
// TODO Auto-generated method stub 
StringBuilder builder=new StringBuilder(); 
builder.append("DOB: "); 
builder.append((picker.getMonth() + 1)+"/");//month is 0 based 
builder.append(picker.getDayOfMonth()+"/"); 
builder.append(picker.getYear()); 
return builder.toString(); 
} 
}); 
} 
}
