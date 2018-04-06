package com.example.minhthanh.lab5_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentDialog.OnInputListener, FragmentOption.OnInputListenerDelete {

    Button btnAddTodo ;

    public ListView lvContent;
    public ViewDetailAdapter viewDetailAdapter;
    public List<ViewDetail> viewDetailList =  new ArrayList<>();;
    TextView text;
    String RadioString,date,month,year,name;
    static boolean flag = false;
    FragmentDialog fragmentDialog = new FragmentDialog();
    public int position1;


    @Override
    public void sendInput(String RadioString, String date, String month, String year, String name) {

        this.RadioString = RadioString;
        this.date = date;
        this.month = month;
        this.year = year;
        this.name = name;
        System.out.println(RadioString+","+date+","+month+","+year+","+name);
        if( flag == true){
            if(RadioString.equals("HIGH"))
            {
                viewDetailList.get(position1).setLevel("HIGH");
                viewDetailList.get(position1).getLevel();
            }
            else if(RadioString.equals("NORMAL"))
            {
                viewDetailList.get(position1).setLevel("NORMAL");
                viewDetailList.get(position1).getLevel();
            }
            else {
                viewDetailList.get(position1).setLevel("LOW");
                viewDetailList.get(position1).getLevel();
            }

            viewDetailList.get(position1).setName(name);
            viewDetailList.get(position1).getName();
            viewDetailList.get(position1).setDate(date+"/"+month+"/"+year);
            viewDetailList.get(position1).getDate();
            viewDetailAdapter.notifyDataSetChanged();
            flag = false;
        }

        else{
        viewDetailList.add(new ViewDetail(date+"/"+month+"/"+year,name,RadioString));
        viewDetailAdapter.notifyDataSetChanged();}
    }

    @Override
    public void sendInputDelete(String Delete) {

        viewDetailList.remove(viewDetailAdapter.getItem(position1));
        viewDetailAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddTodo = (Button) findViewById(R.id.btnAddItem);
        lvContent = (ListView) findViewById(R.id.lvItems);

        viewDetailAdapter = new ViewDetailAdapter(getApplicationContext(),viewDetailList);
        lvContent.setAdapter(viewDetailAdapter);

        viewDetailList.add(new ViewDetail("23/11/1996","Thanh Nguyen","HIGH"));
        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentDialog.show(getSupportFragmentManager(),"FragmentDialog");
            }
        });

        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                position1 = position;
                flag = true;
                fragmentDialog.show(getSupportFragmentManager(),"FragmentDialog");
            }
        });

        lvContent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                position1 = position;
                FragmentOption fragmentOption = new FragmentOption();
                fragmentOption.show(getSupportFragmentManager(),"FragmentOption");
                return true;
            }
        });

    }
}
