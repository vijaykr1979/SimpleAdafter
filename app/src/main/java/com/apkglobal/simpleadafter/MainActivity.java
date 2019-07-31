package com.apkglobal.simpleadafter;

import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] name = {"ranjay", "sanjay", "manjay","dhananjay"};
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        /*to access predefined layout*/
        List<HashMap<String, String>> list = new ArrayList<>();
        for (int i=0; i< name.length;i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name",name[i]);
            list.add(hashMap);

        }
        String [] from = {"name"};
        int [] to = {android.R.id.text1};
        sa = new SimpleAdapter(this, list, android.R.layout.simple_expandable_list_item_1,
        from, to);
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText( MainActivity.this, name[i], Toast.LENGTH_LONG).show();
                switch (i)
                {
                    case 0:
                        Intent home = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(home);
                        break;

                }
            }
        });

    }
}
