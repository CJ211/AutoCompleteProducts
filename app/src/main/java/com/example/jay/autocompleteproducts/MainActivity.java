package com.example.jay.autocompleteproducts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    TextView textView;
    ArrayList <String> productname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);

        productname = new ArrayList<>();
        productname.add("Apple macbook");
        productname.add("Lenovo Ideapad 310");
        productname.add("Asus R series");

        Dbhandler dbhandler = new Dbhandler(this);

        for (int i = 0; i < productname.size(); i++)
        {
            dbhandler.Addproducts(productname.get(i));
        }

        ArrayList arrayList = dbhandler.Databasetoarray();

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocompletetextview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,arrayList);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}
