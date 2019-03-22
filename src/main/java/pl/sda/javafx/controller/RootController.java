package pl.sda.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import pl.sda.javafx.Service.WeatherService;
import pl.sda.javafx.model.Weather;
import javafx.scene.image.ImageView;
import java.io.File;
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
    private ImageView imageView;

    @FXML
    private Label cityName;

    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("https://www.zpm.portkolobrzeg.pl/grafika,6421,-.jpg");
        imageView.setImage(image);
    }

    public void setCity() throws IOException {
        String url = "http://api.apixu.com/v1/current.json";
        String apiKey = "75ef5138a56b445faf3120447191003";
        WeatherService weatherService = new WeatherService(url, apiKey);
        Weather weather = weatherService.getCityWeather(city.getText().replace(" ", "_")
                        .replace("ą", "a")
                        .replace("Ą", "A")
                        .replace("ć", "c")
                        .replace("Ć", "C")
                        .replace("ń", "n")
                        .replace("Ń", "N")
                        .replace("Ż", "Z")
                        .replace("Ź", "Z")
                        .replace("ż", "z")
                        .replace("ź", "z")
                        .replace("ś", "s")
                        .replace("Ś", "S")
                        .replace("Ł", "L")
                        .replace("ł", "l")
                        .replace("ę", "e")
                        .replace("Ę", "E")
                        .replace("Ó", "O")
                        .replace("ó", "o"));
        cityName.setText(weather.getLocation().getName());
        temperature.setText(String.valueOf(weather.getCurrent().getTemp_c()));
        country.setText(weather.getLocation().getCountry());
        plat.setText(String.valueOf(weather.getLocation().getLat()));
        plon.setText(String.valueOf(weather.getLocation().getLon()));
        localTimeCity.setText(weather.getLocation().getLocaltime());
        weatherOverall.setText(weather.getCurrent().getCondition().getText());
        
        String getImageURL = "http:"+weather.getCurrent().getCondition().getIcon();
        Image image = new Image(getImageURL);
        imageView.setImage(image);
    }
}
