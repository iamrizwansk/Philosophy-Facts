package com.example.philosophyfacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.philosophyfacts.HelperClasses.HomeAdapter.CategoryAdapter;
import com.example.philosophyfacts.HelperClasses.HomeAdapter.CategoryHelperClass;
import com.example.philosophyfacts.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.philosophyfacts.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.philosophyfacts.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.philosophyfacts.HelperClasses.HomeAdapter.MostViewedHelperClass;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    RecyclerView featuredRecycler, mostViewedRecycler, categoryRecycler;
    RecyclerView.Adapter featuredAdapter, mostViewedAdapter, categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        mostViewedRecycler();
        categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler();

    }

    private void categoryRecycler() {
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> categoryLocations = new ArrayList<>();
        categoryLocations.add(new CategoryHelperClass(R.drawable.mcstore_front,"Mc Donalds"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.new_york,"New York"));
        categoryLocations.add(new CategoryHelperClass(R.drawable.manhattan_city,"Manhattan"));
        categoryAdapter = new CategoryAdapter(categoryLocations);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mcstore_front,"Mc Donalds", "sladjfdjsfljdfljdslfjsljfdljsdlfsdljjfsd;ldsljfdsljsd"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.new_york,"New York", "sladjfdjsfljdfljdslfjsljfdljsdlfsdljjfsd;ldsljfdsljsd"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.manhattan_city,"Manhattan", "sladjfdjsfljdfljdslfjsljfdljsdlfsdljjfsd;ldsljfdsljsd"));
        mostViewedAdapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(mostViewedAdapter);
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcstore_front,"Mc Donalds", "sladjfdjsfljdfljdslfjsljfdljsdlfsdljjfsd;ldsljfdsljsd"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.new_york,"New York", "sladjfdjsfljdfljdslfjsljfdljsdlfsdljjfsd;ldsljfdsljsd"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.manhattan_city,"Manhattan", "sladjfdjsfljdfljdslfjsljfdljsdlfsdljjfsd;ldsljfdsljsd"));
        featuredAdapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(featuredAdapter);

    }
}