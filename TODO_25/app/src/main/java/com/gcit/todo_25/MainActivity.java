package com.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Fname, Lname, id, num;
    Button add, view, update, delete;

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        Fname = findViewById(R.id.Fname);
        Lname = findViewById(R.id.Lname);
        id = findViewById(R.id.id);
        num = findViewById(R.id.num);

        add = (Button) findViewById(R.id.add);
        view = (Button) findViewById(R.id.view);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
    }

    public void AddDate(View view) {
        //get all the texts
        boolean isInserted = myDb.insertData(id.getText().toString(), Fname.getText().toString(),
                Lname.getText().toString(), num.getText().toString());

        if (isInserted == true){
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
        }
    }

    public void ViewAll(View view) {
        Cursor res = myDb.getAllDate();
        if (res.getCount()==0){
            showMessage("Error", "Nothing found");
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Student id : "+ res.getString(0)+"\n");
            buffer.append("First Name : "+ res.getString(1)+"\n");
            buffer.append("Last Name : "+ res.getString(2)+"\n");
            buffer.append("ITW202 marks : "+ res.getString(3)+"\n\n");

        }
        showMessage("List of students", buffer.toString());
    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void update(View view) {
        boolean isUpdate = myDb.updateDate(id.getText().toString(), Fname.getText().toString(),
                Lname.getText().toString(), num.getText().toString());
        if (isUpdate == true){
           Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
    }

    public void Delete(View view) {
        Integer deleteRows = myDb.deleteData(id.getText().toString());
        if (deleteRows>0){
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
    }
}