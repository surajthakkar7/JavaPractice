import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.Statement;

import packages.Results;

public class jdbc {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client1 = HttpClient.newHttpClient();
        HttpRequest request1 = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("https://itunes.apple.com/search?term=michael+jackson"))
                .build();

        HttpResponse<String> response1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String result = response1.body().substring(36);
        result = result.substring(0, result.length() - 4);

        List<Results> results = mapper.readValue(result, new TypeReference<List<Results>>() {
        });

        System.out.println("data of a random user..");

        try {
            String DB_URL = "jdbc:mysql://localhost/my_database";
            String USER = "root";
            String PASS = "SurajThakkar@7";

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            for (int i = 0; i < results.size(); i++) {

                String sql = "INSERT INTO random_users (name, cname) VALUES (?, ?)";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, results.get(i).getArtistName());
                preparedStatement.setString(2, results.get(i).getCollectionName());

                preparedStatement.executeUpdate();

            }

            String query1 = "SELECT name,cname FROM random_users";
            java.sql.Statement start1 = conn.createStatement();
            ResultSet rs1 = start1.executeQuery(query1);

            while (rs1.next()) {
                System.out.println("name:" + rs1.getString("name"));
                System.out.println("cname:" + rs1.getString("cname"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
