package br.com.vianuvem.challenge.repository;

import br.com.vianuvem.challenge.entity.ListsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eltonmoraes on 7/18/17.
 */
@Transactional
public interface ListsRepository extends CrudRepository<ListsEntity, Integer> {
}
