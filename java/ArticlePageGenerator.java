public class ArticlePageGenerator {


    public String generateArticlePage(Article article){


        return """
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



<section class="article-page">


<h1>%s</h1>


<p class="category %s">
%s
</p>


<img class="article-image"
src="%s"
alt="%s">



<p class="article-summary">

%s

</p>




<div class="article-content">

%s

</div>




<small>

%s

</small>



</section>



</main>





<footer>


<p>&copy; 2025 長崎大学新聞社</p>


</footer>




</body>


</html>
"""
    .formatted(

        article.getTitle(),
    
        article.getTitle(),
    
        article.getCategory(),
    
        article.getCategory(),
    
        article.getImage(),
    
        article.getTitle(),
    
        article.getSummary(),
    
        article.getContent(),
    
        article.getDate()
    
    );


    }

}
