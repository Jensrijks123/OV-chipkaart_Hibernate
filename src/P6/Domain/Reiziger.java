package P6.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reiziger {

    @Id
    @Column(name = "reiziger_id")
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private java.sql.Date geboortedatum;
    @OneToOne(mappedBy = "reiziger")
    @PrimaryKeyJoinColumn
    private Adres adres;
    @OneToMany
    private List<OVChipkaart> ovChipkaarten;

    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, java.sql.Date geboortedatum, Adres adres, List<OVChipkaart> ovChipkaarten) {
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
        this.ovChipkaarten = ovChipkaarten;
    }

    public Reiziger() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public java.sql.Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(java.sql.Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<OVChipkaart> getOvChipkaarten() {
        return ovChipkaarten;
    }

    public void setOvChipkaarten(List<OVChipkaart> ovChipkaarten) {
        this.ovChipkaarten = ovChipkaarten;
    }

    public String getNaam() {
        if (tussenvoegsel == null) {
            tussenvoegsel = "";
        }
        return "" + getVoorletters() + " " + tussenvoegsel + getAchternaam();
    }

    public void addOVChipkaart(List<OVChipkaart> ovChipkaarten, OVChipkaart ovChipkaart) {
        ovChipkaarten.add(ovChipkaart);
    }

    public void deleteOVChipkaart(List<OVChipkaart> ovChipkaarten, OVChipkaart ovChipkaart) {
        ovChipkaarten.remove(ovChipkaart);
    }

    @Override
    public String toString() {

        String adresWoonplaats = "";
        if (adres != null) {
            adresWoonplaats = adresWoonplaats + adres.getWoonplaats();
        } else {
            adresWoonplaats = adresWoonplaats + "";
        }

        return "Reiziger{" +
                "id=" + id +
                ", voorletters='" + voorletters + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum + '\'' +
                ", adres=" + adresWoonplaats + '\'' +
                '}';
    }
}
