import java.util.ArrayList;


public class CategoryPageGenerator {


    public String generateCategoryPage(
            String category,
            ArrayList<Article> articles
    ){


        StringBuilder html =
                new StringBuilder();



        html.append("""
<!DOCTYPE html>
<html lang="ja">


<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>%s | 長崎大学新聞社</title>


<link rel="stylesheet" href="css/style.css">

</head>



<body>


<header>


<div class="header-top">

<div class="logo">

<a href="index.html">

<img src="images/logo.png" alt="長崎大学新聞社">

</a>


<p class="since">Since 2025</p>


</div>

</div>



<div class="header-nav">


<nav>

<a href="index.html">ホーム</a>

<div class="dropdown">

    <a href="news.html">ニュース</a>

    <div class="dropdown-content">

        <a href="news-category.html">ニュース</a>

        <a href="career.html">進学・就職</a>

        <a href="exam.html">受験</a>

        <a href="interview.html">インタビュー</a>

        <a href="english.html">English</a>

    </div>

</div>

<a href="oshirase.html">お知らせ</a>

<a href="about.html">新聞社について</a>

</nav>


</div>


</header>



<main>


<section class="latest-news">


<h2>%s</h2>


<div class="news-grid">

"""
        .formatted(
            category,
            category
        ));



        for(Article article : articles){


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