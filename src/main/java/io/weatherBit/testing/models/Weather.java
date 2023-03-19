package io.weatherBit.testing.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {
    public String description;
    public int code;
    public String icon;
}
