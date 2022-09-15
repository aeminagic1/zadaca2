package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Predmet {
    private String nazivPredmeta;
    private boolean obavezan;
    private int ciklus;
    private int semestar;
    private int brojECTSKredita;
    private Profesor profesor;
    private List<Student> upisaniStudentiNaPredmetu;
    private int brojCasova;

    public Predmet(String nazivPredmeta, boolean obavezan, int ciklus, int semestar, int brojEcts, Profesor profesor, int brojCasova) {
        upisaniStudentiNaPredmetu=new ArrayList<>();
        this.nazivPredmeta = nazivPredmeta;
        this.obavezan = obavezan;
        this.ciklus = ciklus;
        this.semestar = semestar;
        this.brojECTSKredita = brojEcts;
        this.profesor = profesor;
        this.brojCasova = brojCasova;
    }
    public void upisiStudentaNaPredmet(Student student){
        upisaniStudentiNaPredmetu.add(student);
        student.upisiPredmet(this);

    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public boolean isObavezan() {
        return obavezan;
    }

    public int getCiklus() {
        return ciklus;
    }

    public int getSemestar() {
        return semestar;
    }

    public int getBrojECTSKredita() {
        return brojECTSKredita;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Student> getUpisaniStudentiNaPredmetu() {
        return upisaniStudentiNaPredmetu;
    }

    public int getBrojCasova() {
        return brojCasova;
    }
    @Override
    public String toString() {

        return nazivPredmeta;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nazivPredmeta, obavezan, ciklus, semestar, brojECTSKredita, profesor, upisaniStudentiNaPredmetu, brojCasova);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predmet predmet = (Predmet) o;
        return obavezan == predmet.obavezan &&
                ciklus == predmet.ciklus &&
                semestar == predmet.semestar &&
                brojECTSKredita == predmet.brojECTSKredita &&
                brojCasova == predmet.brojCasova &&
                Objects.equals(nazivPredmeta, predmet.nazivPredmeta) &&
                Objects.equals(profesor, predmet.profesor) &&
                Objects.equals(upisaniStudentiNaPredmetu, predmet.upisaniStudentiNaPredmetu);
    }
}
