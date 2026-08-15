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
            StringBuilder record =
                    new StringBuilder();

            boolean insideQuotes = false;


            while(
                (line = br.readLine())
                != null
            ){

                // 複数行の記事を1つのCSVレコードとしてまとめる
                if(record.length() > 0){
                    record.append("\n");
                }

                record.append(line);


                // この行まで含めて
                // ダブルクォートの状態を確認
                for(int i = 0; i < line.length(); i++){

                    char c = line.charAt(i);

                    if(c == '"'){

                        // "" はエスケープされたダブルクォート
                        if(
                            insideQuotes &&
                            i + 1 < line.length() &&
                            line.charAt(i + 1) == '"'
                        ){

                            i++;

                        }
                        else{

                            insideQuotes =
                                    !insideQuotes;

                        }

                    }

                }


                // 引用符の外まで来たら
                // 1記事分のCSVレコード完成
                if(!insideQuotes){

                    String recordText =
                            record.toString();

                    if(
                        !recordText.trim().isEmpty()
                    ){

                        String[] data =
                                parseCsvRecord(
                                    recordText
                                );


                        if(data.length < 11){

                            System.out.println(
                                "CSVの列数が不足しています: "
                                + recordText
                            );

                        }
                        else{

                            try{

                                Article article =
        new Article(

            Integer.parseInt(data[0].trim()),

            data[1],

            data[2],

            data[3],

            data[4],

            data[5],

            data[6],

            data[7],

            data[8],

            data[9],

            Boolean.parseBoolean(
                data[10].trim()
            )

        );

                                articles.add(article);

                            }
                            catch(Exception e){

                                System.out.println(
                                    "記事データの読み込みに失敗しました: "
                                    + recordText
                                );

                                e.printStackTrace();

                            }

                        }

                    }

                    // 次の記事へ
                    record.setLength(0);

                }

            }


            // CSVの最後に閉じ忘れた引用符がないか確認
            if(insideQuotes){

                System.out.println(
                    "CSVの引用符が正しく閉じられていません。"
                );

            }

        }
        catch(Exception e){

            e.printStackTrace();

        }


        return articles;

    }



    // ==============================
    // CSVレコードを項目ごとに分解
    // ==============================

    private String[] parseCsvRecord(
            String record
    ){

        ArrayList<String> values =
                new ArrayList<>();

        StringBuilder value =
                new StringBuilder();

        boolean insideQuotes = false;


        for(int i = 0; i < record.length(); i++){

            char c = record.charAt(i);


            if(c == '"'){

                // "" → "
                if(
                    insideQuotes &&
                    i + 1 < record.length() &&
                    record.charAt(i + 1) == '"'
                ){

                    value.append('"');

                    i++;

                }
                else{

                    insideQuotes =
                            !insideQuotes;

                }

            }
            else if(
                c == ',' &&
                !insideQuotes
            ){

                values.add(
                    value.toString()
                );

                value.setLength(0);

            }
            else{

                value.append(c);

            }

        }


        // 最後の項目
        values.add(
            value.toString()
        );


        return values.toArray(
            new String[0]
        );

    }

}