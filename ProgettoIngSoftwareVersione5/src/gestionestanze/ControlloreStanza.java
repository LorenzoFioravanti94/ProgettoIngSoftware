package gestionestanze;

import java.util.Observable;
import java.util.Observer;

public class ControlloreStanza implements Observer {
    private StrategiaStanza strategy;

    //costruttore di default

    private void setStrategy(Stanza s) {//deve poterlo chiamare solo ContrStanza
        boolean stratApply = false;
        if (s.getTemperatura() < 6 || s.getTemperatura() >= 16) {
            strategy = new StrategiaTemperatura();
            strategy.gestisciStanza(s);
            stratApply = true;
        }
        if (s.getUmidita() < 60 || s.getUmidita() >= 85) {
            strategy = new StrategiaUmidita();
            strategy.gestisciStanza(s);
            stratApply = true;
        }
        if (!stratApply)
            System.out.println("\nLa stanza non ha richiesto alcun intervento");
    }

    @Override //dentro update si chiama setStrategy perché se c'è notifica siamo sicuri che qualche parametro non va bene
    public void update(Observable observable, Object o) {//update PULL
        Stanza s = (Stanza) observable;//se si volesse tenere delle variabili in cui è aggiornato lo stato del
        setStrategy(s);//Subject, dentro update bisognerebbe fare tutte dei getter su
    }//Stanza per tutti i parametri e salvare su attributi di ControlloreStanza

    public StrategiaStanza getStrategy() {
        return strategy;
    }
}
