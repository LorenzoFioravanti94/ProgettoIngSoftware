package vino;
/*
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VinoTest {
    Vino vr;
    Vino vb;
    Vino vrs;
    //printVino() è stupida e non necessita test
    @Before
    public void initialize() {
        vr = new VinoRosso("Morellino",new SchedaTecnica("prova",1,"prova",true,"prova"));
        vb = new VinoBianco("Bastianich",new SchedaTecnica("prova",1,"prova",true,"prova"));
        vrs = new VinoRosato("Vulcano",new SchedaTecnica("prova",1,"prova",true,"prova"));
    }

    @Test
    public void testCorreggiVino() {//me ne frego del valore che gli assegna il costruttore
        vr.varia();
        vr.correggiVino();
        assertTrue(vr.getOssigeno() < 0.5);
        //verifico solo che dopo l'operazione sia minore di 0.5
    }

    @Test
    public void testRossoVaria() {//testa se gli attributi dei vini stanno negli intervalli da noi stabiliti
        boolean hasSpoiled = vr.varia();
        //RICORDA: non hai istanziato nessun observer quindi quando varia() fa la notify() non verrà
        //chimata l'update su nessun oberver(va a nostro vantaggio perché a noi varia serve nei test solo
        //per cambiare i vini)
        if (vr.getAnidrideSolforosa() > 160 || vr.getpH() < 3.3 || vr.getpH() > 3.5 || vr.getZuccheriRiduttori() > 210 || vr.getGradoAlcolico() < 10 || vr.getGradoAlcolico() > 16 || vr.getOssigeno() >= 0.5)
            assertTrue(hasSpoiled);
        else
            assertFalse(hasSpoiled);//se non esce dai limiti nulla
    }

    @Test
    public void testBiancoVaria() {//testa se gli attributi dei vini stanno negli intervalli da noi stabiliti
        boolean hasSpoiled = vb.varia();
        if (vb.getAnidrideSolforosa() > 210 || vb.getpH() < 3 || vb.getpH() > 3.3 || vb.getZuccheriRiduttori() > 260 || vb.getGradoAlcolico() < 10 || vb.getGradoAlcolico() > 14 || vb.getOssigeno() >= 0.5)
            assertTrue(hasSpoiled);
        else
            assertFalse(hasSpoiled);//se non esce dai limiti nulla
    }

    @Test
    public void testRosatoVaria() {//testa se gli attributi dei vini stanno negli intervalli da noi stabiliti
        boolean hasSpoiled = vrs.varia();
        if (vrs.getAnidrideSolforosa() > 190 || vrs.getpH() < 3.2 || vrs.getpH() > 3.4 || vrs.getZuccheriRiduttori() > 230 || vrs.getGradoAlcolico() < 10 || vrs.getGradoAlcolico() > 16 || vrs.getOssigeno() >= 0.5)
            assertTrue(hasSpoiled);
        else
            assertFalse(hasSpoiled);//se non esce dai limiti nulla
    }
}


 */

