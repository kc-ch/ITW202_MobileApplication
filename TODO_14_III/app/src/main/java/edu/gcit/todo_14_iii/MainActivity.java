package edu.gcit.todo_14_iii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ViewDate(View view) {
        DialogFragment obj = new  DatePickerFragment();
        obj.show(getSupportFragmentManager(),"datePicker");
    }
    public void result(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);
        String day_string = Integer.toString(day);

        String msg = (month_string+"/"+ day_string+"/"+year_string);

        Toast.makeText(this,"Date: "+ msg,Toast.LENGTH_SHORT).show();
    }
}