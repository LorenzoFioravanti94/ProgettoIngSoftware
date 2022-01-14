package gestionevini;
import java.util.Observable;
import java.util.Observer;
import vino.Vino;

public class MonitorVino implements Observer {
    private StrategiaVino strategy;

    //costruttore di default

    private void setStrategy(Vino v, float param) {//privato perché deve essere chiamato solo da MonitorVino
        if (param == v.getOssigeno())
            strategy = new StrategiaOssigeno();
        else
            strategy = new StrategiaGenerale();
        strategy.gestisciVino(v);
    }

    @Override //dentro update si chiama setStrategy perché se c'è notifica siamo sicuri che qualche parametro non va bene
    public void update(Observable observable, Object o) {
        Vino v = (Vino) observable;//se si volesse tenere delle variabili in cui è aggiornato lo stato del
        float param = ((Float) o).floatValue();//Subject, dentro update bisognerebbe fare tutte dei getter su
        setStrategy(v,param);//Vino per tutti i parametri e salvare su attributi di MonitorVino
    }

    public StrategiaVino getStrategy() {
        return strategy;
    }//FIXME copia difensiva?
}
