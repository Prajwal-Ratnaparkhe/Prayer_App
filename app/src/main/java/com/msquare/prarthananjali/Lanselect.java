package com.msquare.prarthananjali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lanselect extends AppCompatActivity {

    ListView list;


    String[] maintitle ={
            "Marathi","Hindi",
            "English",
    };

    String[] subtitle ={
            " "," ",
            " ",
    };

    Integer[] imgid={
            R.drawable.marathi,R.drawable.hindi,
            R.drawable.english,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanselect);

        getSupportActionBar().setTitle(" Select Language ");


//        ListView listView =findViewById(R.id.listview);
//         List<String> list = new ArrayList<>();
//         list.add("Marathi");
//        list.add("English");
//        list.add("Hindi");
//
//
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(i==0)
//                {
//
//                    startActivity(new Intent(Lanselect.this,MainActivity.class));
//                    finish();
//                }
//
//                else if(i==1)
//                {
//
//                    Toast.makeText(Lanselect.this,"English language not set yet",Toast.LENGTH_SHORT).show();
//
//                }
//
//                else if(i==2)
//                {
//
//                    Toast.makeText(Lanselect.this,"Hindi language not set yet",Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//
//

        MyListView adapter=new MyListView(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item

                    startActivity(new Intent(Lanselect.this,MainActivity.class));
                   finish();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"Hindi",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"English",Toast.LENGTH_SHORT).show();
                }


            }
        });







    }

    }












