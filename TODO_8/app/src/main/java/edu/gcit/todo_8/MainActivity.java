package edu.gcit.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
    }

    public void Website(View view) {
        String text = edit1.getText().toString();
        Uri url= Uri.parse(text);
        Intent obj = new Intent(Intent.ACTION_VIEW, url);
        startActivity(obj);
        if (obj.resolveActivity(getPackageManager())!=null){
            startActivity(obj);
        }
    }

    public void location(View view) {
        String location = edit2.getText().toString();
        Uri url =Uri.parse("geo:0,0?q="+location);
        Intent obj = new Intent(Intent.ACTION_VIEW, url);
        if (obj.resolveActivity(getPackageManager())!=null){
            startActivity(obj);
        }
        startActivity(obj);
    }

    public void share(View view) {
        String share = edit3.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with:")
                .setText(share)
                .startChooser();
    }
}