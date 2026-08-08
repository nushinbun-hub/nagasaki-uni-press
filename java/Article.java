public class Article {

    private int id;
    private String title;
    private String category;
    private String summary;
    private String content;
    private String image;
    private String date;
    private String link;
    private boolean featured;


    // コンストラクタ
    public Article(
            int id,
            String title,
            String category,
            String summary,
            String content,
            String image,
            String date,
            String link,
            boolean featured
    ) {

        this.id = id;
        this.title = title;
        this.summary = summary;
        this.category = category;
        this.content = content; 
        this.image = image;
        this.date = date;
        this.link = link;
        this.featured = featured;

    }


    // getter

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getCategory() {
        return category;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }


    public String getImage() {
        return image;
    }


    public String getDate() {
        return date;
    }


    public String getLink() {
        return link;
    }


    public boolean isFeatured() {
        return featured;
    }

}