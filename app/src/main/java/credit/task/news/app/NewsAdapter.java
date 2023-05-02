package credit.task.news.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<credit.task.news.app.News> newsList;
    private Context context;
    private OnNewsClickListener listener;

    public NewsAdapter(List<News> newsList, Context context, OnNewsClickListener newsClickListener) {
        this.newsList = newsList;
        this.context = context;
        this.listener = newsClickListener;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_stories,parent, false);
        return new NewsViewHolder(itemView, listener);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.newsImageView.setImageResource(newsList.get(position).getImage());
        holder.newsTopicView.setText(newsList.get(position).getTitle());
        holder.newsBodyViews.setText(newsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView newsImageView;
        public TextView newsTopicView;
        public TextView newsBodyViews;
        OnNewsClickListener onNewsClickListener;
        public NewsViewHolder(@NonNull View itemView, OnNewsClickListener onNewsClickListener) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.top_stories_image);
            newsTopicView = itemView.findViewById(R.id.headlineTextView);
            newsBodyViews = itemView.findViewById(R.id.news_body_textView);
            this.onNewsClickListener = onNewsClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNewsClickListener.onItemClick(getAbsoluteAdapterPosition());
        }
    }
    public interface OnNewsClickListener {
        void onItemClick (int position);
    }

}

