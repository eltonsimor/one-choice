package br.com.vianuvem.challenge.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eltonmoraes on 7/18/17.
 */
@Entity
@Table(name = "Lists")
public class ListsEntity implements Serializable {

    private static final long serialVersionUID = -651067394324985549L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk;
    private String name;

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
}
