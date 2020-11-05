package com.example.fishmob;
  // in this recyclerview.java class, we pass the argument created in the fishitemcardviewer.java.
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewer extends AppCompatActivity  {
    // in order for the recycle viewer to work we need the following three parts.
    private RecyclerView mRecyclerView;    //this part is contain the contents we create in the activity_recycler_viewer.xml or fishitemcard.xml
     RecyclerView.Adapter  mAdapter;  // this part  act as a brige between our data wchich is array list and the recyclerviewer;
    private RecyclerView.LayoutManager mLayoutManager; // this part is responsible for align the single items in our arraylist.
    ArrayList<fishitemcardviewer> fishitemcardviewers;
    EditText msearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_viewer);
       fishitemcardviewers = new ArrayList<>();

        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishone, "Kambare", "7.5Kg", "8500Tshs."));  //names should be changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishtwo, "Sato", "2.5Kg", "45Kshs."));   //names may changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishthree, "Kibua", "4.5Kg", "4500Tshs.")); //names may changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishfour, "Perege", "6.5Kg", "3500Tsh."));
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishone, "Nguva", "6.4Kg.", "5500Tshs"));  //names should be changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishtwo, "Perege", "6.7Kg", "6500Tshs."));   //names may changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishthree, "Sato", "5.5Kg", "4500Tshs")); //names may changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishfour, "Kambare", "8Kg", "6700Tshs."));//names may changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishone, "Nguva", "10Kg", "10000Tshs."));  //names should be changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishtwo, "Sato", "4.5Kg", "9000Tshs."));   //names may changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishthree, "Kibua", "7.8Kg", "4500Tshs")); //names may changes
        fishitemcardviewers.add(new fishitemcardviewer(R.drawable.fishfour, "Kambare", "6.7Kg", "7800Tshs."));
        mRecyclerView =findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new FishAdapter(this, fishitemcardviewers);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        msearch = findViewById(R.id.editTextSearch);

        msearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString().toUpperCase());
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString().toUpperCase());
            }
        });

    }
    //here is code usees to join with the menu file
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.fish_menu, menu);

        MenuItem SearchItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) SearchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                 // mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
    void filter(String text){
        List<fishitemcardviewer> temp = new ArrayList();
        for(fishitemcardviewer d:  fishitemcardviewers){
            if(d.getNameOfFish().trim().toLowerCase().contains(text.trim().toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
       fishitemcardviewers.clear();
        fishitemcardviewers = (ArrayList<fishitemcardviewer>) temp;
        mAdapter.notifyDataSetChanged();
    }



}