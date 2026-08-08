import java.util.ArrayList;
import java.util.Comparator;


public class ArticleManager {


    // 記事を保存するリスト

    private ArrayList<Article> articles;



    // コンストラクタ

    public ArticleManager(){

        articles = new ArrayList<>();

    }



    // 記事追加

    public void addArticle(Article article){

        articles.add(article);

    }



    // 全記事取得（新しい順）

    public ArrayList<Article> getArticles(){

        articles.sort(
            Comparator.comparing(Article::getDate)
            .reversed()
        );


        return articles;

    }



    // 注目記事だけ取得

    public ArrayList<Article> getFeaturedArticles(){

        ArrayList<Article> featured =
                new ArrayList<>();


        for(Article article : articles){

            if(article.isFeatured()){

                featured.add(article);

            }

        }


        return featured;

    }



    // カテゴリー別記事取得

    public ArrayList<Article> getArticlesByCategory(
            String category
    ){

        ArrayList<Article> result =
                new ArrayList<>();


        for(Article article : articles){

            if(article.getCategory().equals(category)){

                result.add(article);

            }

        }


        // カテゴリー内も新しい順

        result.sort(
            Comparator.comparing(Article::getDate)
            .reversed()
        );


        return result;

    }


}