package br.unisul.web.progwebtrab.athlete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(Athlete athlete) {
        athlete = athleteService.insert(athlete);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(athlete.getId()).toUri()
        ).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Athlete> findById(@PathVariable Long id) {
        return ResponseEntity.ok(athleteService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Athlete>> findAll() {
        return ResponseEntity.ok(athleteService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateById(
            @RequestBody Athlete athlete,
            @PathVariable Long id
    ) {
        athleteService.updateById(athlete, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        athleteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
