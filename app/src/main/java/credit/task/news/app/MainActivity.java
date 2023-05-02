package credit.task.news.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView newsRecyclerView;
    NewsAdapter newsAdapter;
    List<credit.task.news.app.News> newsList = new ArrayList<>();

    Integer[] imageList = {R.drawable.face, R.drawable.image_a};
    String[] topicList = {"New study shows xx yy", "After 100 days we have.."};
    String[] bodyList = {"After such a long journey, scientists have found...", "100 days ice climbers spent trapped in..."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRecyclerView = findViewById(R.id.news_recycler_view);
        newsAdapter = new NewsAdapter(newsList, MainActivity.this);
        newsRecyclerView.setAdapter(newsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        newsRecyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < topicList.length; i++)
        {
            credit.task.news.app.News news = new credit.task.news.app.News(i, imageList[i], topicList[i],bodyList[i]);
            newsList.add(news);
        }
    }
}