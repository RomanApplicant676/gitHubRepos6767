package io.openweathermap.testing.models;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherFlow {

    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;

    @Override
    public String toString() {
        return (this.name + ": " + main.getTemp() + " Cealsius: " + Math.round(main.getTemp() - (273.15)));
    }

}

