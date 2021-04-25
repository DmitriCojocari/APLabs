package optional.lab8.tool;

import optional.lab8.connection.ConnectionManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImportTool {

    public ImportTool() {
        populateMoviesImdb();
        populateActorsImdb();
        populateDirectorsImdb();
    }

    private void populateMoviesImdb() {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement("Insert into movie_imdb values(?,?,?,?,?)");

            InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/java/optional/lab8/resources/IMDB movies.csv"));
            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(input);
            for (CSVRecord record : csvParser) {
                String idField = record.get("imdb_title_id");
                String titleField = record.get("title");
                String yearField = record.get("year");
                String durationField = record.get("duration");
                String ratingField = record.get("avg_vote");
                pstmt.setString(1, idField);
                pstmt.setString(2, titleField);
                pstmt.setString(3, yearField);
                pstmt.setInt(4, Integer.parseInt(durationField));
                pstmt.setFloat(5, Float.valueOf(ratingField));
                pstmt.executeUpdate();
            }

            System.out.println("Data Added Successfully");

            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateActorsImdb() {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement("Insert into actors values(?,?)");

            InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/java/optional/lab8/resources/IMDB movies.csv"));
            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(input);
            for (CSVRecord record : csvParser) {
                String movieId = record.get("imdb_title_id");
                String actorName = record.get("actors");
                pstmt.setString(1, movieId);
                pstmt.setString(2, actorName);
                pstmt.executeUpdate();
            }

            System.out.println("Data Added Successfully");

            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateDirectorsImdb() {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement("Insert into directors values(?,?)");

            InputStreamReader input = new InputStreamReader(new FileInputStream("src/main/java/optional/lab8/resources/IMDB movies.csv"));
            CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(input);
            for (CSVRecord record : csvParser) {
                String movieId = record.get("imdb_title_id");
                String directorName = record.get("director");
                pstmt.setString(1, movieId);
                pstmt.setString(2, directorName);
                pstmt.executeUpdate();
            }

            System.out.println("Data Added Successfully");

            pstmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
