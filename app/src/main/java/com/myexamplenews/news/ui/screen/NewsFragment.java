package com.myexamplenews.news.ui.screen;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.myexamplenews.news.R;
import com.myexamplenews.news.di.app.App;
import com.myexamplenews.news.model.pojo.Enclosure;
import com.myexamplenews.news.model.pojo.Item;
import com.myexamplenews.news.presenter.NewsPresenter;
import com.myexamplenews.news.presenter.NewsView;
import com.myexamplenews.news.ui.general.SwipeManager;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Максим on 14.03.2018.
 */

public class NewsFragment extends Fragment implements NewsView,NewsAdapter.NewsClickListener {


    @Inject
    NewsPresenter presenter;

    private RecyclerView rvNews;

    private TransmitterData listener;
    private ProgressBar progressBar;

    private SwipeRefreshLayout newsSwipeRefresh;
    private SwipeManager swipeManager;

    public NewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     initComponents(view);
        createItemTouch();
    }




    private void initNews(){
        presenter.attach(this);
    }


    private void initComponents(View view){

        App.getAppComponent().injectNewsFragment(this);

        initNews();

        progressBar=(ProgressBar) view.findViewById(R.id.progressBar);

        newsSwipeRefresh=(SwipeRefreshLayout)view.findViewById(R.id.newsSwipeRefresh);
        newsSwipeRefresh.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);
        swipeManager=new SwipeManager(newsSwipeRefresh,progressBar,this::initNews);
        newsSwipeRefresh.setOnRefreshListener(swipeManager);
        newsSwipeRefresh.setRefreshing(false);


        rvNews=(RecyclerView)view.findViewById(R.id.rvNews);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNews.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

    }



    @Override
    public void showNews(List<Item> results) {
        rvNews.setAdapter(new NewsAdapter(results,this));
        progressBar.setVisibility(View.INVISIBLE);
    }



    @Override
    public void showErrorLoadingNews() {

        List<Item> results2=new ArrayList<>();

        results2.add(new Item("пкцп","ывацу", new Enclosure(" укцк"),"ывацу"));


        rvNews.setAdapter(new NewsAdapter(results2,this));

                 showMessage(getContext().getString(R.string.error));
        progressBar.setVisibility(View.INVISIBLE);

    }


    private void  showMessage(String message){

        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(TransmitterData) context;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter.detach();

    }


    @Override
    public void onDetach() {
        super.onDetach();

        listener=null;
    }

    @Override
    public void onNewsClick(Item item) {

        listener.transferData(item);

    }


    private void createItemTouch(){
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvNews);
    }

    private ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            NewsAdapter adapter = (NewsAdapter)rvNews.getAdapter();
            adapter.adOnMove(fromPosition,toPosition);
            return true;
        }
        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            NewsAdapter adapter = (NewsAdapter)rvNews.getAdapter();
            adapter.adOnSwiped(viewHolder);
        }
    };

}
