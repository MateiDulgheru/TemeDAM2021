package com.example.temadam;

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
}
