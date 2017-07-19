package br.com.vianuvem.challenge.service;

import br.com.vianuvem.challenge.dto.ListsDTO;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eltonmoraes on 7/18/17.
 */
public interface ListsService extends Serializable{

    List<ListsDTO> findAllLists() throws Exception;

    ListsDTO saveList(ListsDTO dto) throws Exception;

    ListsDTO findListByPk(Integer pk) throws Exception;

    void deleteList(Integer pk) throws Exception;

}
