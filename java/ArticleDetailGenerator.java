import java.io.FileWriter;
import java.io.IOException;


public class ArticleDetailGenerator {


    public void createArticlePage(Article article){


        String html = """

        <!DOCTYPE html>
        <html lang="ja">

        <head>

        <meta charset="UTF-8">

        <title>%s</title>

        <link rel="stylesheet" href="css/style.css">

        </head>


        <body>


        <header>

            <h1>
                長崎大学新聞社
            </h1>

        </header>



        <main>


            <article class="article-detail">


                <h2>
                    %s
                </h2>


                <p class="date">
                    %s
                </p>


                <img src="%s" alt="%s">


                <p>
                    %s
                </p>


            </article>


        </main>



        <footer>

            <p>
            © 2025 長崎大学新聞社
            </p>

        </footer>


        </body>

        </html>

        """.formatted(

    article.getTitle(),

    article.getTitle(),

    article.getDate(),

    article.getImage(),

    article.getTitle(),

    article.getContent()

);



        save(
            article.getLink(),
            html
        );


    }



    private void save(
            String filename,
            String html
    ){


        try(
            FileWriter writer =
            new FileWriter(filename)
        ){

            writer.write(html);


        }
        catch(IOException e){

            e.printStackTrace();

        }

    }

}