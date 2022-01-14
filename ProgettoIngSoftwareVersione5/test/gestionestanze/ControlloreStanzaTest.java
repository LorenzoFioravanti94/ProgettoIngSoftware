package gestionestanze;
/*
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControlloreStanzaTest {
    ControlloreStanza cs;
    Stanza s;

    @Before
    public void initialize() {
        cs = new ControlloreStanza();
        s = new Stanza(0);
        s.varia();
    }

    @Test ( expected = NullPointerException.class)
    public void nullObservableUpdate() {
        cs.update(null,null);
    }

    @Test
    public void testSetStrategy() {
        if ((s.getTemperatura() < 6 || s.getTemperatura() >= 16) && (s.getUmidita() >= 60 && s.getUmidita() < 85)) {
            /*dato che sequenzialmente setStrategy se trova sia temp che umidita sballati l'ultimo oggetto a
            essere instanziato è StrategiaOssigeno, allora sulla temp si controlla quando umidita è giusta e
            temp sbagliata. Sotto si controlla solo umidita

             */
/*

            cs.update(s, null);
            assertTrue(cs.getStrategy() instanceof StrategiaTemperatura);
        }
        else if(s.getUmidita() < 60 || s.getUmidita() >= 85) {
            cs.update(s, null);
            assertTrue(cs.getStrategy() instanceof StrategiaUmidita);
        }
        else {
            assertFalse(cs.getStrategy() instanceof StrategiaTemperatura);
            assertFalse(cs.getStrategy() instanceof StrategiaUmidita);
            //nel caso in cui sia tutto giusto il riferimento a StrategiaStanza è nullo
        }

    }

}

*/



