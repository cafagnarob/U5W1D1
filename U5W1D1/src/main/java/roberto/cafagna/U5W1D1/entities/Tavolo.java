package roberto.cafagna.U5W1D1.entities;

import roberto.cafagna.U5W1D1.Enum.StatoTavolo;

public class Tavolo {
    private final int numCopertiMax;
    private int id;
    private int numTavolo;
    private StatoTavolo statoTavolo;

    public Tavolo(int numTavolo, int numCopertiMax, StatoTavolo statoTavolo) {
        this.numTavolo = numTavolo;
        this.numCopertiMax = numCopertiMax;
        this.statoTavolo = statoTavolo;
    }


    public int getId() {
        return id;
    }

    public int getNumCopertiMax() {
        return numCopertiMax;
    }

    public int getNumTavolo() {
        return numTavolo;
    }

    public void setNumTavolo(int numTavolo) {
        this.numTavolo = numTavolo;
    }

    public StatoTavolo getStatoTavolo() {
        return statoTavolo;
    }

    public void setStatoTavolo(StatoTavolo statoTavolo) {
        this.statoTavolo = statoTavolo;
    }


    @Override
    public String toString() {
        return "Tavolo{ \n" +
                "numCopertiMax=" + numCopertiMax + "\n" +
                ", id=" + id + "\n" +
                ", numTavolo=" + numTavolo + "\n" +
                ", statoTavolo=" + statoTavolo + "\n" +
                '}' + "\n";
    }
}


