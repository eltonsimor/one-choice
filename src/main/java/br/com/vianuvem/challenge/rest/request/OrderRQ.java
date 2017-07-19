package br.com.vianuvem.challenge.rest.request;

import javax.enterprise.context.NormalScope;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by eltonmoraes on 7/18/17.
 */
public class OrderRQ implements Serializable {

    private static final long serialVersionUID = -8489308305715230071L;

    @NotNull(message = "{order.pk.notnull}")
    private Integer pk;

    @NotNull(message = "{order.name.notnull}")
    private String name;

    @NotNull(message = "{order.quantity.notnull}")
    private Integer quantity;

    @NotNull(message = "{order.price.notnull}")
    private Double price;
    private String nameImage;
    private char marked;
    private ListsRQ lists;

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

    public ListsRQ getLists() {
        return lists;
    }

    public void setLists(ListsRQ lists) {
        this.lists = lists;
    }
}
