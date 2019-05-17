package br.unisul.web.progwebtrab.competition;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public Competition insert(Competition competition) {
        competition.setId(null);
        return competitionRepository.save(competition);
    }

    public Competition findById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    public Competition updateById(Competition competition, Long id) {
        if (!competitionRepository.existsById(id)) return null;
        competition.setId(id);
        return competitionRepository.save(competition);
    }

    public void deleteById(Long id) {
        competitionRepository.deleteById(id);
    }

}
