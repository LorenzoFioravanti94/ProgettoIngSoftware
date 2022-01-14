package vino;


public class VinoRosso extends Vino {

    public enum TipoRosso {
        ChiantiClassico,
        BolgheriSassicaia,
        Morellino,
        AmaroneMazzano,
        BaroloMonprivato,
        Brunello,
        Collio,
        Nobile,
        Tignanello,
        Solaia;
    }


    private final TipoRosso denominazione;



    public VinoRosso(String nome, SchedaTecnica st) {
        super(nome,st);
        denominazione = TipoRosso.valueOf(nome);
    }

    @Override
    public boolean varia() {//observer PUSH perché i parametri del vino sono esclusivi tra loro
        anidrideSolforosa = 120 + (float)(Math.random() * 42);//120 e 162 LIMITE:160
        pH = (float)(3.28 + Math.random() * 0.24);//tra 3.28 e 3.52 LIMITE: 3.3 <= x <= 3.5
        zuccheriRiduttori = 170 + (float)(Math.random() * 42);//170 e 212 LIMITE: 210
        gradoAlcolico = (float)(9.7 + Math.random() * 6.6);//9.7 e 16.3 LIMITE: 10 <= x <= 16
        ossigeno = (float)(0.3 + Math.random() * 0.5);//tra 0.3 e 0.8(uguale)

        printVino();

        setChanged();


        if (anidrideSolforosa > 160) {
            notifyObservers(new Float(anidrideSolforosa));
            return true;
        }
        if (pH < 3.3 || pH > 3.5) {
            notifyObservers(new Float(pH));
            return true;
        }
        if (zuccheriRiduttori > 210) {
            notifyObservers(new Float(zuccheriRiduttori));
            return true;
        }
        if (gradoAlcolico < 10 || gradoAlcolico > 16) {
            notifyObservers(new Float(gradoAlcolico));
            return true;
        }
        if (ossigeno >= 0.5) {//è l'ultima cosa da controllare perché è l'unico caso in cui il vino non si butta
            notifyObservers(new Float(ossigeno));
            return true;
        }
        System.out.println("\nIl vino "+denominazione+" non ha richiesto alcun intervento");
        return false;//serve per sapere se i parametri del vino del vino sono ancora accettabili
    }




}
