package compravendita;

import java.io.IOException;
import java.util.Scanner;

public class Privato extends Cliente {

    //TODO aggiungi il cognome perchè nelle vendite online lo chiede

    public Privato(String nome, String indirizzo, String CAP) {
        super(nome,indirizzo,CAP);
    }

    @Override
    public float[] compra() throws IOException {
        float[] acquisto = super.compra();

        if (acquisto == null)
            throw new NullPointerException("\n" + this.getNome() + " non può acquistare un vino non presente nel catalogo!");


        System.out.println("\n"+this.getNome()+" ha speso "+acquisto[0]+" €");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nPremere un tasto per continuare");
        sc.nextLine();



        return acquisto;
    }
}
