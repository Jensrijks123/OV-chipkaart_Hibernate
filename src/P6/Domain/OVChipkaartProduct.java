//package P6.Domain;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.sql.Date;
//
//@Entity(name ="ov_chipkaart_product")
//public class OVChipkaartProduct implements Serializable {
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "kaart_nummer")
//    private OVChipkaart ovChipkaart;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "product_nummer")
//    private Product product;
//    private String status;
//    private Date last_update;
//
//    public OVChipkaartProduct(OVChipkaart ovChipkaart, Product product, String status, Date last_update) {
//        this.ovChipkaart = ovChipkaart;
//        this.product = product;
//        this.status = status;
//        this.last_update = last_update;
//    }
//
//    public OVChipkaartProduct() {
//
//    }
//
//    public OVChipkaart getOvChipkaart() {
//        return ovChipkaart;
//    }
//
//    public void setOvChipkaart(OVChipkaart ovChipkaart) {
//        this.ovChipkaart = ovChipkaart;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Date getLast_update() {
//        return last_update;
//    }
//
//    public void setLast_update(Date last_update) {
//        this.last_update = last_update;
//    }
//
//    @Override
//    public String toString() {
//        return "OVChipkaartProduct{" +
////                "ovChipkaart=" + ovChipkaart +
////                ", product=" + product +
//                ", status='" + status + '\'' +
//                ", last_update=" + last_update +
//                '}';
//    }
//}
