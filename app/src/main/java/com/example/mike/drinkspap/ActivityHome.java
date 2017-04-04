package com.example.mike.drinkspap;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mike.drinkspap.Fragments.FavouritesFragment;
import com.example.mike.drinkspap.Fragments.HomeFragment;
import com.example.mike.drinkspap.Fragments.DeliveriesFragment;
import com.example.mike.drinkspap.Interfaces.NavigationInterface;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;


public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Fragment fragment;
    FragmentManager fragmentManager;

    private static final String TAG = ActivityHome.class.getSimpleName();

    // collections
    private SparseIntArray items;// used for change ViewPager selected item
    private List<Fragment> fragments = new ArrayList<>();// used for ViewPager adapter

    BottomNavigationViewEx navigationViewEx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragments.add(HomeFragment.newInstance("test", "test"));
        fragments.add(FavouritesFragment.newInstance("test", "test"));
        fragments.add(DeliveriesFragment.newInstance("test", "test"));

        items = new SparseIntArray();
        items.put(R.id.navigation_home,0);
        items.put(R.id.navigation_favorites,1);
        items.put(R.id.navigation_whatshot,2);

        final ViewPager pager = (ViewPager) findViewById(R.id.vp);
        navigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bnve);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragments));
        navigationViewEx.setupWithViewPager(pager);

        navigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private int previousPosition = -1;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int position = items.get(item.getItemId());
                if (previousPosition != position) {
                    // only set item when item changed
                    previousPosition = position;
                    Log.i(TAG, "-----bnve-------- previous item:" + navigationViewEx.getCurrentItem() + " current item:" + position + " ------------------");
                    pager.setCurrentItem(position);
                }
                return true;            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        List<Fragment> fragmentList;
        public ViewPagerAdapter(FragmentManager manager, List<Fragment> fragmentList){
            super(manager);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}
