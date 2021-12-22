package com.example.paul.yhek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.ImageButton;
import android.view.*;
import android.widget.EditText;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    ArrayList<String> store;
    ArrayAdapter<String> adapter;
    String edivalues;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        android.R.drawable.ic_menu_add
        edit = (EditText) findViewById(R.id.edit);
        edit.setText("");
        ImageButton doneB = (ImageButton) findViewById(R.id.doneB);
        doneB.setOnClickListener(doneBListener);
        ListView toDoList = (ListView) findViewById(R.id.toDoList);
        store = new ArrayList<String>();
         adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, store);
        toDoList.setAdapter(adapter);
    }

     View.OnClickListener doneBListener = new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             edivalues = edit.getText().toString();
             if (edivalues.equals("")) {
                 displaye("Please enter the Todo item");
             }
             else{
                 store.add(0,edivalues);
                 adapter.notifyDataSetChanged();
                 edit.setText("");
             }
         }


     } ;
         public void displaye(String m){
             Toast.makeText(getBaseContext(), m , Toast.LENGTH_SHORT).show();
         }

}
