import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class CsvReader {


    public ArrayList<Article> readArticles(
            String filename
    ){


        ArrayList<Article> articles =
                new ArrayList<>();


        try(
            BufferedReader br =
            new BufferedReader(
                new FileReader(filename)
            )
        ){


            // 1行目（見出し）を飛ばす

            br.readLine();


            String line;


            while(
                (line = br.readLine())
                != null
            ){


                String[] data =
                        line.split(",");



                        Article article =
                        new Article(
                    
                            Integer.parseInt(data[0]), // id
                    
                            data[1], // title
                    
                            data[2], // category
                    
                            data[3], // summary
                    
                            data[4], // content
                    
                            data[5], // image
                    
                            data[6], // date
                    
                            data[7], // link
                    
                            Boolean.parseBoolean(data[8]) // featured
                    
                        );


                articles.add(article);


            }


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return articles;


    }

}