package com.example.temadam;

import java.util.Objects;

public class Antrenament {

    private String denumire;
    private Integer durata;
    private String echipament;

    public Antrenament() {
    }

    public Antrenament(String denumire, Integer durata, String echipament) {
        this.denumire = denumire;
        this.durata = durata;
        this.echipament = echipament;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public String getEchipament() {
        return echipament;
    }

    public void setEchipament(String echipament) {
        this.echipament = echipament;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Antrenament{");
        sb.append("denumire='").append(denumire).append('\'');
        sb.append(", durata=").append(durata);
        sb.append(", echipament='").append(echipament).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Antrenament that = (Antrenament) o;
        return Objects.equals(denumire, that.denumire) && Objects.equals(durata, that.durata) && Objects.equals(echipament, that.echipament);
    }


}
