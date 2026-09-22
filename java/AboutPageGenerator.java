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

<p>
長崎大学新聞部は、大学生活や社会問題について学生視線から情報発信することを目的に2025年4月に発足した学生団体です。
</p>

<p>
全国の主要大学には新聞を発行する団体がありますが、長崎大学には学生による報道媒体がありませんでした。社会の動向や大学に関する情報は、友人同士の会話やSNSなど、限られた範囲でしか共有されていませんでした。そこで、学生目線で取材した確かな情報を、学生読者が共有し議論の場をつくろうと、新聞部を立ち上げました。 長崎大学で学生新聞を刊行した歴史はこれが初めてではありません。長崎原爆被災者協議会（被災協）の事務局長を務めた故・山田拓民さんが長崎大学入学後の1950年に、連合国軍総司令部（ＧＨＱ）の言論統制下で新聞発行にも届け出が必要な状況に対し、「言論の自由」を主張し新聞を発行しました。山田さんは停学処分を受け、新聞も廃刊を余儀なくされました。それから90年以上の歳月を経て、メディアの姿は大きく変わりました。新しい長崎大学新聞も、紙面を通じてデジタル時代における情報の発信と学生読者とのかかわりを意識しながら、大学と社会を見つめています。

</p>

<h2>活動内容</h2>

<p>
長崎大学新聞は、正確な情報を届けることと、学生同士の議論を促し社会へ関心をつなぐことです。主な活動は、長崎大学に関する報道・論説を掲載した新聞の編集・発行です。 大学内で起きている出来事や、社会情勢に関連し学生が疑問に思っていることを取材し、事実基づく記事を紙面に編集し、紙の媒体で学内に配布しています。

</p>

<figure class="about-photo">

    <img
        src="images/about-activity1.jpg"
        alt="長崎大学新聞社の活動写真">

    <figcaption class="article-caption">
        2026年長崎県知事選挙を前に、候補者を招き討論会を開催。およそ100名が参加した。＝12月19日
    </figcaption>

</figure>

<p>
新聞の編集では、企画、取材、写真撮影、紙面のレイアウト、ファクトチェック、校正、配布まで、部員がそれぞれの役割を担っています。大学に関する情報であれば、キャンパス内の出来事だけに限りません。学生の活動、ファッションスナップ、文学、漫画、エッセイやイラストなど、さまざまなテーマも取り上げています。 学生からの寄稿や情報提供も受け付けています。サークルや団体に所属していない個人からの投稿も歓迎しています。 さらに、新聞の発行だけでなく、学生が大学や社会の出来事について考え、意見を交わす場をつくることも活動の一つです。これまでには、長崎県知事選挙に向けた公開討論会を企画・開催しました。 新聞という媒体にとどまらず、取材やイベントなどを通して、学生同士が社会について考え、対話できる場をつくっていきます。
</p>

<h2>私たちが目指すこと</h2>

<p>
長崎大学新聞は創刊して日の浅い媒体です。大学のサークルである以上、活動の継続性などさまざま制約があります。しかし、権力を監視するという新聞の役割は、時代が変わっても、紙からデジタルに媒体が変わっても必要であり続けるはずです。 長崎大学新聞は、学生同士、そして学生と社会をつなぐ新たな報道と言論のプラットフォームを目指します。
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
