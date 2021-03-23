package edu.gcit.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "edu.gcit.todo_4.REPLY";
    private EditText mReplyEditTxt;
    private TextView textView;
    private static final String LOG_TAG ="MyActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent obj = getIntent();
        String message = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        mReplyEditTxt = findViewById(R.id.editText_second);
        Log.d("MyActivity2","onCreate");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("MyActivity2","onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("MyActivity2","onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("MyActivity2","onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("MyActivity2","onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyActivity2","onDestroy");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d("MyActivity2","onRestart");
    }

    public void returnReply(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String reply = mReplyEditTxt.getText().toString();
        intent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}