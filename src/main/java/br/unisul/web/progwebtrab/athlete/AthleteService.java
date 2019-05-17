package br.unisul.web.progwebtrab.athlete;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Athlete insert(Athlete athlete) {
        athlete.setId(null);
        return athleteRepository.save(athlete);
    }

    public Athlete findById(Long id) {
        return athleteRepository.findById(id).orElse(null);
    }

    public List<Athlete> findAll() {
        return athleteRepository.findAll();
    }

    public Athlete updateById(Athlete athlete, Long id) {
        if (!athleteRepository.existsById(id)) return null;
        athlete.setId(id);
        return athleteRepository.save(athlete);
    }

    public void deleteById(Long id) {
        athleteRepository.deleteById(id);
    }

}
