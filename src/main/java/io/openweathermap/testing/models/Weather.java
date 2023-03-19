package io.openweathermap.testing.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {
    public int id;
    public String main;
    public String description;
    public String icon;
}
