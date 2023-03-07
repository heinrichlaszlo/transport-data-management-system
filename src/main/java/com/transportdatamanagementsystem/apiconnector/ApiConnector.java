package com.transportdatamanagementsystem.apiconnector;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Component
@Slf4j
public class ApiConnector {
    public JSONObject getPermissions(String query) {
log.info(query);
        StringBuilder informationString = null;
        JSONObject dataObject = null;
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

                JSONParser parse = new JSONParser();
                dataObject = (JSONObject) parse.parse(String.valueOf(informationString));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataObject;
    }

}
