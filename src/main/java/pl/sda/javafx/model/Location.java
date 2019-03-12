package pl.sda.javafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Remigiusz Zudzin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String name;
    private String region;
    private String country;
    private Double lat;
    private Integer lon;
    private String tz_id;
    private Integer localtime_epoch;
    private String localtime;

}
