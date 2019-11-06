package com.example.playarea;


//import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
//import android.support.v7.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.MenuItemCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    SearchView containersearchView;
    ListView containerSearchListView;
    ArrayList<String> containersearchlist;
    ArrayAdapter<String > searchadapter;



    EditText edtpassValue;
    Button btnpassvalue;

    DatePicker simpleDatePicker;

    Button btnPopup;

    Button btnalrt;

    ProgressBar progressbarDemo;
    Button btnprogressBar;
    private int progressStatus= 0;
    private Handler handler = new Handler();


    RatingBar ratingDemo;
    Button ratingsubmitButton;



    private Object AdapterView;


    Spinner spinnercity;
    String[] cityname={"BANGLORE","PUNE","MUMBAI","KOLKATA","RANCHI"};

    SeekBar seekbarDemo;

    EditText edtphncall;
    String telNum;
    Button btnphncall;


    ListView toolsearchlistView;
    ArrayList<String> toollist;
    ArrayAdapter<String > tooladapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        toolsearchlistView = (ListView) findViewById(R.id.listViewdemo);
//        toollist = new ArrayList<>();
//        toollist.add("Abhishek");
//        toollist.add("Bunny");
//        toollist.add("Bindiya");
//        toollist.add("Payal");
//        toollist.add("Dhruva");
//        toollist.add("Mohit");
//        toollist.add("Kriva");
//        toollist.add("Krisha");
//        toollist.add("Milan");
//        toollist.add("Kishan");
//        toollist.add("Kajal");
//        tooladapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,toollist);
//        toolsearchlistView.setAdapter(tooladapter);
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_menu, menu);
//        MenuItem searchViewItem = menu.findItem(R.id.bar_search);
//        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchView.clearFocus();
//                if(toollist.contains(query)){
//                    tooladapter.getFilter().filter(query);
//                }else{
//                    Toast.makeText(getApplicationContext(), "No Match found",Toast.LENGTH_LONG).show();
//                }
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                tooladapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }




        containersearchView = (SearchView) findViewById(R.id.containersearchView);
        containerSearchListView = (ListView) findViewById(R.id.containerSearchList);
        //Add Item to the Arraylist
        containersearchlist = new ArrayList<>();
        containersearchlist.add("Abhishek");
        containersearchlist.add("Ashok");
        containersearchlist.add("Anurag");
        containersearchlist.add("Bindiya");
        containersearchlist.add("Bunny");
        containersearchlist.add("Dhruva");
        containersearchlist.add("Kriva");
        containersearchlist.add("Krisha");
        containersearchlist.add("Milan");
        containersearchlist.add("Mohit");
        containersearchlist.add("Kishan");
        containersearchlist.add("kaushik");
        containersearchlist.add("Payal");
        containersearchlist.add("Sneha");
        searchadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,containersearchlist);
        containerSearchListView.setAdapter(searchadapter);
        containersearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(containersearchlist.contains(query)){
                    searchadapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchadapter.getFilter().filter(newText);
                return false;
            }
        });




        edtphncall=(EditText)findViewById(R.id.edtphncall);
        btnphncall=(Button)findViewById(R.id.btnphncall);
        btnphncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall=new Intent(Intent.ACTION_CALL);
                telNum=edtphncall.getText().toString();
                if(telNum.trim().isEmpty()){
                    intentCall.setData(Uri.parse("tel:567788"));
                    //Toast.makeText(getApplicationContext(),"Please Enter Num",Toast.LENGTH_SHORT).show();
                }
                else{
                    intentCall.setData(Uri.parse("tel:"+telNum));
                }
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(),"Please grant permission",Toast.LENGTH_SHORT).show();
                    requestPermission();
                }else {
                    startActivity(intentCall);
                }


            }});








        simpleDatePicker = (DatePicker)findViewById(R.id.simpleDatePicker);
        Calendar cal = Calendar.getInstance();
        simpleDatePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this,"Date :-"+simpleDatePicker.getDayOfMonth()+"\n"+
                        "Month :-"+simpleDatePicker.getMonth()+"\n"+"Year :-"+simpleDatePicker.getYear(),Toast.LENGTH_SHORT).show();

            }
        });

        btnPopup =(Button)findViewById(R.id.btndemo);
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this,btnPopup);
                popup.getMenuInflater().inflate(R.menu.option_menu,popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"You have Clicked :"+item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();
            }
        });


        btnalrt = (Button)findViewById(R.id.btnalrt);
        btnalrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Confirm Exit ??");
//                alertDialogBuilder.setIcon(R.drawable.alertdialog);
                alertDialogBuilder.setMessage("Are you sure, You want to Exit ??");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You clicked on No",Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        progressbarDemo = (ProgressBar)findViewById(R.id.ProgressBarDemo);
        btnprogressBar = (Button)findViewById(R.id.btnprogressbar);

        btnprogressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus < 100){
                            progressStatus +=10;

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressbarDemo.setProgress(progressStatus);
                                    if(progressStatus ==100){
                                        progressbarDemo.setProgress(progressStatus);
                                        Toast.makeText(getApplicationContext(),"Download Complete",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            try{
                                Thread.sleep(1000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });


        seekbarDemo = (SeekBar)findViewById(R.id.seekbarDemo);
        seekbarDemo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int seekbarProgressValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarProgressValue = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"Seekbar progress :"+seekbarProgressValue,Toast.LENGTH_SHORT).show();

            }
        });

        ratingDemo = (RatingBar)findViewById(R.id.ratingdemo);
        ratingsubmitButton = (Button)findViewById(R.id.ratingsubmitButton);

        ratingsubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rvalue = ratingDemo.getRating();
                Toast.makeText(getApplicationContext(),"Rating :"+ rvalue,Toast.LENGTH_LONG).show();
            }
        });


        final Switch SwitchDemo = (Switch) findViewById(R.id.SwitchDemo);

        SwitchDemo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(SwitchDemo.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "SwitchState :" + SwitchDemo.getTextOn().toString(), Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "SwitchState :" + SwitchDemo.getTextOff().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });




        spinnercity = (Spinner) findViewById(R.id.spinnercity);
        spinnercity.setOnItemSelectedListener(this);
        ArrayAdapter adapterspinner=new ArrayAdapter(this,android.R.layout.simple_spinner_item,cityname);
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercity.setAdapter(adapterspinner);


        edtpassValue = (EditText) findViewById(R.id.edtpassvalue);
        btnpassvalue=(Button)findViewById(R.id.btnpassvaluefrst);
        btnpassvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=edtpassValue.getText().toString();
                Intent intentpassvalue=new Intent(getApplicationContext(),PassSecondActivity.class);
                intentpassvalue.putExtra("value",value);
                startActivity(intentpassvalue);
            }
        });

    }

    private  void requestPermission(){
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(android.widget.AdapterView<?> arg0, View arg1, int position, long id) {

    }

    @Override
    public void onNothingSelected(android.widget.AdapterView<?> arg0) {

    }
}



