package gestionevini;

/*
import cantina.Cantina;
import org.junit.Before;
import org.junit.Test;
import vino.SchedaTecnica;
import vino.Vino;
import vino.VinoRosso;
import static org.junit.Assert.*;

public class MonitorVinoTest {
    MonitorVino mv;
    Vino v;
    Cantina c;

    @Before
    public void initialize() {
        mv = new MonitorVino();
        v = new VinoRosso("Morellino",new SchedaTecnica("prova",1,"prova",true,"prova"));
        do {
            v.varia();
        }
        while (v.getAnidrideSolforosa() <= 160 && v.getpH() >= 3.3 && v.getpH() <= 3.5 && v.getZuccheriRiduttori() <= 210 && v.getGradoAlcolico() >= 10 && v.getGradoAlcolico() <= 16 && v.getOssigeno() < 0.5);
        //serve perché in testUpdate nel programma non può mai succedere che update venga chiamata
        //se i parametri sono tutti corretti. Qua invece può succedere quindi bisogna fare in modo che non succeda
        //NOTA BENE: varia() non può chimare notifyObservers()->update()->setStrategy()->gestisciVino()
        //perché apposta non abbiamo fatto l'attach degli observer sui vini, in modo che varia() faccia soltanto
        //variare il vino senza,tramite chiamate a catena, risolverlo
        c = Cantina.getCantina(4);//serve per Istanceof
        c.addVino(v);
    }

    @Test ( expected = NullPointerException.class)
    public void nullObservableUpdate() {
        mv.update(null,new Float(2.2));
    }

    @Test ( expected = NullPointerException.class)
    public void nullParameterPushUpdate() {
        mv.update(v,null);
    }

    @Test ( expected = ClassCastException.class)
    public void wrongTypeParameterPushUpdate() {
        mv.update(v,new Integer(2));
    }

    @Test
    public void testSetStrategy() {
        if (v.getAnidrideSolforosa() <= 160 && v.getpH() >= 3.3 && v.getpH() <= 3.5 && v.getZuccheriRiduttori() <= 210 && v.getGradoAlcolico() >= 10 && v.getGradoAlcolico() <= 16 && v.getOssigeno() >= 0.5) {
            mv.update(v, v.getOssigeno());//gli passiamo l'ossigneo noi in modo che nell'uguale entri
            assertTrue(mv.getStrategy() instanceof StrategiaOssigeno);
            //si testa quando tutti i parametri sono giusti e solo l'ossigeno è sbagliato
            //non possono mai essere tutti giusti grazie al do while nell'init
        } else {
            mv.update(v,v.getAnidrideSolforosa());//in modo che non possa essere uguale a ossigeno
            assertTrue(mv.getStrategy() instanceof StrategiaGenerale);
        }
    }

}



 */
