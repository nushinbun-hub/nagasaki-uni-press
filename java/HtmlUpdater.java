
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;

public class HtmlUpdater {

    // Google Analytics 4 の測定タグ
    private static final String GA4_TAG =
            "\n<!-- Google tag (gtag.js) -->\n"
            + "<script async src=\"https://www.googletagmanager.com/gtag/js?id=G-SWJD6EH8YL\"></script>\n"
            + "<script>\n"
            + "  window.dataLayer = window.dataLayer || [];\n"
            + "  function gtag(){dataLayer.push(arguments);}\n"
            + "  gtag('js', new Date());\n"
            + "  gtag('config', 'G-SWJD6EH8YL');\n"
            + "</script>\n";

    // HTMLのhead内にGA4タグを追加
    private static String addGoogleAnalytics(String html) {

        // すでにタグがあれば重複追加しない
        if (html.contains("G-SWJD6EH8YL")) {
            return html;
        }

        int headEnd = html.indexOf("</head>");

        // headが見つからない場合は変更しない
        if (headEnd == -1) {
            System.out.println("警告: </head> が見つかりません。GA4タグを追加できませんでした。");
            return html;
        }

        return html.substring(0, headEnd)
                + GA4_TAG
                + html.substring(headEnd);
    }

    // index_template.htmlを読み込み、index.htmlを生成
    public static void updateIndex(
            String templateFile,
            String outputFile,
            String newsHtml,
            String featuredHtml
    ) {
        try {
            File file = new File(templateFile);

            String html = Files.readString(file.toPath());

            // 共通ヘッダーを生成
            HeaderGenerator headerGenerator = new HeaderGenerator();
            String headerHtml = headerGenerator.generateHeader();

            // テンプレートのヘッダーを共通ヘッダーに置き換える
            int headerStart = html.indexOf("<header>");
            int headerEnd = html.indexOf("</header>");

            if (headerStart != -1 && headerEnd != -1) {
                headerEnd += "</header>".length();

                html = html.substring(0, headerStart)
                        + headerHtml
                        + html.substring(headerEnd);
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

            // GA4タグを追加
            html = addGoogleAnalytics(html);

            FileWriter writer = new FileWriter(outputFile);
            writer.write(html);
            writer.close();

            System.out.println(outputFile + "更新完了");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 各ページのHTMLを保存
    public static void savePage(
            String filename,
            String content
    ) {
        try (
            FileWriter writer = new FileWriter(filename)
        ) {
            // GA4タグを追加
            String html = addGoogleAnalytics(content);

            writer.write(html);

            System.out.println(filename + " 作成完了");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
