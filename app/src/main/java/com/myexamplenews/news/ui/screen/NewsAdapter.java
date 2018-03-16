package com.myexamplenews.news.ui.screen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.myexamplenews.news.R;
import com.myexamplenews.news.model.pojo.Item;
import java.util.Collections;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>  {

    private List<Item> list;

    private final NewsClickListener listener;

    public NewsAdapter(List<Item> list, NewsClickListener listener) {
        this.list = list;
        this.listener=listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.item_news,parent,false);

        return  new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       Item item = list.get(position);

        holder.bindTo(item);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public void adOnMove(int fromPos,int toPos) {

        Collections.swap( list,fromPos,toPos);
        notifyItemMoved(fromPos, toPos);
    }

    public void adOnSwiped(RecyclerView.ViewHolder viewHolder) {
        int swipedPosition = viewHolder.getAdapterPosition();
        list.remove(swipedPosition);

        notifyItemRemoved(swipedPosition);
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvTitul;
        private final TextView tvDate;

        private  Item item;

        public ViewHolder(View itemView, final NewsClickListener listener){
            super(itemView);

            tvTitul =(TextView)itemView.findViewById(R.id.tvTitul);
            tvDate =(TextView)itemView.findViewById(R.id.tvDate);


            itemView.setOnClickListener(this::launchDescription);

        }

        private void launchDescription(View view){

            listener.onNewsClick(item);

        }


        public void bindTo(Item item) {
            this.item = item;

            tvTitul.setText(item.getTitle());
            tvDate.setText(item.getPubDate());

        }
    }

    interface NewsClickListener {

        void onNewsClick(Item item);

    }
}
