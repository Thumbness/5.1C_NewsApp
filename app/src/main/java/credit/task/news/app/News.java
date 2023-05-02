package credit.task.news.app;

public class News {
    private String title, body;
    private int id, image;

    public News(int id, int image, String title, String body)
    {
        this.id = id;
        this.image = image;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }
}
