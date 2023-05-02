package credit.task.news.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends AppCompatActivity implements NewsAdapter.OnNewsClickListener{
    SharedPreferences sharedPreferences;
    int positionFromSharedPreferences = 0;
    ImageView image;
    TextView topic;
    TextView body;
    RecyclerView relatedNewsRecycler;
    NewsAdapter newsAdapter;
    List<credit.task.news.app.News> newsList = new ArrayList<>();
    Integer[] imageList = {R.drawable.titanic, R.drawable.paris, R.drawable.mansion, R.drawable.nhs, R.drawable.mercury, R.drawable.recession};
    String[] topicList = {"Titanic Sinks", "Paris Lost", "Mansion pays Lodging", "NHS coves cost", "Mercury found", "Recession loses grip"};
    String[] bodyList = {
            "The sinking of the Titanic was one of the deadliest peacetime maritime disasters in history. On April 14, 1912, the ship struck an iceberg and sank, resulting in the deaths of over 1,500 people. The tragedy led to significant improvements in maritime safety regulations.",
            "Paris is the capital and largest city of France, known for its iconic landmarks such as the Eiffel Tower and the Louvre Museum. It is a global center for art, fashion, gastronomy, and culture, and attracts millions of visitors each year. The city is divided into 20 arrondissements and is home to numerous famous landmarks, museums, and parks.",
            "Mansion lodging typically refers to a type of accommodation that is housed in a grand or historic mansion, often with luxurious amenities and personalized services. These types of lodgings are typically high-end and offer a unique and often historic atmosphere. Mansion lodgings can be found in various locations around the world and are popular with travelers seeking a unique and memorable experience. ",
            "The National Health Service (NHS) is the publicly funded healthcare system in the United Kingdom. It was established in 1948 and is one of the largest healthcare systems in the world, providing free medical care to UK residents. The NHS is funded through taxes and provides a range of services, including primary care, hospital care, and community care. The system has been praised for its universal coverage and commitment to providing care regardless of a patient's ability to pay.",
            "Mercury is a chemical element with the symbol Hg and atomic number 80. It is a heavy metal that is liquid at room temperature and is often used in thermometers, barometers, and other scientific instruments. However, it is also highly toxic and exposure to mercury can cause serious health problems, including damage to the nervous system, brain, and kidneys. It is important to handle and dispose of mercury carefully to avoid any harm to human health and the environment.",
            "Recessions, or periods of economic decline, have occurred throughout history. In the past, recessions could last for several years and had severe impacts on people's livelihoods. For example, during the Great Depression of the 1930s, unemployment rates reached as high as 25% in some countries and many people struggled to meet their basic needs. However, over time, governments and central banks have developed policies to help mitigate the impacts of recessions and support economic recovery, such as fiscal stimulus packages and monetary easing. These measures have helped to shorten the duration of recessions and reduce their severity in many cases."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_fragment);
        sharedPreferences = getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);
        positionFromSharedPreferences = sharedPreferences.getInt("Position", 0);

        image = findViewById(R.id.fragment_image);
        topic = findViewById(R.id.fragment_topic);
        body = findViewById(R.id.fragment_body);
        image.setImageResource(imageList[positionFromSharedPreferences]);
        topic.setText(topicList[positionFromSharedPreferences]);
        body.setText(bodyList[positionFromSharedPreferences]);

        relatedNewsRecycler = findViewById(R.id.related_recycler);
        newsAdapter = new NewsAdapter(newsList, NewsFragment.this, this);
        relatedNewsRecycler.setAdapter(newsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        relatedNewsRecycler.setLayoutManager(layoutManager);

        for (int i = 0; i < topicList.length; i++)
        {
            credit.task.news.app.News news = new credit.task.news.app.News(i, imageList[i], topicList[i],bodyList[i]);
            newsList.add(news);
        }



    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Clicked on news story " + position, Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor myEditor = sharedPreferences.edit();
        myEditor.putInt("Position", position);
        myEditor.apply();

        Intent intent = new Intent(NewsFragment.this, NewsFragment.class);
        startActivity(intent);

    }
}
