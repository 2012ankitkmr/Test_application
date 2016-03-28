package com.example.ankit.test_application;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ankit on 28-03-2016.
 */
public class TextView_layout extends AppCompatActivity {

    private Button bt;
    private ListView lv;
    private ArrayList<String> strArr;
    private ArrayAdapter<String> adapter;
    private EditText et;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_layout);


        bt = (Button)findViewById(R.id.Badd);
        lv = (ListView)findViewById(R.id.listView);
        et = (EditText)findViewById(R.id.editText);

        strArr = new ArrayList <String> ();
        for(int i = 0 ; i < 2 ; i++ )
        {
            strArr.add("Row:" + i);
        }
        adapter = new ArrayAdapter <String> ( getApplicationContext() , android.R.layout.simple_list_item_1 , strArr ){
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

            /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.BLUE);

                return view;
            }
        };
        lv.setAdapter(adapter);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strArr.add(et.getText().toString());
                adapter.notifyDataSetChanged();

            }
        });


    }
}
