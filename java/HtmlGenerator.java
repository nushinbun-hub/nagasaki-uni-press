import java.util.ArrayList;


public class HtmlGenerator {


    // ==============================
    // ホーム最新記事（6件）
    // ==============================

    public String generateNewsHtml(
            ArrayList<Article> articles
    ){


        StringBuilder html =
                new StringBuilder();



        // 新しい順に並び替え

        ArrayList<Article> sortedArticles =
                new ArrayList<>(articles);



        sortedArticles.sort((a, b) -> {

            return b.getDate().compareTo(a.getDate());

        });



        int count = 0;



        for(Article article : sortedArticles){


            if(count >= 6){

                break;

            }


            count++;



            html.append("""

<article class="news-item">


<img src="%s" alt="%s">


<div class="news-content">


<p class="category %s">

%s

</p>


<h3>%s</h3>


<p>%s</p>


<small>%s</small>


<br><br>


<a href="%s">

続きを読む →

</a>


</div>


</article>


"""
.formatted(

        article.getImage(),

        article.getTitle(),

        article.getCategory(),

        article.getCategory(),

        article.getTitle(),

        createExcerpt(article.getContent(), 100),

        article.getDate(),

        article.getLink()

));

        }



        return html.toString();


    }





    // ==============================
    // 注目記事スライダー
    // ==============================

    public String generateFeaturedHtml(
            ArrayList<Article> articles
    ){


        StringBuilder html =
                new StringBuilder();



        for(Article article : articles){



            html.append("""

<a href="%s">


<img src="%s" alt="%s">


</a>


"""
.formatted(

        article.getLink(),

        article.getImage(),

        article.getTitle()

));

        }



        return html.toString();


}


private String createExcerpt(String content, int maxLength) {

    if (content == null || content.isEmpty()) {
        return "";
    }

    String text = content
            .replaceAll("\\s+", " ")
            .trim();

    if (text.length() <= maxLength) {
        return text;
    }

    return text.substring(0, maxLength) + "…";

}


}