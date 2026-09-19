public class AboutPageGenerator {

    public String generateAboutPage() {

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

<title>新聞社について | 長崎大学新聞社</title>

<link rel="stylesheet"
      href="css/style.css">

</head>

<body>

""");

        html.append(headerHtml);

        // ==========================
        // メイン
        // ==========================

        html.append("""
<main>

<section class="about-hero">

    <div class="about-slider">

        <img
            src="images/about1.jpg"
            alt="長崎大学新聞社の活動写真"
            class="about-slide active">

        <img
            src="images/about2.jpg"
            alt="長崎大学新聞社の活動写真"
            class="about-slide">

        <img
            src="images/about3.jpg"
            alt="長崎大学新聞社の活動写真"
            class="about-slide">

        <img
            src="images/about4.jpg"
            alt="長崎大学新聞社の活動写真"
            class="about-slide">

    </div>


    <div class="about-catch">

        <p>考える、長崎大から</p>

    </div>

</section>


<section class="about-page">

<h2>新聞社について</h2>

<div class="about-content">

<h3>長崎大学新聞社とは</h3>

<p>
長崎大学新聞社は、長崎大学の学生によって運営される新聞社です。
</p>

<p>
大学内の出来事や学生生活、研究、進学・就職など、
長崎大学に関するさまざまな情報を取材し、発信しています。
</p>

<h3>活動内容</h3>

<p>
大学内外のニュースの取材や記事の執筆、
インタビュー、写真撮影などを行っています。
</p>

<h3>私たちが目指すこと</h3>

<p>
学生にとって身近で役立つ情報を届けるとともに、
長崎大学で起きているさまざまな出来事を記録し、
学生や地域の皆さまに発信していくことを目指しています。
</p>

</div>

</section>

</main>

<footer>

<p>&copy; 2025 長崎大学新聞社</p>

</footer>

<script src="js/about.js"></script>

</body>

</html>
""");

        return html.toString();
    }
}
