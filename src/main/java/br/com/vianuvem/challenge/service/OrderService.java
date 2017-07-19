package br.com.vianuvem.challenge.service;

import br.com.vianuvem.challenge.dto.ListsDTO;
import br.com.vianuvem.challenge.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eltonmoraes on 7/18/17.
 */
@Service
public interface OrderService extends Serializable {

    OrderDTO saveOrder(OrderDTO dto) throws Exception;
    List<OrderDTO> findAllOrders() throws Exception;
    List<OrderDTO> findOrdersByList(Integer listsPk) throws Exception;
    void deleteOrder(Integer pk) throws Exception;

}
