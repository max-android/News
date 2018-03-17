package com.myexamplenews.news.ui.screen;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.myexamplenews.news.R;
import com.myexamplenews.news.model.pojo.Item;
import com.myexamplenews.news.ui.general.Constants;

public class MainActivity extends AppCompatActivity implements TransmitterData,DetailFragment.ShowNews {


    private FragmentManager fragmentManager;
private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        showNewsFragment();

    }


    private void initComponents(){

        toolbar=(Toolbar)findViewById(R.id.tbMain);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(getString(R.string.news));

        fragmentManager = getSupportFragmentManager();

    }



    private void showNewsFragment(){
        NewsFragment newsFragment = new NewsFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frame,newsFragment);

        transaction.commitAllowingStateLoss();

    }


    private void showDetailFragment(Item item){

        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable(Constants.KEY,item);
        detailFragment.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frame,detailFragment);
        transaction.addToBackStack(Constants.NAME_DET);
        transaction.commitAllowingStateLoss();
    }


    @Override
    public void transferData(Item item) {

        showDetailFragment(item);

        toolbar.setTitle(getString(R.string.detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(exit -> fragmentManager.popBackStack());
    }

    @Override
    public void notice() {

        toolbar.setTitle(getString(R.string.news));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

}
