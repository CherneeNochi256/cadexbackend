package ru.maxim.cadexchangetesttaskbackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangle implements Serializable {
    Point pointA;
    Point pointB;
    Point pointC;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Point implements Serializable {
        double coordinateX;
        double coordinateY;
        double coordinateZ;
    }
}
