package gestionevini;

import compravendita.Cantina;
import vino.Vino;

class StrategiaGenerale implements StrategiaVino {//visibilità package
    private final Cantina cantina;

    StrategiaGenerale() {//package non è possibile quindi protected anche in ottica di dervazioni di classi future
        cantina = Cantina.getCantina(0);//si passa un numero a caso
    }//omesso il lv di visibilità perché package

    @Override
    public void gestisciVino(Vino v) {
        try {
            cantina.getStanza(v).removeVino(v);

            System.out.println("\n"+"Il vino "+v.getNome()+" è stato buttato");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
