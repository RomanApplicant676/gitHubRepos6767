package io.openweathermap.testing.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Wind {

    Double speed;
    Integer deg;
    Double gust;
}
