public class Main {


    public static void main(String[] args) {


        // CSV読み込み

        CsvReader reader =
                new CsvReader();


        ArticleManager manager =
                new ArticleManager();



        for(Article article :
            reader.readArticles("articles.csv")){


            manager.addArticle(article);

        }

// JSON生成

JsonGenerator jsonGenerator =
        new JsonGenerator();


jsonGenerator.generateJson(
        manager.getArticles()
);

        // HTML生成

        HtmlGenerator generator =
                new HtmlGenerator();



        String newsHtml =
                generator.generateNewsHtml(
                    manager.getArticles()
                );



        String featuredHtml =
                generator.generateFeaturedHtml(
                    manager.getFeaturedArticles()
                );



        // index.html更新

      // index.html更新

HtmlUpdater.updateIndex(
        "index_template.html",
        "index.html",
        newsHtml,
        featuredHtml
    );

        // 記事詳細ページ生成

ArticlePageGenerator pageGenerator =
new ArticlePageGenerator();


for(Article article :
manager.getArticles()){


String articleHtml =
    pageGenerator.generateArticlePage(article);


HtmlUpdater.savePage(
    article.getLink(),
    articleHtml
);

}

// ニュース一覧ページ生成

// ニュース一覧ページ生成（10件ごと）


NewsPageGenerator newsGenerator =
        new NewsPageGenerator();



java.util.ArrayList<Article> allArticles =
        manager.getArticles();



int perPage = 10;


int totalPages =
        (int)Math.ceil(
            (double)allArticles.size()
            / perPage
        );



for(int page = 1; page <= totalPages; page++){


    String newsPage =
            newsGenerator.generateNewsPage(
                    allArticles,
                    page
            );



    String filename;


    if(page == 1){

        filename = "news.html";

    }
    else{

        filename =
            "news" + page + ".html";

    }



    HtmlUpdater.savePage(
            filename,
            newsPage
    );


}

// カテゴリー別ページ生成

CategoryPageGenerator categoryGenerator =
        new CategoryPageGenerator();


// ニュース

HtmlUpdater.savePage(
        "news-category.html",
        categoryGenerator.generateCategoryPage(
                "ニュース",
                manager.getArticlesByCategory("ニュース")
        )
);


// 進学・就職

HtmlUpdater.savePage(
        "career.html",
        categoryGenerator.generateCategoryPage(
                "進学・就職",
                manager.getArticlesByCategory("進学・就職")
        )
);


// 受験

HtmlUpdater.savePage(
        "exam.html",
        categoryGenerator.generateCategoryPage(
                "受験",
                manager.getArticlesByCategory("受験")
        )
);


// インタビュー

HtmlUpdater.savePage(
        "interview.html",
        categoryGenerator.generateCategoryPage(
                "インタビュー",
                manager.getArticlesByCategory("インタビュー")
        )
);


// English

HtmlUpdater.savePage(
        "english.html",
        categoryGenerator.generateCategoryPage(
                "English",
                manager.getArticlesByCategory("English")
        )
);

        System.out.println(
            "HTML生成完了"
        );

    }

}