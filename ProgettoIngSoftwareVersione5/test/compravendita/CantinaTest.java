package compravendita;
/*
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import vino.SchedaTecnica;
import vino.Vino;
import vino.VinoBianco;
import vino.VinoRosso;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CantinaTest {

    //getCantina(int)

    @Test( expected = Error.class )
    public void anEmptyGetCantina() {
        Cantina c = Cantina.getCantina(0);
    }

//addVino(Vino)

    @Test ( expected = IllegalArgumentException.class )
    public void nullAddVino() {
        Cantina c = Cantina.getCantina(4);
        c.addVino(null);
    }

    @Test ( expected = NullPointerException.class )
    public void nullNameAddVino() {
        Cantina c = Cantina.getCantina(4);
        c.addVino(new VinoRosso(null,new SchedaTecnica("prova",1,"prova",true,"prova")));
    }

    @Test ( expected = IllegalArgumentException.class )
    public void nullSchedaTecnicaAddVino() {
        Cantina c = Cantina.getCantina(4);
        c.addVino(new VinoRosso("BolgheriSassicaia",null));
    }

    @Test ( expected = IllegalArgumentException.class )
    public void emptyNameAddVino() {
        Cantina c = Cantina.getCantina(4);
        c.addVino(new VinoBianco("",new SchedaTecnica("prova",1,"prova",true,"prova")));
    }

    @Test ( expected = IllegalArgumentException.class )
    public void sameAddVino() {
        Cantina c = Cantina.getCantina(4);
        Vino v = new VinoRosso("BolgheriSassicaia",new SchedaTecnica("prova",1,"prova",true,"prova"));
        Vino w = v;
        c.addVino(v);
        c.addVino(w);
    }

    @Test            //Testa la creazione di una nuova botte nel caso non ci siano botti vuote
    public void newBotteAddVino() {//non si considera quando botti è vuota perché eseguono lo stesso codice
        Cantina c = Cantina.getCantina(4);
        for (int i=0; i< 3; i++)
            c.addVino(new VinoRosso("BolgheriSassicaia",new SchedaTecnica("prova",1,"prova",true,"prova")));
        Vino v = new VinoBianco("Chamonix",new SchedaTecnica("prova",1,"prova",true,"prova"));
        c.addVino(v);
        Integer chiave = c.getKey(v);//serve indice perché non si sa l'ordine dei test
        assertEquals(chiave.intValue(),c.getHashMapSize()-1);//si controlla che sia l'ultimo vio inserito-> nuova botte
        assertEquals(v,c.getVino(chiave));
    }

    @Test            //Testa l'inserimento di un nuovo vino nella prima botte vuota disponibile
    public void emptyBotteAddVino() {
        Cantina c = Cantina.getCantina(4);
        c.addVino(new VinoRosso("BolgheriSassicaia",new SchedaTecnica("prova",1,"prova",true,"prova")));
        Vino oldVino = new VinoBianco("Chamonix",new SchedaTecnica("prova",1,"prova",true,"prova"));
        c.addVino(oldVino);
        c.addVino(new VinoRosso("BolgheriSassicaia",new SchedaTecnica("prova",1,"prova",true,"prova")));
        Integer chiave = c.getKey(oldVino);//indice che serve perché non si sa l'ordine dei test
        c.removeVino(oldVino);
        Vino newVino = new VinoRosso("BolgheriSassicaia",new SchedaTecnica("prova",1,"prova",true,"prova"));
        c.addVino(newVino);
        assertEquals(newVino,c.getVino(chiave));
    }

    //removeVino(Vino)

    @Test ( expected = IllegalArgumentException.class )
    public void nullRemoveVino() {
        Cantina c = Cantina.getCantina(4);
        c.removeVino(null);
    }

    @Test ( expected = IllegalArgumentException.class )
    public void notFoundRemoveVino() {
        Cantina c = Cantina.getCantina(4);
        c.addVino(new VinoRosso("BolgheriSassicaia",new SchedaTecnica("prova",1,"prova",true,"prova")));
        c.addVino(new VinoBianco("Chamonix",new SchedaTecnica("prova",1,"prova",true,"prova")));
        Vino v = new VinoBianco("Bastianich",new SchedaTecnica("prova",1,"prova",true,"prova"));
        c.removeVino(v);
    }

    @Test
    public void testRemoveVino() {
        Cantina c = Cantina.getCantina(4);
        c.addVino(new VinoRosso("BolgheriSassicaia",new SchedaTecnica("prova",1,"prova",true,"prova")));
        Vino v = new VinoBianco("Bastianich",new SchedaTecnica("prova",1,"prova",true,"prova"));
        c.addVino(v);
        Integer chiave = c.getKey(v);
        c.addVino(new VinoBianco("Chamonix",new SchedaTecnica("prova",1,"prova",true,"prova")));
        c.removeVino(v);
        assertNull(c.getVino(chiave));
    }

}



 */