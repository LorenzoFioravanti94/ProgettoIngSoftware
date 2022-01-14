package compravendita;

import gestionevini.Botte;
import input_output.EditorODS;
import vino.Vino;
import gestionestanze.Stanza;
import vino.VinoBianco;
import vino.VinoRosso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Cantina {
    private final Stanza[] stanze;
    private static Cantina cantina = null;

    private static int numCatalogo = 0;




    private Cantina(int numStanze) throws Error {
        if (numStanze == 0)
            throw new Error("La cantina deve avere almeno una stanza!");
        stanze = new Stanza[numStanze];
        for (int i=0; i<stanze.length; i++) {
            stanze[i] = new Stanza(i);
        }
    }

    public static Cantina getCantina(int numStanze) {
        if (cantina == null)
            cantina = new Cantina(numStanze);
        return cantina;
    }







    private Vino getVino(String nome) {//dato che questo codice viene riutilizzato si fa un metodo
        for (Stanza stanza : stanze) {
            Vino v = stanza.getVino(nome);
            if (v != null)
                return v;
                    /*
                    FIXME: attenzione! qua si cerca un nome solo in base al suo nome, quindi potrebbero esistere casi
                    FIXME:in cui ci sono due vini con lo stesso nome!! SI aggiungono parametri nella scelta da tastiera?
                     */
        }
        return null;//se non viene trovato
    }

    private Botte getBotte(Vino v) {
        for (Stanza stanza : stanze) {
            Botte b = stanza.getBotte(v);
            if (b != null)
                return b;
        }
        return null;//se non viene trovato
    }

    public Stanza getStanza(Vino v) {// in base al vino cerca in tutte le stanze e le relative mappe, se trova corrispondenza restituisce la stanza
        for (Stanza stanza : stanze) {
            if (stanza.getBotte(v) != null)
                return stanza;
        }
        return null;//FIXME controlla se funziona e aggiungi messaggio
    }

    public Stanza getStanza(int numStanza) {
        return stanze[numStanza];
    }

    public int getNumeroStanze() {
        return stanze.length;
    }

    public void mostraCatalogo() throws IOException {
        ArrayList<String[]> infoVini = new ArrayList<String[]>();//non so a priori quanti sono i vini salvati
        final String[] titoli = new String[] {"Tipo", "Nome", "Provenienza Mosto", "Annata", "Qualifica", "Biologico", "Vitigni", "Prezzo (€/L)"};//titoli da inserire nel documento
        for (Stanza stanzaIes : stanze) {
            String[] infoVino = new String[titoli.length];//ha la lunghezza dei titoli
            for (int j = 0; j < stanzaIes.getHashMapSize(); j++) {
                Vino vinoJes = stanzaIes.getVino(j);

                if (vinoJes != null) {
                    //TIPO VINO
                    if (vinoJes instanceof VinoRosso)
                        infoVino[0] = "Rosso";
                    else if (vinoJes instanceof VinoBianco)
                        infoVino[0] = "Bianco";
                    else
                        infoVino[0] = "Rosato";

                    //NOME
                    infoVino[1] = vinoJes.getNome();
                    //PROVENIENZA
                    infoVino[2] = vinoJes.getSt().getProvenienzaMosto();
                    //ANNATA
                    infoVino[3] = vinoJes.getSt().getAnnata();
                    //QUALIFICA
                    infoVino[4] = vinoJes.getSt().getQualifica();
                    //BIOLOGICO
                    infoVino[5] = vinoJes.getSt().getBio();
                    //VITIGNI
                    infoVino[6] = vinoJes.getSt().getVitigni();
                    //PREZZO
                    infoVino[7] = vinoJes.getSt().getPrezzoL();

                    infoVini.add(infoVino);
                }
                infoVino = new String[titoli.length];
            }
        }
        EditorODS.scriviNuovoODS(infoVini,titoli,"files/Catalogo"+numCatalogo+".ods");
        System.out.println("\nÈ stato mostrato il catalogo n° "+numCatalogo);
        numCatalogo++;
    }


    float calcolaSconto(float prezzo, float quantita) {
        /*if (pIva == null || pIva.isEmpty())
            return 0;//non c'è sconto per i privati

         */
        if (quantita > 10) {//si applica lo sconto solo sopra 10 litri

            //sconto 0.5% al litro
           float scontoPerc = (quantita - 10)*0.5f;//percentuale

            System.out.println("\nSconto del "+scontoPerc+" %");

           float sconto = (prezzo/100)*scontoPerc;
           prezzo -= sconto;
           return prezzo;
        }
        return prezzo;//non viene applicato sconto
        //FIXME prova azienda che compra meno di 10
    }


    public float[] vendi(String nome, int quantita) throws NullPointerException {
        Vino v = getVino(nome);
        if (v == null)
            throw new NullPointerException("\nDeve essere inserito un vino presente nel catalogo!");

        Botte botteV = getBotte(v);
        Stanza stanzaV = getStanza(v);

        float[] acquisto = new float[2];
        float prezzo = Float.parseFloat(v.getSt().getPrezzoL());//FIXME può lanciare nullpointer

        //se lo ha trovato botte e stanza non possono essere nulli, li controllo lo stesso?

        float oldCapacita = botteV.getCapacita();//FIXME può lanciare null pointer
        if (quantita >= botteV.getCapacita()) {
            botteV.setCapacita(0);
            stanzaV.removeVino(v);
            if (quantita > oldCapacita) {//se > si vende quello che c'è
                prezzo *= oldCapacita;
                acquisto[1] = oldCapacita;
                System.out.println("Poiché la quantità di "+nome+" richiesta non è disponibile, ti sono stati venduti "+oldCapacita+" L");
            }
            else {//se quantita e capacita sono uguali
                prezzo *= quantita;
                acquisto[1] = quantita;
                System.out.println("\n Sono stati venduti "+ quantita + " L del vino " + nome);
            }
        }
        else {
            botteV.setCapacita(oldCapacita-quantita);
            prezzo *= quantita;
            acquisto[1] = quantita;
            System.out.println("\n Sono stati venduti "+ quantita + " L del vino " + nome);
        }
        System.out.println("\n La botte n° "+botteV.getIdBotte()+" della stanza "+stanzaV.getNumStanza()+" adesso contiene "+botteV.getCapacita()+" L di vino");
        //FIXME possono lanciare eccezioni

        acquisto[0] = prezzo;//NOTA BENE

        return acquisto;
    }
}





