package gestionestanze;
import compravendita.Cantina;
import gestionevini.Botte;
import vino.Vino;

import java.util.LinkedHashMap;
import java.util.Observable;

public class Stanza extends Observable {
    private final int numStanza;//serve nella cantina
    private float temperatura;
    private float umidita;


    private int numBotti = 0;
    private LinkedHashMap<Botte, Vino> botti;


    public Stanza(int numStanza) throws Error {
        if (numStanza < 0)
            throw new Error("\nIl numero della stanza non può essere negativo!");
        this.numStanza = numStanza;
        temperatura = (float)(6 + Math.random() * 10);//LIMITE: tra 6 e 16 gradi
        umidita = (float)(60 + Math.random() * 25);//LIMITE: tra 60 % e 85 %

        botti = new LinkedHashMap<Botte,Vino>();
    }

    public void varia() {//observer PULL perchè se entrambi i parametri cambiano da problemi
        temperatura = (float)(-3 + Math.random() * 28);// -3 e 25
        umidita = (float)(35 + Math.random() * 60);//tra 35 % e 95 %

        printStanza();

        setChanged();
        notifyObservers();
    }

    void correggiTemperatura() {//visibilità package
        System.out.println("\nCorrezione temperatura stanza n° "+numStanza+". Valore temperatura da correggere: "+temperatura);
        temperatura = (float)(6 + Math.random() * 10);
        printStanza();
    }

    void correggiUmidita() {//visibilità package
        System.out.println("\nCorrezione umidità stanza n° "+numStanza+". Valore umidità da correggere: "+ umidita);
        umidita = (float)(60 + Math.random() * 25);
        printStanza();
    }

    void printStanza() {//FIXME fatto package in modo che se viene fatto l'override si può usare nelle derivate a differenza di private(ottica di evoluzione)
        System.out.println("\nTemperatura: "+temperatura+" C°");
        System.out.println("Umidità: "+ umidita +" %");
    }

    public void addVino(Vino v) throws IllegalArgumentException, NullPointerException {
        if (v == null || v.getSt() == null || v.getNome().isEmpty())
            throw new IllegalArgumentException("\nIl vino da inserire non può essere nullo, non avere scheda tecnica oppure avere nome vuoto!");
        if (v.getNome() == null)
            throw new NullPointerException("\nIl vino da inserire non può avere nome nullo!");
        Cantina c = Cantina.getCantina(0);//serve per controllare in tutte le stanze se è già stato inserito
        if (c.getStanza(v) != null)
            //se vine ritornata una stanza vuol dire che quel vino è già presente in una stanza
            throw new IllegalArgumentException("\nLo stesso vino "+v.getNome()+" non può essere inserito due volte!");
        boolean found = false;
        for (Botte key: botti.keySet()) {
            if (botti.get(key) == null && !found) {
                botti.replace(key, v);
                System.out.println("\nNella stanza "+numStanza+", nella botte vuota n°: " + key.getIdBotte() + " è stato inserito il vino " + v.getNome());
                found = true;
            }
        }
        if (!found) {
            botti.put(new Botte(numBotti), v);
            System.out.println("\nIl vino "+v.getNome()+" è stato messo nella stanza "+numStanza+", nella botte n° "+numBotti);
            numBotti++;
        }
    }

    public void removeVino(Vino v) throws IllegalArgumentException {
        if (v == null)
            throw new IllegalArgumentException("/nIl vino da rimuovere non può essere nullo!");
        boolean found = false;
        for (Botte key : botti.keySet()) {
            if (v == botti.get(key)) {
                botti.replace(key,null);
                //System.out.println("\n"+"Il vino "+v.getNome()+" è stato buttato");
                found = true;
            }
        }
        if (!found)
            throw new IllegalArgumentException("\nIl vino "+v.getNome()+" non è presente nella stanza!");
    }

    public Vino getVino(int idBotte) {
        for (Botte key: botti.keySet()) {
            if (idBotte == key.getIdBotte()) {
                Vino v = botti.get(key);
                return v;
            }
        }
        return null;//TODO controlla se funziona!!!
    }






    public Vino getVino(String nome) {
        for (Botte key: botti.keySet()) {
            if (botti.get(key) != null) {//controllo perché sennò getNome() scoppia
                if (nome.equals(botti.get(key).getNome())) {
                    Vino v = botti.get(key);
                    return v;
                }
            }
        }
        return null;//TODO controlla se funziona!!!e anche se i parametri sono sufficienti per la ricerca
    }









    public Botte getBotte(Vino v) {
        for (Botte key : botti.keySet()) {//botti.keySet() restituisce l'insieme delle chiavi
            if (botti.get(key) == v)
                return key;
        }
        return null;//TODO controlla se funziona!!!
    }



    public int getHashMapSize() {
        return botti.size();
    }

    public void printHashMap() {//TODO controlla se funziona!!!
        System.out.println("\n"+"Stanza n° "+numStanza);
        if (botti.isEmpty())
            System.out.println("La stanza non contiene botti!");
        else {
            System.out.println("Elenco botti: ");
            for (Botte key : botti.keySet()) {
                if (botti.get(key) != null)
                    System.out.println("("+key.getIdBotte()+" , "+botti.get(key).getNome()+")");
                else
                    System.out.println("La botte n° "+key.getIdBotte()+" è vuota");
            }
        }
    }

    void resetStanza() {
        numBotti = 0;
        botti = new LinkedHashMap<Botte,Vino>();
    }


    public int getNumStanza() {
        return numStanza;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getUmidita() {
        return umidita;
    }
}
