package ru.maxim.cadexchangetesttaskbackend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TriangulationService {
    public List<Triangle> computeTriangulation(double height, double radius, int segments) {
        List<Triangle> triangulation = new ArrayList<>();

        // Calculate the coordinates of point A
        Triangle.Point pointA = new Triangle.Point(0, 0, height);

        // Calculate the coordinates of each point Pi and Pi+1
        for (int i = 0; i < segments; i++) {
            Triangle.Point pointPi = calculateCoordinates(radius, segments, i);

            // Handle the case when i reaches the last segment
            int nextIndex = (i + 1) % segments;
            Triangle.Point pointPiPlus1 = calculateCoordinates(radius, segments, nextIndex);

            // Create a triangle using points A, Pi, and Pi+1
            Triangle triangle = new Triangle(pointA, pointPi, pointPiPlus1);
            triangulation.add(triangle);
        }

        return triangulation;
    }

    private Triangle.Point calculateCoordinates(double radius, int segments, int nextIndex) {
        double nextAngle = 2 * Math.PI * nextIndex / segments;
        double x = radius * Math.cos(nextAngle);
        double y = radius * Math.sin(nextAngle);
        double z = 0;

        return new Triangle.Point(x, y, z);
    }

}
