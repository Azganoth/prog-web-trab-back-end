package br.unisul.web.progwebtrab.competition;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(Competition competition) {
        competition = competitionService.insert(competition);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(competition.getId()).toUri()
        ).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Competition> findById(@PathVariable Long id) {
        return ResponseEntity.ok(competitionService.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Competition>> findAll() {
        return ResponseEntity.ok(competitionService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateById(
            @RequestBody Competition competition,
            @PathVariable Long id
    ) {
        competitionService.updateById(competition, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        competitionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
