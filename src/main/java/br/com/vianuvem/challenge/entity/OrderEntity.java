package br.com.vianuvem.challenge.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eltonmoraes on 7/18/17.
 */
@Entity
@Table(name = "Orders")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 4689839417901551278L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk;
    private String name;
    private Integer quantity;
    private Double price;
    private String nameImage;
    private char marked;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lists.pk")
    private ListsEntity lists;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public char getMarked() {
        return marked;
    }

    public void setMarked(char marked) {
        this.marked = marked;
    }

    public ListsEntity getLists() {
        return lists;
    }

    public void setLists(ListsEntity lists) {
        this.lists = lists;
    }
}
