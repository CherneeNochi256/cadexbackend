package ru.maxim.cadexchangetesttaskbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@CrossOrigin("https://cadexfrontend.vercel.app")
public class TriangulationController {

    private final TriangulationService service;

    @GetMapping("/triangulation")
    public List<Triangle> computeTriangulation(@RequestParam Double height,
                                               @RequestParam Double radius,
                                               @RequestParam Integer segments) {
        return service.computeTriangulation(height, radius, segments);
    }
}
