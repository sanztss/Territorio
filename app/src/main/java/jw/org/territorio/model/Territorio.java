package jw.org.territorio.model;


import android.os.Parcel;

import java.util.List;

/**
 * Created by Des. Android on 26/07/2017.
 */

public class Territorio {
    private String numeroTerritorio;
    private Theme tematerritorio;
    private List<Quadra> quadrasTerritorio;

    public Territorio() {
    }

    public Territorio(String numeroTerritorio, Theme tematerritorio, List<Quadra> quadrasTerritorio) {
        this.numeroTerritorio = numeroTerritorio;
        this.tematerritorio = tematerritorio;
        this.quadrasTerritorio = quadrasTerritorio;
    }

    public String getNumeroTerritorio() {
        return numeroTerritorio;
    }

    public void setNumeroTerritorio(String numeroTerritorio) {
        this.numeroTerritorio = numeroTerritorio;
    }

    public Theme getTematerritorio() {
        return tematerritorio;
    }

    public void setTematerritorio(Theme tematerritorio) {
        this.tematerritorio = tematerritorio;
    }

    public List<Quadra> getQuadrasTerritorio() {
        return quadrasTerritorio;
    }

    public void setQuadrasTerritorio(List<Quadra> quadrasTerritorio) {
        this.quadrasTerritorio = quadrasTerritorio;
    }
}
