package compravendita;

import java.io.IOException;
import java.util.Scanner;

public class Azienda extends Cliente {
    private final String partitaIva;

    public Azienda(String nome, String indirizzo, String CAP, String partitaIva) {
        super(nome,indirizzo,CAP);
        this.partitaIva = partitaIva;
    }

    public float[] compra() throws IOException {
        float[] acquisto = super.compra();

        if (acquisto == null)
            throw new NullPointerException("\n" + this.getNome() + " non può acquistare un vino non presente nel catalogo!");



        Cantina c = Cantina.getCantina(0);//Caclcolo sconto
        float prezzoFinale = c.calcolaSconto(acquisto[0],acquisto[1]);

        System.out.println("\n"+this.getNome()+" ha speso "+prezzoFinale+" € anziché "+acquisto[0]+" € a causa dello sconto");

        acquisto[0] = prezzoFinale;//sovrascrivo col nuovo prezzo


        Scanner sc = new Scanner(System.in);
        System.out.println("\nPremere un tasto per continuare");
        sc.nextLine();


        return acquisto;



    }
}
