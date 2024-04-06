import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Packages.Results;

public class JSONXMLDATAFETCH {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client1 = HttpClient.newHttpClient(); // Create a HTTP Client
        System.out.println("HTTP Client created");
        HttpRequest request1 = HttpRequest.newBuilder() // Build the Request
                .GET() // Specify that it is a GET Request
                .header("accept", "application/json")
                .uri(URI.create("https://itunes.apple.com/search?term=michael+jackson"))
                .build();

        HttpResponse<String> response1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String result = response1.body().substring(36);
        result = result.substring(0, result.length() - 4);

        List<Results> results = mapper.readValue(result, new TypeReference<List<Results>>() {
        });
        for (int i = 0; i < 3; i++) {

            System.out.println("Getting Music Data with JSON:");
            System.out.println("Artist Name: " + results.get(i).getArtistName());
            System.out.println("Album Name: " + results.get(i).getCollectionName());
            System.out.println("Track Name: " + results.get(i).getTrackName());
            System.out.println("Release Date: " + results.get(i).getReleaseDate());
            System.out.println("Track Price: " + results.get(i).getTrackPrice());
            System.out.println("Album Price: " + results.get(i).getCollectionPrice());
        }

        try {
            HttpClient client2 = HttpClient.newHttpClient();
            HttpRequest request2 = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/xml")
                    .uri(URI.create("https://randomuser.me/api/?format=xml"))
                    .build();

            HttpResponse<String> response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());

            String xml = response2.body();

            InputSource inputXML1 = new InputSource(new StringReader(xml));
            InputSource inputXML2 = new InputSource(new StringReader(xml));
            InputSource inputXML3 = new InputSource(new StringReader(xml));
            InputSource inputXML4 = new InputSource(new StringReader(xml));
            InputSource inputXML5 = new InputSource(new StringReader(xml));
            InputSource inputXML6 = new InputSource(new StringReader(xml));
            InputSource inputXML7 = new InputSource(new StringReader(xml));
            InputSource inputXML8 = new InputSource(new StringReader(xml));
            InputSource inputXML9 = new InputSource(new StringReader(xml));
            InputSource inputXML10 = new InputSource(new StringReader(xml));
            InputSource inputXML11 = new InputSource(new StringReader(xml));
            InputSource inputXML12 = new InputSource(new StringReader(xml));

            XPath xPath = XPathFactory.newInstance().newXPath();

            String first = xPath.evaluate("/user/results/name/first", inputXML1);
            String last = xPath.evaluate("/user/results/name/last", inputXML2);
            String title = xPath.evaluate("/user/results/name/title", inputXML3);
            String gender = xPath.evaluate("/user/results/gender", inputXML4);
            String streetNumber = xPath.evaluate("/user/results/location/street/number", inputXML5);
            String streetName = xPath.evaluate("/user/results/location/street/name", inputXML6);
            String city = xPath.evaluate("/user/results/location/city", inputXML7);
            String state = xPath.evaluate("/user/results/location/state", inputXML8);
            String zip = xPath.evaluate("/user/results/location/postcode", inputXML9);
            String email = xPath.evaluate("/user/results/email", inputXML10);
            String phone = xPath.evaluate("/user/results/cell", inputXML11);
            String age = xPath.evaluate("/user/results/dob/age", inputXML12);

            System.out.println();
            System.out.println();
            System.out.println("Getting a user with XML.... ");

            System.out.println("Name: " + title+ " "+ first + " " + last);
            System.out.println("Gender: " + gender);
            System.out.println("Address : "+ streetNumber +" "+ streetName + " ," + city + " ," + state + " ," + zip);
            System.out.println("Email : " + email);
            System.out.println("Phone : " + phone);
            System.out.println("Age :" + age);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (Exception e) {
        }
    }
}
