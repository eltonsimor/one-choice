package br.com.vianuvem.challenge.rest.response;

import java.io.Serializable;

/**
 * Created by eltonmoraes on 7/18/17.
 */
public class ListsRS implements Serializable {

    private static final long serialVersionUID = 580473283654278893L;

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
