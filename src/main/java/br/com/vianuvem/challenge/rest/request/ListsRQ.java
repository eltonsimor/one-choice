package br.com.vianuvem.challenge.rest.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by eltonmoraes on 7/18/17.
 */
public class ListsRQ implements Serializable {

    private static final long serialVersionUID = 3367507274994213071L;

    @NotNull(message = "{lists.pk.notnull}")
    private Integer pk;
    @NotNull(message = "{lists.name.notnull}")
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
