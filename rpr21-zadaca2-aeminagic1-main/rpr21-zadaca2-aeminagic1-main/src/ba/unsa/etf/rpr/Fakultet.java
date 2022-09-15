package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fakultet {
    private List<Student> studenti = new ArrayList<>();
    private List<Predmet> predmeti = new ArrayList<>();
    private List<Profesor> profesori = new ArrayList<>();
    public void upisiStudentaNaFakultet(Student student, List<Predmet> izborni) throws StudentVecUpisanException,NedovoljanBrojECTSKReditaException,NepostojeciPredmetException {
        int brojKredita = 0;
        if(studenti.contains(student)) throw new StudentVecUpisanException("Student je vec upisan na fakultet");
        for(Predmet izbor:izborni)
            if(!predmeti.contains(izbor) || izbor.isObavezan()) throw new NepostojeciPredmetException("Odabran je nepostojeci predmet");
        for (Predmet predmet : predmeti) {
            if (predmet.isObavezan() && predmet.getSemestar() == student.getSemestar() && predmet.getCiklus() == student.getCiklus())
                brojKredita += predmet.getBrojECTSKredita();
            if (izborni.contains(predmet)) brojKredita += predmet.getBrojECTSKredita();
        }
        if (brojKredita < 30) throw new NedovoljanBrojECTSKReditaException("Odabran je nedovoljan broj ECTS kredita");
        studenti.add(student);
        for (Predmet predmet : predmeti) {
            if (predmet.isObavezan() && predmet.getSemestar() == student.getSemestar() && predmet.getCiklus() == student.getCiklus())
                predmet.upisiStudentaNaPredmet(student);
            if (izborni.contains(predmet)) predmet.upisiStudentaNaPredmet(student);
        }
    }
    public Student getStudentPoIndeksu(String indeks) throws PogresanBrojIndeksaException{
        for (Student student : studenti) {
            if (indeks.equals(student.getBrojIndexa())) return student;
        }
        throw new PogresanBrojIndeksaException("Nema studenta sa tim indeksom");
    }
    public void dodajPredmet(Predmet predmet)throws PredmetVecPostojiException {
        if(predmeti.contains(predmet)) throw new PredmetVecPostojiException("Predmet vec postoji");
        predmeti.add(predmet);
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }
    public void setProfesor(Profesor profesor) throws ProfesorVecRadiException {
        if(profesori.contains(profesor)) throw new ProfesorVecRadiException("Profesor vec radi na fakultetu");
        profesori.add(profesor);
    }
    public String getProfesoreSortiranePoBrojuStudenata() {
        if (profesori == null) return "";
        List<Profesor> sortirani = profesori.stream().sorted(Comparator.comparing(Profesor::dajBrojStudenataKodProfesora)).collect(Collectors.toList());
        StringBuilder s = new StringBuilder();
        for (Profesor profesor : sortirani) {
            s.append(profesor);
            s.append('\n');
        }
        return s.toString();
    }
    public String getProfesoreSortiranePoNormi() {
        if (profesori == null) return "";
        List<Profesor> sortirani = profesori.stream().sorted(Comparator.comparing(Profesor::getNorma)).collect(Collectors.toList());
        StringBuilder s = new StringBuilder();
        for (Profesor profesor : sortirani) {
            s.append(profesor);
            s.append('\n');
        }
        return s.toString();
    }
    public String getProfesore() {
        if (profesori == null) return "";
        List<Profesor> sortirani = profesori.stream().filter(profesor -> profesor.getNorma() < 120 || profesor.getNorma() > 150).collect(Collectors.toList());
        StringBuilder s = new StringBuilder();
        for (Profesor profesor : sortirani) {
            s.append(profesor);
            s.append('\n');
        }
        return s.toString();
    }
}
