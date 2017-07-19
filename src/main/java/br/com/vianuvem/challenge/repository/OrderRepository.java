package br.com.vianuvem.challenge.repository;

import br.com.vianuvem.challenge.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by eltonmoraes on 7/18/17.
 */
@Transactional
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

    @Query("select o from OrderEntity o where o.lists.pk = :listsPk")
    List<OrderEntity> findOrdersByList(@Param("listsPk") Integer listsPk) throws Exception;
}
