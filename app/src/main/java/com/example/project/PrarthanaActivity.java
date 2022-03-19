package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class PrarthanaActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabItem1,tabItem2,tabItem3;

    ViewPager2 viewPager2;
    ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prarthana);

        tabLayout=(TabLayout) findViewById(R.id.tabLayout1);
        tabItem1 =(TabItem) findViewById(R.id.tab1);
        tabItem2 =(TabItem) findViewById(R.id.tab2);
        tabItem3 =(TabItem) findViewById(R.id.tab3);
        viewPager2=(ViewPager2)findViewById(R.id.vpager);


        FragmentManager fragmentManager =getSupportFragmentManager();
        
       viewPageAdapter =new ViewPageAdapter(fragmentManager,getLifecycle());
       
       viewPager2.setAdapter(viewPageAdapter);
       

     ////  tabLayout.addTab(tabLayout.newTab().setText("First tab"));
        ////    tabLayout.addTab(tabLayout.newTab().setText("second tab"));
        ////    tabLayout.addTab(tabLayout.newTab().setText("Third tab"));
        
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}