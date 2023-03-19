package io.weatherBit.testing.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IoWeatherFlow {
        public int count;
        public ArrayList<Datum> data;
}

