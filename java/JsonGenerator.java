import java.io.FileWriter;
import java.util.ArrayList;


public class JsonGenerator {


    public void generateJson(
            ArrayList<Article> articles
    ){


        try {


            FileWriter writer =
                    new FileWriter("articles.json");



            writer.write("[\n");



            for(int i = 0; i < articles.size(); i++){


                Article article =
                        articles.get(i);



                writer.write("""
{
"id": %d,
"title": "%s",
"category": "%s",
"summary": "%s",
"content": "%s",
"image": "%s",
"date": "%s",
"link": "%s",
"featured": %s
}
"""
.formatted(

        article.getId(),

        article.getTitle(),

        article.getCategory(),

        article.getSummary(),

        article.getContent(),

        article.getImage(),

        article.getDate(),

        article.getLink(),

        article.isFeatured()

));



                if(i < articles.size() - 1){

                    writer.write(",");

                }



                writer.write("\n");


            }



            writer.write("]");



            writer.close();



            System.out.println(
                "articles.json作成完了"
            );


        }
        catch(Exception e){

            e.printStackTrace();

        }


    }


}