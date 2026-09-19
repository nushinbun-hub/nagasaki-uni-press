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
長崎大学新聞部は、長崎大学で学ぶ学生が、大学や社会について考え、発信するための学生団体です。大学生活の中で感じた疑問や違和感、学生の声を出発点に、取材・報道・評論を行っています。
</p>

<p>
これまで、大学内には学生が主体となって継続的に取材や報道を行い、その成果を新聞として発信する場が十分にありませんでした。ニュースや大学に関する情報も、友人同士の会話やSNSなど、限られた範囲で共有されることが少なくありません。
私たちは、そうした状況に風穴を開け、学生が自分たちの目で見て、聞いて、考えたことを共有できる場をつくりたいと考え、新聞部を立ち上げました。
なお、長崎大学で学生が新聞を発行した歴史は私たちが初めてではありません。1950年には、経済学部に進学した山田拓民さんが、許可がなければ新聞すら発行できない状況に抗議するため新聞を発行し、停学処分を受けています。
私たちは、SNS時代における情報発信のありかたを考えながら、現在の大学と社会を見つめています。

</p>

<h3>活動内容</h3>

<p>
主な活動は、長崎大学に関する取材・報道・評論と、新聞の制作・発行です。
大学内で起きている出来事や、学生が疑問に思っていることを取材し、事実を確認したうえで記事にします。完成した記事は紙面にまとめ、学内で配布しています。
記事の制作では、企画、取材、執筆、写真撮影、紙面のレイアウト、ファクトチェック、校正、配布まで、部員がそれぞれの役割を担っています。
また、大学に関する情報であれば、ニュースだけに限りません。学生の活動、ファッションスナップ、文学、漫画、エッセイやイラストなど、学生が発信したいさまざまなテーマも取り上げています。
学生からの寄稿や情報提供も受け付けています。サークルや団体に所属していない個人からの投稿も歓迎しています。
さらに、新聞の発行だけでなく、学生がニュースや社会の出来事について自分で考え、意見を交わす場をつくることも活動の一つです。これまでには、長崎県知事選挙に向けた公開討論会を企画・開催しました。
新聞という媒体にとどまらず、取材やイベントなどを通して、学生同士が社会について考え、対話できる場をつくっていきます。

</p>

<h3>私たちが目指すこと</h3>

<p>
私たちが目指しているのは、正確な情報を届けることと、学生の声を社会につなげることです。
長崎大学新聞には、まだ長い歴史も伝統もありません。大学のサークルである以上、いつまで活動が続くかも分かりません。
それでも、正確な情報を発信し、学生の声を拾い上げ、権力を監視するという新聞の役割は、時代が変わっても必要であり続けるはずです。
長崎大学新聞は、取材・報道・評論を通して、学生と大学、そして学生と社会をつなぐ新たなプラットフォームを目指します。

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
