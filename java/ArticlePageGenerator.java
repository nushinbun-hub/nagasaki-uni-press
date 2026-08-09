public class ArticlePageGenerator {

    public String generateArticlePage(
            Article article
    ){

        // 本文を段落ごとにHTMLへ変換
        String contentHtml =
                convertContentToHtml(
                    article.getContent()
                );


        return """
        
        ホーム

        <a href="news.html">ニュース</a>

        <div class="dropdown-content">

            <a href="news-category.html">ニュース</a>

            <a href="career.html">進学・就職</a>

            <a href="exam.html">受験</a>

            <a href="interview.html">インタビュー</a>

            <a href="english.html">English</a>

        </div>

        お知らせ

        新聞社について


        %s


        %s


        %s


        %s


        %s


        %s

        """.formatted(

            article.getTitle(),

            article.getTitle(),

            article.getCategory(),

            article.getImage(),

            article.getSummary(),

            contentHtml,

            article.getDate()

        );

    }


    // ==============================
    // 本文をHTMLの段落へ変換
    // ==============================

    private String convertContentToHtml(
            String content
    ){

        StringBuilder html =
                new StringBuilder();


        String[] paragraphs =
                content.split(
                    "\\R\\s*\\R"
                );


        for(String paragraph : paragraphs){

            if(paragraph.trim().isEmpty()){
                continue;
            }


            html.append("<p>\n");

            html.append(
                paragraph.trim()
            );

            html.append("\n</p>\n");

        }


        return html.toString();

    }

}
