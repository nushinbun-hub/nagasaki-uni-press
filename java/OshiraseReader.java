import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class OshiraseReader {

    public ArrayList<Oshirase> readOshirase(
            String filename
    ) {

        ArrayList<Oshirase> oshiraseList =
                new ArrayList<>();

        try (
            BufferedReader reader =
                    new BufferedReader(
                        new FileReader(filename)
                    )
        ) {

            // ヘッダーを読み飛ばす
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data =
                        line.split(",", -1);

                if (data.length < 4) {
                    continue;
                }

                int id =
                        Integer.parseInt(
                            data[0].trim()
                        );

                String title =
                        data[1].trim();

                String date =
                        data[2].trim();

                String image =
                        data[3].trim();

                Oshirase oshirase =
                        new Oshirase(
                            id,
                            title,
                            date,
                            image
                        );

                oshiraseList.add(oshirase);
            }

        }
        catch (Exception e) {

            System.out.println(
                "お知らせCSV読み込みエラー: "
                + e.getMessage()
            );
        }

        return oshiraseList;
    }
}
