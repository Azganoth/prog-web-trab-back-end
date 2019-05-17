package br.unisul.web.progwebtrab.athlete;

import java.io.Serializable;
import java.util.Set;

public class AthleteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Set<String> modalities;

    public AthleteDTO(Athlete athlete) {
        this.id = athlete.getId();
        this.name = athlete.getName();
        this.modalities = athlete.getModalities();
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

    public Set<String> getModalities() {
        return modalities;
    }

    public void setModalities(Set<String> modalities) {
        this.modalities = modalities;
    }

    //endregion

}
