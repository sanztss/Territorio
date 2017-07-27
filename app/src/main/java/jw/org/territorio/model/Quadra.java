package jw.org.territorio.model;

/**
 * Created by Des. Android on 27/07/2017.
 */

public class Quadra {
    private int numeroQuadra;
    private int casasQuadra;

    public Quadra() {
    }

    public Quadra(int numeroQuadra, int casasQuadra) {
        this.numeroQuadra = numeroQuadra;
        this.casasQuadra = casasQuadra;
    }

    public int getNumeroQuadra() {
        return numeroQuadra;
    }

    public void setNumeroQuadra(int numeroQuadra) {
        this.numeroQuadra = numeroQuadra;
    }

    public int getCasasQuadra() {
        return casasQuadra;
    }

    public void setCasasQuadra(int casasQuadra) {
        this.casasQuadra = casasQuadra;
    }
}
