package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private final String imeIPrezime;
    private List<Predmet> predmetiKojePredaje;
    private int norma;

    public Profesor(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
        norma=0;
        predmetiKojePredaje=new ArrayList<>();
    }

    public List<Predmet> getPredmetiKojePredaje() {
        return predmetiKojePredaje;
    }

    public int getNorma() {
        return norma;
    }
    public int dajBrojStudenataKodProfesora(){
        int brojStudenata=0;
        for(Predmet predmet:predmetiKojePredaje){
            brojStudenata+=predmet.getUpisaniStudentiNaPredmetu().size();
        }
        return brojStudenata;
    }
    @Override
    public String toString() {
        return imeIPrezime;
    }

    public void setNorma(Predmet predmet) {
        if(predmet.getUpisaniStudentiNaPredmetu().size()>=1) {
            this.norma = this.norma+predmet.getBrojCasova();
        }
    }
}
