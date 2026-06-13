package com.jobportal.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class EmailService {

	@Value("${BREVO_API_KEY}")
	private String API_KEY;
    private final String FROM_EMAIL = "sawangautam7825@gmail.com";
    private final String FROM_NAME = "Rozgaar Mittar";

    public void sendEmail(String to, String subject, String body) {
        try {
            String jsonBody = "{"
                + "\"sender\":{\"name\":\"" + FROM_NAME + "\",\"email\":\"" + FROM_EMAIL + "\"},"
                + "\"to\":[{\"email\":\"" + to + "\"}],"
                + "\"subject\":\"" + subject + "\","
                + "\"htmlContent\":\"" + body.replace("\"", "\\\"") + "\""
                + "}";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.brevo.com/v3/smtp/email"))
                .header("Content-Type", "application/json")
                .header("api-key", API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Email sent! Status: " + response.statusCode());
            System.out.println("Response: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }
}