import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;


public class HtmlUpdater {


    // index_template.htmlを読み込み、index.htmlを生成
    public static void updateIndex(
            String templateFile,
            String outputFile,
            String newsHtml,
            String featuredHtml
    ){

        try {


            File file =
                    new File(templateFile);


            String html =
                    Files.readString(file.toPath());



            html = html.replace(
                "<div class=\"news-grid\" id=\"news-grid\">",
                "<div class=\"news-grid\" id=\"news-grid\">"
                + newsHtml
            );



            html = html.replace(
                "<div class=\"featured-slider\" id=\"featured-slider\">",
                "<div class=\"featured-slider\" id=\"featured-slider\">"
                + featuredHtml
            );



            FileWriter writer =
                    new FileWriter(outputFile);



            writer.write(html);


            writer.close();



            System.out.println(
                outputFile + "更新完了"
            );


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }




    // 記事詳細ページ保存

    public static void saveArticlePage(
            String filename,
            String content
    ){

        try{


            FileWriter writer =
                    new FileWriter(filename);



            writer.write(content);



            writer.close();



            System.out.println(
                filename + " 作成完了"
            );


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }




    // ニュース一覧ページ保存

    public static void saveNewsPage(
            String filename,
            String content
    ){

        try{


            FileWriter writer =
                    new FileWriter(filename);



            writer.write(content);



            writer.close();



            System.out.println(
                filename + " 作成完了"
            );


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }


}