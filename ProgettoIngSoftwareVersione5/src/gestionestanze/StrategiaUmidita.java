package gestionestanze;

class StrategiaUmidita implements StrategiaStanza {//package

    // costruttore default

    @Override
    public void gestisciStanza(Stanza s) {
        s.correggiUmidita();
    }
}
