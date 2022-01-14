import compravendita.Azienda;
import compravendita.Cantina;
import compravendita.Cliente;
import compravendita.Privato;
import gestionestanze.ControlloreStanza;
import gestionevini.MonitorVino;
import input_output.EditorODS;
import vino.*;

import javax.management.InvalidAttributeValueException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProgettoIngSoftware {
    public static void main(String[] args) throws IOException {
        Cantina c = Cantina.getCantina(4);//4 stanze

        ArrayList<Vino> primaFornitura = new ArrayList<Vino>();//fornitura in cui ci sono errori di duplicazione e alcuni vini non sono arrivati(null)

        File fileP = new File("files/Fornitura1.ods");

        ArrayList<String[]> listaInfoViniP = EditorODS.leggiODS(fileP);

        for (int i=0;i<listaInfoViniP.size();i++) {//size è 8 per forza
            String tipo = listaInfoViniP.get(i)[0];
            String nome = listaInfoViniP.get(i)[1];

            if (tipo.equals("Rosso")) {
                try {
                    primaFornitura.add(new VinoRosso(nome, new SchedaTecnica.SchedaTecnicaBuilder(i,listaInfoViniP).build()));
                } catch (NullPointerException | IllegalArgumentException | InvalidAttributeValueException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (tipo.equals("Bianco")) {
                try {
                    primaFornitura.add(new VinoBianco(nome, new SchedaTecnica.SchedaTecnicaBuilder(i,listaInfoViniP).build()));
                } catch (NullPointerException | IllegalArgumentException | InvalidAttributeValueException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (tipo.equals("Rosato")) {
                try {
                    primaFornitura.add(new VinoRosato(nome, new SchedaTecnica.SchedaTecnicaBuilder(i,listaInfoViniP).build()));
                } catch (NullPointerException | IllegalArgumentException | InvalidAttributeValueException e) {
                    System.out.println(e.getMessage());
                }

            }
        }

        for (int i=0; i<primaFornitura.size(); i++) {
            try {
                int j = i % c.getNumeroStanze();//aritmetica modulare per assegnare in modo equo i vini alle stanze
                c.getStanza(j).addVino(primaFornitura.get(i));
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < c.getNumeroStanze(); i++)
            c.getStanza(i).printHashMap();


        int k = 0;
        while (k < c.getNumeroStanze()) {
            System.out.println("\nGESTIONE STANZA NUMERO "+k);
            c.getStanza(k).addObserver(new ControlloreStanza());
            c.getStanza(k).varia();
            if (c.getStanza(k).getHashMapSize() == 0)
                System.out.println("\nLa stanza numero "+k+" è vuota!!");
            else {
                System.out.println("\nGESTIONE VINI");
                for (int j = 0; j<c.getStanza(k).getHashMapSize(); j++) {//ciclo mappe
                    Vino v = c.getStanza(k).getVino(j);
                    v.addObserver(new MonitorVino());//non abbiamo rierimenti agli observer
                    v.varia();//potresti salvare il risultato in una var booleana
                }
            }
            k++;
        }

        for (int i = 0; i < c.getNumeroStanze(); i++)
            c.getStanza(i).printHashMap();


        ArrayList<Vino> secondaFornitura = new ArrayList<Vino>();

        File fileS = new File("files/Fornitura2.ods");

        ArrayList<String[]> listaInfoViniS = EditorODS.leggiODS(fileS);

        for (int i=0;i<listaInfoViniS.size();i++) {//size è 8 per forza
            String tipo = listaInfoViniS.get(i)[0];
            String nome = listaInfoViniS.get(i)[1];

            if (tipo.equals("Rosso")) {
                try {
                    secondaFornitura.add(new VinoRosso(nome, new SchedaTecnica.SchedaTecnicaBuilder(i,listaInfoViniS).build()));
                } catch (NullPointerException | IllegalArgumentException | InvalidAttributeValueException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (tipo.equals("Bianco")) {
                try {
                    secondaFornitura.add(new VinoBianco(nome, new SchedaTecnica.SchedaTecnicaBuilder(i,listaInfoViniS).build()));
                } catch (NullPointerException | IllegalArgumentException | InvalidAttributeValueException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (tipo.equals("Rosato")) {
                try {
                    secondaFornitura.add(new VinoRosato(nome, new SchedaTecnica.SchedaTecnicaBuilder(i,listaInfoViniS).build()));
                } catch (NullPointerException | IllegalArgumentException | InvalidAttributeValueException e) {
                    System.out.println(e.getMessage());
                }

            }
        }


        for (int i=0; i<secondaFornitura.size(); i++) {
            try {
                k = i % c.getNumeroStanze();//aritmetica modulare per assegnare in modo equo i vini alle stanze
                c.getStanza(k).addVino(secondaFornitura.get(i));
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < c.getNumeroStanze(); i++)
            c.getStanza(i).printHashMap();


        //TODO prima di vendere va fatto un altro giro di gestione



        Cliente[] clienti = new Cliente[4];
        clienti[0] = new Privato("Franco","Via Verdi 13","50135");
        clienti[1] = new Azienda("Ristorante Rosso", "Via Bianchi 1", "50111", "86334519757");
        clienti[2] = new Privato("Claudio", "Via Ferdinando Mori 6", "49122");
        clienti[3] = new Azienda("Albergo La Ginestra", "Via Romolo 11", "50060", "72111146823");

        for (Cliente cliente : clienti) {
            try {
                cliente.compra();//aggiunta nel main eccezione IO
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("\nRitenta l'acquisto");
                cliente.compra();
            }

        }








    }

}
