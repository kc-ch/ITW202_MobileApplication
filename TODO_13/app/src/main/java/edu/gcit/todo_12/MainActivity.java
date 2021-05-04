package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.todo_12.extra.MESSAGE";
    FloatingActionButton floatingActionButton;
    String list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
//                intent.putExtra(EXTRA_MESSAGE, list);
//                startActivity(intent);
//            }
//        });
    }
    public void image1(View view) {
        list = getString(R.string.Donut_Order);
        displayToast(list);
        Toast toast = Toast.makeText(this, R.string.donut_s, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void displayToast(String list) {
    }

    public void img2(View view) {
        list = getString(R.string.iceCream_Order);
        displayToast(list);
        Toast toast = Toast.makeText(this, R.string.ice_s, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void img3(View view) {
        list = getString(R.string.Froyo_Order);
        displayToast(list);
        Toast toast = Toast.makeText(this, R.string.froyo_s, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void order(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, list);
        startActivity(intent);
    }
}