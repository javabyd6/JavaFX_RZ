package pl.sda.javafx.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.javafx.model.Weather;

import java.io.IOException;
import java.net.URL;

/**
 * @author Remigiusz Zudzin
 */
@Data
@NoArgsConstructor
public class WeatherService {

    private String finalURLAddress;

    public WeatherService(String URLaddress, String apiKey) {
        finalURLAddress = URLaddress + "?key=" + apiKey + "&q=";
    }

    public Weather getCityWeather(String location) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
            URL url = new URL(finalURLAddress + location);
            return mapper.readValue(url, Weather.class);
    }

}
