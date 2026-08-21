import java.util.ArrayList;


public class NewsPageGenerator {


    public String generateNewsPage(
            ArrayList<Article> articles,
            int page
    ){


        StringBuilder html =
                new StringBuilder();


        HeaderGenerator headerGenerator =
                new HeaderGenerator();


        String headerHtml =
                headerGenerator.generateHeader();


        // 1ページの記事数

        int perPage = 10;


        // 新しい順に並び替え

        ArrayList<Article> sortedArticles =
                new ArrayList<>(articles);


        sortedArticles.sort((a, b) -> {

            return b.getDate().compareTo(a.getDate());

        });


        // ページ計算

        int totalPages =
                (int)Math.ceil(
                    (double)sortedArticles.size()
                    / perPage
                );


        int start =
                (page - 1) * perPage;


        int end =
                Math.min(
                    start + perPage,
                    sortedArticles.size()
                );


        html.append("""
<!DOCTYPE html>
<html lang="ja">


<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>ニュース | 長崎大学新聞社</title>


<link rel="stylesheet" href="css/style.css">

</head>


<body>

""");


        // 共通ヘッダー

        html.append(headerHtml);


        html.append("""

<main>


<section class="latest-news">


<h2>ニュース一覧</h2>


<div class="news-grid">

""");


        // 記事表示

        for(int i = start; i < end; i++){


            Article article =
                    sortedArticles.get(i);


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


        html.append("""
</div>


<div class="pagination">

""");


        // ページ番号

        if(page > 1){

            html.append("""
<a href="news%s.html">
&lt; 前へ
</a>

"""
.formatted(
    page == 2 ? "" : page - 1
));

        }


        for(int i = 1; i <= totalPages; i++){


            String filename;


            if(i == 1){

                filename = "news.html";

            }
            else{

                filename =
                    "news" + i + ".html";

            }


            html.append("""

<a href="%s">

%s

</a>


"""
.formatted(
        filename,
        i
));

        }


        if(page < totalPages){


            html.append("""

<a href="news%s.html">

次へ &gt;

</a>


"""
.formatted(
        page + 1
));


        }


        html.append("""
</div>


</section>


</main>


<footer>

<p>&copy; 2025 長崎大学新聞社</p>

</footer>


</body>


</html>

""");


        return html.toString();


    }


    private String createExcerpt(
            String content,
            int maxLength
    ) {

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