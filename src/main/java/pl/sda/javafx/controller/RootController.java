package pl.sda.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.sda.javafx.Service.WeatherService;
import pl.sda.javafx.model.Weather;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */
public class RootController implements Initializable {

    private String degresC = (char) 176 + "C";

    @FXML
    private Button search;

    @FXML
    private TextField city;

    @FXML
    private Label temperature;

    @FXML
    private Label country;

    @FXML
    private Label plat;

    @FXML
    private Label plon;

    @FXML
    private Label localTimeCity;

    @FXML
    private Label weatherOverall;

    @FXML
    private Label weatherImage;

    public void initialize(URL location, ResourceBundle resources) {

        city.setText("Podaj nazwę Miasta");
        temperature.setText(degresC);
    }

    public void setCity() throws IOException {
        String url = "http://api.apixu.com/v1/current.json";
        String apiKey = "75ef5138a56b445faf3120447191003";
        WeatherService weatherService = new WeatherService(url, apiKey);
        Weather weather = weatherService.getCityWeather(city.getText());
        temperature.setText(String.valueOf(weather.getCurrent().getTemp_c()));
        country.setText(weather.getLocation().getCountry());
        plat.setText(String.valueOf(weather.getLocation().getLat()));
        plon.setText(String.valueOf(weather.getLocation().getLon()));
        localTimeCity.setText(weather.getLocation().getLocaltime());
        weatherOverall.setText(weather.getCurrent().getCondition().getText());
    }
}
