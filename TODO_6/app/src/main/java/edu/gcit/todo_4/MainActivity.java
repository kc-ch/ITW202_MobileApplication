package edu.gcit.todo_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_MESSAGE = "edu.gcit.todo_4.MESSAGE";
    private EditText mMessageEditTxt;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    private static final String LOG_TAG ="MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditTxt = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
        Log.d("MyActivity","onCreate");

        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("MyBoolean");
            if(isVisible){
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("MyValue"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("MyActivity","onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("MyActivity","onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("MyActivity","onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("MyActivity","onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyActivity","onDestroy");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d("MyActivity","onRestart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("MyBoolean", true);
        outState.putString("MyValue", mReplyTextView.getText().toString());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    public void message(View view) {
        Intent obj = new Intent(this, MainActivity2.class);
        String message = mMessageEditTxt.getText().toString();
        obj.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(obj, TEXT_REQUEST);

    }
}