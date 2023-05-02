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

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {
    private List<credit.task.news.app.TopStories> newsList;
    private Context context;

    public TopStoriesAdapter(List<TopStories> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public TopStoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.topper_stories,parent, false);
        return new TopStoriesViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull TopStoriesViewHolder holder, int position) {
        holder.newsImageView.setImageResource(newsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class TopStoriesViewHolder extends RecyclerView.ViewHolder{
        public ImageView newsImageView;

        public TopStoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.topper_stories_image);
        }
    }
}