package net.partsList.model;

import javax.persistence.*;

@Entity
@Table(name = "part")
public class Parts {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PARTS")
    private String parts;

    @Column(name = "NEED")
    private int need;

    @Column(name = "quantity")
    private int quantity;

    public Parts() {
    }

    public Parts(String parts, int need, int quantity) {
        this.parts = parts;
        this.need = need;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", parts='" + parts + '\'' +
                ", need=" + need +
                ", quantity=" + quantity +
                '}';
    }
}
