package vino;

import javax.management.InvalidAttributeValueException;
import java.util.Observable;

public abstract class Vino extends Observable {
    private final SchedaTecnica st;
    protected final String nome;
    protected float anidrideSolforosa;
    protected float pH;
    protected float zuccheriRiduttori;
    protected float gradoAlcolico;
    protected float ossigeno;

    public Vino(String nome, SchedaTecnica st) throws NullPointerException, IllegalArgumentException {
        if (nome == null)
            throw new NullPointerException("\nIl vino non può essere nullo!!");
        if (nome.isEmpty())
            throw new IllegalArgumentException("\nIl vino non può avere nome vuoto!!");
        this.nome = nome;
        this.st = st;
        anidrideSolforosa = 110 + (float)(Math.random() * 50);
        pH = 3.3f;
        zuccheriRiduttori = 160 + (float)(Math.random() * 50);
        gradoAlcolico = 10 + (float)(Math.random() * 4);
        ossigeno = (float)(Math.random() * 0.5);
    }

    public void correggiVino() {
        System.out.println("\n"+"Trattamento "+nome+" con azoto. "+"Valore ossigeno da correggere: "+ossigeno);
        ossigeno = (float)(Math.random() * 0.5);//rimette i valori sotto 0.5
        printVino();
    }

    public abstract boolean varia();

    public void printVino() {
        System.out.println("\nSCHEDA TECNICA:");
        System.out.println("Nome: "+nome);
        st.printSchedaTecnica();
        System.out.println("\nPARAMETRI:");
        System.out.println("Anidride Solforosa: "+anidrideSolforosa+" mg/L");
        System.out.println("PH: "+pH);
        System.out.println("Zuccheri Riduttori: "+zuccheriRiduttori+" mg/L");
        System.out.println("Grado Alcolico: "+gradoAlcolico+" %");
        System.out.println("Ossigeno: "+ossigeno+" mg/L");
    }

    /*void safePrintVino() {
        try {
            printVino();
        }catch (InvalidAttributeValueException e) {
            System.out.println("\nImpossibile stampare un vino senza nome!");
        }
    }

     */

    public float getAnidrideSolforosa() { return anidrideSolforosa; }

    public float getpH() { return pH; }

    public float getZuccheriRiduttori() { return zuccheriRiduttori; }

    public float getGradoAlcolico() { return gradoAlcolico; }

    public String getNome() { return nome; }

    public float getOssigeno() { return ossigeno; }

    public SchedaTecnica getSt() { return st; }//TODO: defensive copy


}

