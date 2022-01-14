package gestionevini;

public class Botte {
    private final int idBotte;
    private float capacita;
    //TODO si può aggiungere l'attributo legno per farla meno stupida?

    public Botte(int idBotte) {
        this.idBotte = idBotte;
        this.capacita = 100; //100 litri
    }

    public int getIdBotte() {
        return idBotte;
    }

    public float getCapacita() {
        return capacita;
    }

    public void setCapacita(float quantita) {//TODO controlla bene il setter
        this.capacita = quantita;
    }
}
