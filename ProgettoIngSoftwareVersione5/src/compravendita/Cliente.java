package compravendita;

import java.io.IOException;
import java.util.Scanner;

public abstract class Cliente {
    private final String nome;
    private final String indirizzo;
    private final String CAP;


    //TODO riferimento privato al facade?!?(final?)

    public Cliente(String nome, String indirizzo, String CAP) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.CAP = CAP;
    }


    //TODO aggiungere come parametro formale il riferimento al facade?
    //public abstract void compra(String nome, int quantità);
    //astratto perché lo sconto lo applico solo all'azienda

    public float[] compra() throws IOException {
        //i parametri attuali devono stare dentro perché l'input è da tastiera
        Cantina c = Cantina.getCantina(0);
        Scanner scanner = new Scanner(System.in);
        c.mostraCatalogo();
        System.out.println("\nSCEGLI UN VINO DAL CATALOGO");
        System.out.println("Scegli un nome");
        String nome = scanner.nextLine();
        System.out.println("\nIndica la quantità (intera) di litri da acquistare");
        int quantita = scanner.nextInt();




        try {//FIXME non riesce a catturare l'eccezione di vendi!! non so perché, prova a inserire nomi a caso!!!
            float[] acquisto = c.vendi(nome,quantita);
            return acquisto;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        return null;
    }


    /*TODO:
    In tal caso la compravendita avviene dopo due giri, poiché il catalogo dovendo indicare la disponibilità
    deve controllare quali vini delle due forniture sono presenti
     */

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCAP() { return CAP; }
}
