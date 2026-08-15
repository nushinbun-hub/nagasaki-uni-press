public class Article {

    private int id;
    private String title;
    private String category;
    private String author;
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
            String author,
            String summary,
            String content,
            String image,
            String date,
            String link,
            boolean featured
    ) {

        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.summary = summary;
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

    public String getAuthor() {
        return author;
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