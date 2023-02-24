package com.transportdatamanagementsystem.apiconnector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Component
@Slf4j
public class ApiConnector {
    public String getJSONArray(String query) {

        StringBuilder informationString = null;
        try {
            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("permissions: " + informationString.toString());
        return informationString.toString();
    }

}
