import java.util.ArrayList;

public class OshirasePageGenerator {

    public String generateOshirasePage(
            ArrayList<Oshirase> oshiraseList
    ) {

        StringBuilder html =
                new StringBuilder();

        HeaderGenerator headerGenerator =
                new HeaderGenerator();

        String headerHtml =
                headerGenerator.generateHeader();

        html.append("""
<!DOCTYPE html>
<html lang="ja">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>お知らせ | 長崎大学新聞社</title>

<link rel="stylesheet"
      href="css/style.css">

</head>

<body>

""");

        html.append(headerHtml);

        html.append("""
<main>

<section class="oshirase-page">

<h2>お知らせ</h2>

<div class="oshirase-list">

""");

        for (Oshirase oshirase : oshiraseList) {

            html.append("""
<article class="oshirase-item">

<img src="%s" alt="%s">

<div class="oshirase-content">

<small>%s</small>

<h3>%s</h3>

</div>

</article>

"""
            .formatted(
                oshirase.getImage(),
                oshirase.getTitle(),
                oshirase.getDate(),
                oshirase.getTitle()
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
}
