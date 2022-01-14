package gestionevini;
import vino.Vino;

class StrategiaOssigeno implements StrategiaVino {//visibilità package

    //costruttore di default che è sicuramente package perché la classe è package

    @Override
    public void gestisciVino(Vino v) {
        v.correggiVino();
    }
}
