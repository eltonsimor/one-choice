package br.com.vianuvem.challenge.dto;

import java.io.Serializable;

/**
 * Created by eltonmoraes on 7/18/17.
 */
public class ListsDTO implements Serializable {

    private static final long serialVersionUID = 2969476374617646L;

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
