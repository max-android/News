package com.myexamplenews.news.ui.screen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.RequestManager;
import com.myexamplenews.news.R;
import com.myexamplenews.news.di.app.App;
import com.myexamplenews.news.model.pojo.Item;
import com.myexamplenews.news.ui.general.Constants;

import javax.inject.Inject;

/**
 * Created by Максим on 14.03.2018.
 */

public class DetailFragment extends Fragment {


    @Inject
    RequestManager requestManager;

    private   Item item;
    private   ShowNews listener;



    public DetailFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initData();

        initComponents(view);


    }

    private void initData() {
        item = (Item) getArguments().getSerializable(Constants.KEY);
    }

    private void   initComponents(View view){

        App.getAppComponent().injectDetailFragment(this);



        ImageView image  = view.findViewById(R.id.image);

        TextView tvDetTitul = view.findViewById(R.id.tvDetTitul);
        TextView tvDescription = view.findViewById(R.id.tvDescription);

        if(item.getEnclosure()==null){

            requestManager.load(Constants.IMAGE).into(image);

        }else{

            requestManager.load(item.getEnclosure().getUrl()).into(image);
        }


        tvDetTitul.setText(item.getTitle());
        tvDescription.setText(item.getFulltext());

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener=(ShowNews) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener.notice();
        listener=null;
    }




    public interface ShowNews{

        void notice();

    }



}
