package br.com.vianuvem.challenge.service.impl;

import br.com.vianuvem.challenge.converter.ConverterUtils;
import br.com.vianuvem.challenge.dto.ListsDTO;
import br.com.vianuvem.challenge.entity.ListsEntity;
import br.com.vianuvem.challenge.repository.ListsRepository;
import br.com.vianuvem.challenge.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.List;

/**
 * Created by eltonmoraes on 7/18/17.
 */
@Singleton
@Component
public class ListsServiceImpl implements ListsService {

    private static final long serialVersionUID = 7406658242948998892L;

    @Autowired
    private ListsRepository listsRepository;

    @Override
    public List<ListsDTO> findAllLists() throws Exception {
        List<ListsDTO> lists = ConverterUtils.convertTo(listsRepository.findAll(),List.class);
        return lists;
    }

    @Override
    public ListsDTO saveList(ListsDTO dto) throws Exception {
        ListsEntity entity = listsRepository.save(ConverterUtils.convertTo(dto, ListsEntity.class));
        ListsDTO listsDto = ConverterUtils.convertTo(entity, ListsDTO.class);

        return listsDto;
    }

    @Override
    public ListsDTO findListByPk(Integer pk) throws Exception {
        ListsDTO listsDto = ConverterUtils.convertTo(listsRepository.findOne(pk), ListsDTO.class);
        return listsDto;
    }

    @Override
    public void deleteList(Integer pk) throws Exception {
        listsRepository.delete(pk);
    }

}
