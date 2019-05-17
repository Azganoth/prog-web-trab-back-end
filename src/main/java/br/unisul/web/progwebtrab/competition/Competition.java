package br.unisul.web.progwebtrab.competition;

import br.unisul.web.progwebtrab.athlete.Athlete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Competition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime start;

    @ManyToMany(mappedBy = "competitions")
    private List<Athlete> athletes = new ArrayList<>();

    protected Competition() {}

    public Competition(String name, String description, LocalDateTime start) {
        super();
        this.name = name;
        this.description = description;
        this.start = start;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Competition)) return false;
        Competition that = (Competition) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                ", Descrição: " + description +
                ", Data: " + start +
                ", Atletas: [" + athletes.stream().map(Athlete::getName)
                        .collect(Collectors.joining(", ")) +
                ']';
    }

    //endregion

}
