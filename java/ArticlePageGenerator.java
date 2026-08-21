public class ArticlePageGenerator {

    public String generateArticlePage(Article article) {

        HeaderGenerator headerGenerator =
                new HeaderGenerator();

        String headerHtml =
                headerGenerator.generateHeader();

        String contentHtml =
                convertContentToHtml(
                        article.getContent()
                );
    
            return """
    <!DOCTYPE html>
    <html lang="ja">
    
    <head>
    
    <meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>%s | 長崎大学新聞社</title>
    
    <link rel="stylesheet" href="css/style.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+JP:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    </head>
    
    <body>
    
    %s
    
    <main>
    
    <div class="article-layout">
    
        <!-- 左：記事本文 -->
    
        <section class="article-page">
    
            <p class="category %s">
                %s
            </p>
    
            <h1>%s</h1>
    
            <p class="article-date">
                %s
            </p>
    
            <p class="article-author">
                執筆者：%s
            </p>
    
            <div class="share-buttons">
    
                <a
                href="https://twitter.com/intent/tweet?text=%s&url=https://nushinbun-hub.github.io/nagasaki-uni-press/%s"
                target="_blank"
                class="share-button">
    
                🐦
    
                </a>
    
                <a
                href="https://social-plugins.line.me/lineit/share?url=https://nushinbun-hub.github.io/nagasaki-uni-press/%s"
                target="_blank"
                class="share-button">
    
                💬
    
                </a>
    
                <a
                href="mailto:?subject=%s&body=https://nushinbun-hub.github.io/nagasaki-uni-press/%s"
                class="share-button">
    
                ✉
    
                </a>
    
            </div>
    
            <figure>
    
                <img class="article-image"
                src="%s"
                alt="%s">
    
                <figcaption class="article-caption">
    %s
</figcaption>
    
            </figure>
    
            <div class="article-content">
    
                %s
    
            </div>
    
            <br><br>
    
            <a href="news.html">
                ← 記事一覧へ戻る
            </a>
    
        </section>
    
    
        <!-- 右側は将来用のスペース -->
    
        <aside class="article-sidebar">
        </aside>
    
    </div>
    
    </main>
    
    <footer>
    
    <p>&copy; 2025 長崎大学新聞社</p>
    
    </footer>
    
    </body>
    
    </html>
    """.formatted(

    article.getTitle(),

    headerHtml,

    article.getCategory(),

    article.getCategory(),

    article.getTitle(),

    article.getDate(),

    article.getAuthor(),

    article.getTitle(),

    article.getLink(),

    article.getLink(),

    article.getTitle(),

    article.getLink(),

    article.getImage(),

    article.getTitle(),

    article.getCaption(),

    contentHtml

);
    
        }
    
    
        private String convertContentToHtml(
                String content
        ) {
        
            if (content == null || content.isEmpty()) {
                return "";
            }
        
            StringBuilder html =
                    new StringBuilder();
        
            String[] paragraphs =
                    content.split("\\\\n\\\\n");
        
            for (String paragraph : paragraphs) {
        
                if (paragraph.trim().isEmpty()) {
                    continue;
                }
        
                String text =
                        paragraph
                                .replace("\\n", "<br>\n")
                                .trim();
        
                html.append("<p>\n");
        
                html.append(text);
        
                html.append("\n</p>\n");
        
            }
        
            return html.toString();
        
        }
    
    }
