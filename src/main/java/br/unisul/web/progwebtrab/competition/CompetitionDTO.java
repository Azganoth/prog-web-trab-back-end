package br.unisul.web.progwebtrab.competition;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CompetitionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private LocalDateTime start;

    public CompetitionDTO(Competition competition) {
        this.id = competition.getId();
        this.name = competition.getName();
        this.description = competition.getDescription();
        this.start = competition.getStart();
    }

    //region Getters, Setters

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

    //endregion

}
