package br.unisul.web.progwebtrab;

import br.unisul.web.progwebtrab.athlete.Athlete;
import br.unisul.web.progwebtrab.athlete.AthleteRepository;
import br.unisul.web.progwebtrab.competition.Competition;
import br.unisul.web.progwebtrab.competition.CompetitionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class DevConfig {

    private final AthleteRepository athleteRepository;
    private final CompetitionRepository competitionRepository;

    public DevConfig(
            AthleteRepository athleteRepository,
            CompetitionRepository competitionRepository)
    {
        this.athleteRepository = athleteRepository;
        this.competitionRepository = competitionRepository;
    }

    @Bean
    public boolean s() {

        Competition competition1 = new Competition("Maratona", "42km",
                LocalDateTime.of(2019, 8, 11, 14, 15));
        Competition competition2 = new Competition("Jogging", "9km",
                LocalDateTime.of(2019, 8, 12, 14, 15));
        Competition competition3 = new Competition("Esqui", "900m",
                LocalDateTime.of(2019, 8, 13, 16, 15));
        Competition competition4 = new Competition("Natação", "25m",
                LocalDateTime.of(2019, 8, 14, 14, 15));
        Competition competition5 = new Competition("Natação", "50m",
                LocalDateTime.of(2019, 8, 14, 16, 15));

        Athlete athlete1 = new Athlete("James",
                new HashSet<>(Arrays.asList("Corredor", "Nadador")));
        Athlete athlete2 = new Athlete("Jessica",
                new HashSet<>(Arrays.asList("Esquiador", "Corredor")));
        Athlete athlete3 = new Athlete("Rose",
                new HashSet<>(Arrays.asList("Nadador", "Corredor")));
        Athlete athlete4 = new Athlete("Jon",
                new HashSet<>(Arrays.asList("Esquiador", "Nadador", "Corredor")));
        Athlete athlete5 = new Athlete("Ned",
                new HashSet<>(Collections.singletonList("Corredor")));
        Athlete athlete6 = new Athlete("Patricia",
                new HashSet<>(Collections.singletonList("Esquiador")));

        athlete1.getCompetitions().addAll(Arrays.asList(competition1, competition2, competition5));
        athlete2.getCompetitions().addAll(Arrays.asList(competition1, competition3, competition4));
        athlete3.getCompetitions().addAll(Arrays.asList(competition2, competition4));
        athlete4.getCompetitions().addAll(Arrays.asList(competition1, competition3, competition5));
        athlete5.getCompetitions().addAll(Arrays.asList(competition1, competition2));
        athlete6.getCompetitions().add(competition3);
        competition1.getAthletes().addAll(Arrays.asList(athlete1, athlete2, athlete4, athlete5));
        competition2.getAthletes().addAll(Arrays.asList(athlete1, athlete3, athlete5));
        competition3.getAthletes().addAll(Arrays.asList(athlete2, athlete4, athlete6));
        competition4.getAthletes().addAll(Arrays.asList(athlete2, athlete3));
        competition5.getAthletes().addAll(Arrays.asList(athlete1, athlete4));

        competitionRepository.saveAll(Arrays.asList(
                competition1, competition2, competition3, competition4, competition5));
        athleteRepository.saveAll(Arrays.asList(
                athlete1, athlete2, athlete3, athlete4, athlete5, athlete6));

        System.out.println(Stream.of(
                competition1, competition2, competition3, competition4, competition5
        ).map(c -> "Competição: " + c.toString()).collect(Collectors.joining("\n")));
        System.out.println(Stream.of(
                athlete1, athlete2, athlete3, athlete4, athlete5, athlete6
        ).map(a -> "Atleta: " + a.toString()).collect(Collectors.joining("\n")));

        return true;

    }

}
