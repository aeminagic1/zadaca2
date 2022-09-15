package ba.unsa.etf.rpr;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private final String ime;
    private final String prezime;
    private final String brojIndexa;
    private  Integer semestar;
    private  Integer ciklus;
    private Map<Predmet, Integer> ocjene;

    public Student(String ime, String prezime, String brojIndexa, Integer semestar, Integer ciklus) {
        ocjene=new HashMap<>(); //implementation of the Map Interface
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndexa = brojIndexa;
        this.semestar = semestar;
        this.ciklus = ciklus;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public Integer getSemestar() {
        return semestar;
    }

    public Integer getCiklus() {
        return ciklus;
    }

    public Map<Predmet, Integer> getOcjene() {
        return ocjene;
    }
    public void upisiPredmet(Predmet predmet){

        ocjene.put(predmet, 5);
    }
    public void upisiOcjenu(Predmet predmet, Integer ocjena){
        for(Map.Entry<Predmet,Integer> entry : ocjene.entrySet()){
            if(predmet.equals(entry.getKey())) entry.setValue(ocjena);
        }
    }
    public String getPrepisOcjena(){
        StringBuilder s= new StringBuilder();
        for(Map.Entry<Predmet,Integer> entry : ocjene.entrySet()){
            s.append(entry.getKey().toString());
            s.append(": Ocjena ");
            s.append(entry.getValue());
            s.append('\n');
        }
        return s.toString();
    }
}