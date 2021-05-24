package edu.gcit.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "edu.gcit.todo_4.REPLY";
    private EditText mReplyEditTxt;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent obj = getIntent();
        String message = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        mReplyEditTxt = findViewById(R.id.editText_second);
    }

    public void returnReply(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String reply = mReplyEditTxt.getText().toString();
        intent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}