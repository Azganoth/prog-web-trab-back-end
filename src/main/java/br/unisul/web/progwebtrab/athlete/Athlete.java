package br.unisul.web.progwebtrab.athlete;

import br.unisul.web.progwebtrab.competition.Competition;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Athlete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "modality")
    @Column(name = "modality")
    private Set<String> modalities;

    @ManyToMany
    @JoinTable(
            name = "athlete_competition",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "competition_id")
    )
    private List<Competition> competitions = new ArrayList<>();

    protected Athlete() {}

    public Athlete(String name) {
        super();
        this.name = name;
    }

    public Athlete(String name, Set<String> modalities) {
        super();
        this.name = name;
        this.modalities = modalities;
    }

    //region Getters, Setters, Equals, HashCode, ToString

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getModalities() {
        return modalities;
    }

    public void setModalities(Set<String> modalities) {
        this.modalities = modalities;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete)) return false;
        Athlete athlete = (Athlete) o;
        return getId().equals(athlete.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                ", Modalidades: " + modalities +
                ", Competições: [" + competitions.stream()
                        .map(c -> c.getName() + " " + c.getDescription())
                        .collect(Collectors.joining(", ")) +
                ']';
    }

    //endregion

}
