package vino;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;

public class SchedaTecnica {
    private final String provenienzaMosto;
    private final String annata;
    private final String qualifica;
    private final String bio;
    private final String vitigni;
    private final String prezzoL;

    public static class SchedaTecnicaBuilder {
        private final int numeroVino;
        private final ArrayList<String[]> listaInfoVini;

        public SchedaTecnicaBuilder(int numeroVino,ArrayList<String[]> listaInfoVini) throws InvalidAttributeValueException {
            this.listaInfoVini = listaInfoVini;
            if (listaInfoVini == null)
                throw new InvalidAttributeValueException("\nIl File non è stato trovato");
            this.numeroVino = numeroVino;
        }

        String buildProvenienza() {
            return listaInfoVini.get(numeroVino)[2];
        }

        String buildAnnata() {
            return listaInfoVini.get(numeroVino)[3];
        }

        String buildQualifica() {
            return listaInfoVini.get(numeroVino)[4];
        }

        String buildBio() {
            return listaInfoVini.get(numeroVino)[5];
        }

        String buildVitigni() {
            return listaInfoVini.get(numeroVino)[6];
        }

        String buildPrezzoL() {
            return listaInfoVini.get(numeroVino)[7];
        }

        public SchedaTecnica build(){
            return new SchedaTecnica(this);
        }

    }

    private SchedaTecnica (SchedaTecnicaBuilder stb) {
        this.provenienzaMosto = stb.buildProvenienza();
        this.annata = stb.buildAnnata();
        this.qualifica = stb.buildQualifica();
        this.bio = stb.buildBio();
        this.vitigni = stb.buildVitigni();
        this.prezzoL = stb.buildPrezzoL();
    }

    public void printSchedaTecnica() {
        System.out.println("Provenienza Mosto: "+provenienzaMosto);
        System.out.println("Vitigni: "+vitigni);
        System.out.println("Annata: "+annata);
        System.out.println("Qualifica: "+qualifica);
        System.out.println("Bio: "+bio);
        System.out.println("Prezzo al litro: "+prezzoL);
    }


    public String getProvenienzaMosto() {
        return provenienzaMosto;
    }

    public String getAnnata() {
        return annata;
    }

    public String getQualifica() {
        return qualifica;
    }

    public String getBio() {
        return bio;
    }

    public String getVitigni() {
        return vitigni;
    }

    public String getPrezzoL() {
        return prezzoL;
    }
}
