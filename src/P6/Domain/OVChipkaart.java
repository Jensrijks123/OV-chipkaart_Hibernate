package P6.Domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name ="ov_chipkaart")
public class OVChipkaart {

    @Id
    @Column(name = "kaart_nummer")
    private int kaartnummer;
    private Date geldig_Tot;
    private int klasse;

    private double saldo;
    @ManyToOne
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = { @JoinColumn(name = "kaart_nummer") },
            inverseJoinColumns = { @JoinColumn(name = "product_nummer") }
    )
    private List<Product> producten = new ArrayList<>();

    public OVChipkaart(int kaartnummer, Date geldingTot, int klasse, double saldo, Reiziger reiziger, List<Product> producten) {
        this.kaartnummer = kaartnummer;
        this.geldig_Tot = geldingTot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = reiziger;
        this.producten = producten;
    }

    public OVChipkaart() {

    }

    public int getKaartnummer() {
        return kaartnummer;
    }

    public void setKaartnummer(int kaartnummer) {
        this.kaartnummer = kaartnummer;
    }

    public Date getGeldingTot() {
        return geldig_Tot;
    }

    public void setGeldingTot(Date geldingTot) {
        this.geldig_Tot = geldingTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    public void addProducten(List<Product> producten, Product product) {
        producten.add(product);
    }

    public void deleteProducten(List<Product> producten, Product product) {
        producten.remove(product);
    }

    @Override
    public String toString() {
        return "OVChipkaart{" +
                "kaartnummer=" + kaartnummer +
                ", geldingTot=" + geldig_Tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", rezigerNaam=" + reiziger.getNaam() +
//                ", prodcuten=" + producten.toString() +
                '}';
    }
}
