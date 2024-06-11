package com.example.medicali;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import
        androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdaptery adaptery;
    private StaggeredGridLayoutManager manager;
    private List<row> applist;
    int [] covers=new int[]{
            R.drawable.fash1,
            R.drawable.fash2,
            R.drawable.fash3,
            R.drawable.fash4,
            R.drawable.fash5,
            R.drawable.fash6

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menuu);

        recyclerView=findViewById(R.id.recyclerviewy);
        applist=new ArrayList<>();

        adaptery=new RecyclerViewAdaptery(this,applist);
        manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptery);
        InittializeDataIntoRecyclerView();


    }

    public void InittializeDataIntoRecyclerView() {
        row a=new row(covers[0]);
        applist.add(a);
        row b=new row(covers[1]);
        applist.add(b);
        row c=new row(covers[2]);
        applist.add(c);
        row d=new row(covers[3]);
        applist.add(d);
        row e=new row(covers[4]);
        applist.add(e);
        row f=new row(covers[5]);
        applist.add(f);
        adaptery.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}