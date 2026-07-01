package roberto.cafagna.U5W1D1.entities;

import roberto.cafagna.U5W1D1.Enum.StatoOrdine;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private int id;
    private int numOrdine;
    private StatoOrdine statoOrdine;
    private int numCoperti;
    private LocalTime orarioOrdine;
    private Tavolo tavolo;
    private List<MenuItem> prodottiOrdine;
    private double costoCoperto;

    public Ordine(int numOrdine, StatoOrdine statoOrdine, int numCoperti
            , Tavolo tavolo, double costoCoperto) {
        this.numOrdine = numOrdine;
        this.statoOrdine = statoOrdine;
        this.numCoperti = numCoperti;
        this.orarioOrdine = LocalTime.now();
        this.tavolo = tavolo;
        this.prodottiOrdine = new ArrayList<>();
        this.costoCoperto = costoCoperto;
    }


    public void addElement(MenuItem item) {
        this.prodottiOrdine.add(item);
    }

    public int getId() {
        return id;
    }

    public int getNumCoperti() {
        return numCoperti;
    }

    public void setNumCoperti(int numCoperti) {
        this.numCoperti = numCoperti;
    }

    public int getNumOrdine() {
        return numOrdine;
    }

    public List<MenuItem> getProdottiOrdine() {
        return prodottiOrdine;
    }

    public void setProdottiOrdine(List<MenuItem> prodottiOrdine) {
        this.prodottiOrdine = prodottiOrdine;
    }

    public LocalTime getOrarioOrdine() {
        return orarioOrdine;
    }

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public double getCostoCoperto() {
        return costoCoperto;
    }

    public double getTotale() {
        double totale = 0;
        for (MenuItem item : prodottiOrdine) {
            totale += item.getPrice();

        }

        totale += numCoperti * costoCoperto;

        return totale;
    }


    @Override
    public String toString() {
        return "Ordine{\n" +
                "id=" + id + "\n" +
                ", numOrdine=" + numOrdine + "\n" +
                ", statoOrdine=" + statoOrdine + "\n" +
                ", numCoperti=" + numCoperti + "\n" +
                ", orarioOrdine=" + orarioOrdine + "\n" +
                ", tavolo=" + tavolo + "\n" +
                ", prodottiOrdine=" + prodottiOrdine + "\n" +
                ", costoCoperto=" + costoCoperto + "\n" +
                ", totale=" + getTotale() + "\n" +
                '}' + "\n";
    }
}
