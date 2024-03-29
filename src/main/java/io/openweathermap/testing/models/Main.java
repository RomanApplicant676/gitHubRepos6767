package io.openweathermap.testing.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Main {
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;
    public int sea_level;
    public int grnd_level;
}
