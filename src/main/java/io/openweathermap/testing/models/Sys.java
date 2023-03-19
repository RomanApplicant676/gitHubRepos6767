package io.openweathermap.testing.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sys {

    Integer type;
    Integer id;
    String country;
    Long sunrise;
    Long sunset;

}
