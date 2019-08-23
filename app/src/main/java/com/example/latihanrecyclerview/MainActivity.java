package com.example.latihanrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<President> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory=findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        // mengambil kumpulan data
        list.addAll(PresidentData.getListData());
        //proses pengisian item recycler view
        showRecyclerList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                setTitle("List");
                showRecyclerList();
                break;
            case R.id.action_grid:
                setTitle("Grid");
                showRecyclerGrid();
                break;
            case R.id.action_card:
                setTitle("Card View");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList(){
        //Membuat recycler view menjadi liner layout
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        //inisialisasi objeck adapter
        ListPresidentAdapter listPresidentAdapter= new ListPresidentAdapter(this);
        //Mengisi data list ke adap ter
        listPresidentAdapter.setListPresidents(list);
        //tampilkan data adapter ker Recycler view
        rvCategory.setAdapter(listPresidentAdapter);

    }
    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridPresidentAdapter gridPresidentAdapter= new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);
    }
}
