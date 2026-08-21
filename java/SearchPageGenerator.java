public class SearchPageGenerator {


    public String generateSearchPage() {


        HeaderGenerator headerGenerator =
                new HeaderGenerator();


        String headerHtml =
                headerGenerator.generateHeader();


        return """
<!DOCTYPE html>
<html lang="ja">


<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>検索結果 | 長崎大学新聞社</title>


<link rel="stylesheet" href="css/style.css">
<script src="js/main.js" defer></script>

</head>


<body>


%s


<main>


<section class="latest-news">


<h2 id="search-title">
検索結果
</h2>


<div
    class="news-grid"
    id="search-results"
>


</div>


</section>


</main>


<footer>

<p>&copy; 2025 長崎大学新聞社</p>

</footer>


</body>


</html>
""".formatted(
            headerHtml
        );

    }

}
