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
<EditText 
android:id="@+id/editText2" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignLeft="@+id/button2" 
android:layout_alignParentTop="true" 
android:layout_marginTop="16dp" 
android:ems="10" 
android:hint="Name" 
android:textColorHint="@android:color/holo_blue_light" > 
<requestFocus /> 
</EditText> 
<EditText 
android:id="@+id/editText3" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignEnd="@+id/editText2" 
android:layout_alignRight="@+id/editText2" 
android:layout_alignStart="@+id/editText2" 
android:layout_below="@+id/editText2" 
android:layout_marginRight="17dp" 
android:layout_marginTop="42dp" 
android:ems="10" 
android:hint="Grade" 
android:textColorHint="@android:color/holo_blue_bright" /> 
<Button 
android:id="@+id/button2" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignEnd="@+id/textView2" 
android:layout_alignParentLeft="true" 
android:layout_alignStart="@+id/textView2" 
android:layout_centerVertical="true" 
android:layout_marginLeft="24dp" 
android:onClick="onClickAddName" 
android:text="Add Name" /> 
<Button 
android:id="@+id/button" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_alignEnd="@+id/editText3" 
android:layout_alignParentLeft="true" 
android:layout_alignStart="@+id/button2" 
android:layout_below="@+id/button2" 
android:layout_marginTop="35dp" 
android:onClick="onClickRetrieveStudents" 
android:text="Retrive student" /> 
</RelativeLayout> 
MainActivity.java 
package com.example.contentprovider; 
import android.os.Bundle; 
import android.app.Activity; 
import android.net.Uri; 
import android.content.ContentValues; 
import android.database.Cursor; 
import android.view.View; 
import android.widget.EditText; 
import android.widget.Toast; 
public class MainActivity extends Activity { 
@Override 
protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
} 
public void onClickAddName(View view) { 
// Add a new student record 
ContentValues values = new ContentValues(); 
values.put(StudentsProvider.NAME, 
((EditText)findViewById(R.id.editText2)).getText().toString()); 
values.put(StudentsProvider.GRADE, 
((EditText)findViewById(R.id.editText3)).getText().toString()); 
Uri uri = getContentResolver().insert( 
StudentsProvider.CONTENT_URI, values); 
Toast.makeText(getBaseContext(), 
uri.toString(), Toast.LENGTH_LONG).show(); 
} 
public void onClickRetrieveStudents(View view) { 
// Retrieve student records 
String URL = "content://com.example.MyApplication.StudentsProvider"; 
Uri students = Uri.parse(URL); 
Cursor c = managedQuery(students, null, null, null, "name"); 
if (c.moveToFirst()) { 
do{ 
Toast.makeText(this, 
c.getString(c.getColumnIndex(StudentsProvider._ID)) + 
", " + c.getString(c.getColumnIndex( StudentsProvider.NAME)) + 
", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)), 
Toast.LENGTH_SHORT).show(); 
} while (c.moveToNext()); 
} 
} 
} 
StudentProvider.java 
package com.example.contentprovider; 
import java.util.HashMap; 
import android.content.ContentProvider; 
import android.content.ContentUris; 
import android.content.ContentValues; 
import android.content.Context; 
import android.content.UriMatcher; 
import android.database.Cursor; 
import android.database.SQLException; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 
import android.database.sqlite.SQLiteQueryBuilder;import android.net.Uri; 
import android.text.TextUtils; 
public class StudentsProvider extends ContentProvider { 
static final String PROVIDER_NAME = 
"com.example.MyApplication.StudentsProvider"; 
static final String URL = "content://" + PROVIDER_NAME + "/students"; 
static final Uri CONTENT_URI = Uri.parse(URL); 
static final String _ID = "_id"; 
static final String NAME = "name"; 
static final String GRADE = "grade"; 
private static HashMap<String, String> STUDENTS_PROJECTION_MAP; 
static final int STUDENTS = 1; 
static final int STUDENT_ID = 2; 
static final UriMatcher uriMatcher; 
static{ 
uriMatcher = new UriMatcher(UriMatcher.NO_MATCH); 
uriMatcher.addURI(PROVIDER_NAME, "students", STUDENTS); 
uriMatcher.addURI(PROVIDER_NAME, "students/#", STUDENT_ID); 
} 
/** 
* Database specific constant declarations 
*/ 
private SQLiteDatabase db; 
static final String DATABASE_NAME = "College"; 
static final String STUDENTS_TABLE_NAME = "students"; 
static final int DATABASE_VERSION = 1; 
static final String CREATE_DB_TABLE = 
" CREATE TABLE " + STUDENTS_TABLE_NAME + 
" (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
" name TEXT NOT NULL, " + 
" grade TEXT NOT NULL);"; 
/** 
* Helper class that actually creates and manages 
* the provider's underlying data repository. 
*/ 
private static class DatabaseHelper extends SQLiteOpenHelper { 
DatabaseHelper(Context context){ 
super(context, DATABASE_NAME, null, DATABASE_VERSION); 
} 
@Override 
public void onCreate(SQLiteDatabase db) { 
db.execSQL(CREATE_DB_TABLE); 
} 
@Override 
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
{ 
db.execSQL("DROP TABLE IF EXISTS " + 
STUDENTS_TABLE_NAME); 
onCreate(db); 
} 
} 
@Override 
public boolean onCreate() { 
Context context = getContext(); 
DatabaseHelper dbHelper = new DatabaseHelper(context); 
/** 
* Create a write able database which will trigger its 
* creation if it doesn't already exist. 
*/ 
db = dbHelper.getWritableDatabase(); 
return (db == null)? false:true; 
} 
@Override 
public Uri insert(Uri uri, ContentValues values) { 
/** 
* Add a new student record 
*/ 
long rowID = db.insert( STUDENTS_TABLE_NAME, "", values); 
/** 
* If record is added successfully 
*/ 
if (rowID > 0) { 
Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID); 
getContext().getContentResolver().notifyChange(_uri, null); 
return _uri; 
} 
throw new SQLException("Failed to add a record into " + uri); 
} 
@Override 
public Cursor query(Uri uri, String[] projection,String selection,String[] 
selectionArgs, String sortOrder) { 
SQLiteQueryBuilder qb = new SQLiteQueryBuilder(); 
qb.setTables(STUDENTS_TABLE_NAME); 
switch (uriMatcher.match(uri)) { 
case STUDENTS: 
qb.setProjectionMap(STUDENTS_PROJECTION_MAP); 
break; 
case STUDENT_ID: 
qb.appendWhere( _ID + "=" + uri.getPathSegments().get(1)); 
break; 
default: 
} 
if (sortOrder == null || sortOrder == ""){ 
/** 
* By default sort on student names 
*/ 
sortOrder = NAME; 
} 
Cursor c = qb.query(db, projection, 
selection, 
selectionArgs,null, null, sortOrder); 
/** 
* register to watch a content URI for changes 
*/ 
c.setNotificationUri(getContext().getContentResolver(), uri); 
return c; 
} 
@Override 
public int delete(Uri uri, String selection, String[] selectionArgs) { 
int count = 0; 
switch (uriMatcher.match(uri)){ 
case STUDENTS: 
count = db.delete(STUDENTS_TABLE_NAME, selection, selectionArgs); 
break; 
case STUDENT_ID: 
String id = uri.getPathSegments().get(1); 
count = db.delete( STUDENTS_TABLE_NAME, _ID + " = " + id + 
(!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), 
selectionArgs); 
break; 
default: 
throw new IllegalArgumentException("Unknown URI " + uri); 
} 
getContext().getContentResolver().notifyChange(uri, null); 
return count; 
} 
@Override 
public int update(Uri uri, ContentValues values,String selection, String[] 
selectionArgs) { 
int count = 0; 
switch (uriMatcher.match(uri)) { 
case STUDENTS: 
count = db.update(STUDENTS_TABLE_NAME, values, selection, 
selectionArgs); 
break; 
case STUDENT_ID: 
count = db.update(STUDENTS_TABLE_NAME, values, 
_ID + " = " + uri.getPathSegments().get(1) + 
(!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""), 
selectionArgs); 
break; 
default: 
throw new IllegalArgumentException("Unknown URI " + uri ); 
} 
getContext().getContentResolver().notifyChange(uri, null); 
return count; 
} 
@Override 
public String getType(Uri uri) { 
switch (uriMatcher.match(uri)){ 
/** 
* Get all student records 
*/ 
case STUDENTS: 
return "vnd.android.cursor.dir/vnd.example.students"; 
/** 
* Get a particular student 
*/ 
case STUDENT_ID: 
return "vnd.android.cursor.item/vnd.example.students"; 
default: 
throw new IllegalArgumentException("Unsupported URI: " + uri); 
} 
} 
} 
Manifest.xml 
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
package="com.example.contentprovider" 
android:versionCode="1" 
android:versionName="1.0" > 
<uses-sdk 
android:minSdkVersion="14" 
android:targetSdkVersion="18" /> 
<application 
android:allowBackup="true" 
android:icon="@drawable/ic_launcher" 
android:label="@string/app_name" 
android:theme="@style/AppTheme" > 
<activity 
android:name="com.example.contentprovider.MainActivity" 
android:label="@string/app_name" > 
<intent-filter> 
<action android:name="android.intent.action.MAIN" /> 
<category android:name="android.intent.category.LAUNCHER" /> 
</intent-filter> 
</activity> 
<provider android:name="StudentsProvider" 
android:authorities="com.example.MyApplication.StudentsProvider"/> 
</application> 
</manifest>