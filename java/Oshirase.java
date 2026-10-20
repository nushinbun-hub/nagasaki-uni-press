
public class Oshirase {

    private int id;
    private String title;
    private String date;
    private String url;

    public Oshirase(
            int id,
            String title,
            String date,
            String url
    ) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}


