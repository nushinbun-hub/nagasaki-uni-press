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
                    Files.readString(
                            file.toPath()
                    );


            // 共通ヘッダーを生成
            HeaderGenerator headerGenerator =
                    new HeaderGenerator();


            String headerHtml =
                    headerGenerator.generateHeader();


            // テンプレートのヘッダーを
            // 共通ヘッダーに置き換える
            int headerStart =
                    html.indexOf("<header>");


            int headerEnd =
                    html.indexOf("</header>");


            if(
                headerStart != -1
                &&
                headerEnd != -1
            ){

                headerEnd += "</header>".length();


                html =
                    html.substring(
                        0,
                        headerStart
                    )
                    +
                    headerHtml
                    +
                    html.substring(
                        headerEnd
                    );

            }


            // 最新記事を挿入
            html = html.replace(
                "<div class=\"news-grid\" id=\"news-grid\">",
                "<div class=\"news-grid\" id=\"news-grid\">"
                + newsHtml
            );


            // 注目記事を挿入
            html = html.replace(
                "<div class=\"featured-slider\" id=\"featured-slider\">",
                "<div class=\"featured-slider\" id=\"featured-slider\">"
                + featuredHtml
            );


            FileWriter writer =
                    new FileWriter(
                            outputFile
                    );


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



    public static void savePage(
            String filename,
            String content
    ){

        try(
            FileWriter writer =
                    new FileWriter(filename)
        ){

            writer.write(content);


            System.out.println(
                filename + " 作成完了"
            );

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

}