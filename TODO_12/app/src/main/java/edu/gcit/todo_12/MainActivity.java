package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void image1(View view) {
        Toast toast = Toast.makeText(this, R.string.donut_s, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void img2(View view) {
        Toast toast = Toast.makeText(this, R.string.ice_s, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void img3(View view) {
        Toast toast = Toast.makeText(this, R.string.froyo_s, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:17690059"));
        startActivity(intent);
    }
}