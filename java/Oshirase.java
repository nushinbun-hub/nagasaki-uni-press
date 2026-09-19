public class Oshirase {

    private int id;
    private String title;
    private String date;
    private String image;

    public Oshirase(
            int id,
            String title,
            String date,
            String image
    ) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.image = image;
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

    public String getImage() {
        return image;
    }
}
