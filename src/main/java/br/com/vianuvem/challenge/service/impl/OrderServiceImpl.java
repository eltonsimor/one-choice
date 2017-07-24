package br.com.vianuvem.challenge.service.impl;

import br.com.vianuvem.challenge.converter.ConverterUtils;
import br.com.vianuvem.challenge.dto.OrderDTO;
import br.com.vianuvem.challenge.entity.ListsEntity;
import br.com.vianuvem.challenge.entity.OrderEntity;
import br.com.vianuvem.challenge.repository.ListsRepository;
import br.com.vianuvem.challenge.repository.OrderRepository;
import br.com.vianuvem.challenge.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.List;

/**
 * Created by eltonmoraes on 7/18/17.
 */
@Singleton
@Component
public class OrderServiceImpl implements OrderService {

    private static final long serialVersionUID = -5049431489402923718L;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ListsRepository listsRepository;

    @Override
    public OrderDTO saveOrder(OrderDTO dto) throws Exception {
        ListsEntity listsEntity = listsRepository.findOne(dto.getLists().getPk());
        OrderEntity orderEntity = ConverterUtils.convertTo(dto, OrderEntity.class);
        orderEntity.setLists(listsEntity);
        orderEntity = orderRepository.save(orderEntity);
        dto = ConverterUtils.convertTo(orderEntity, OrderDTO.class);

        return dto;
    }

    @Override
    public List<OrderDTO> findAllOrders() throws Exception {
        List<OrderDTO> ordersDto = ConverterUtils.convertTo(orderRepository.findAll(), List.class);
        return ordersDto;
    }

    @Override
    public List<OrderDTO> findOrdersByList(Integer listsPk) throws Exception {
        List<OrderDTO> ordersDto= ConverterUtils.convertTo(orderRepository.findOrdersByList(listsPk),List.class);
        return ordersDto;
    }

    @Override
    public void deleteOrder(Integer pk) throws Exception {
        orderRepository.delete(pk);
    }

    @Override
    public OrderDTO findOrderByPk(Integer pk) throws Exception {
        OrderDTO dto = ConverterUtils.convertTo(orderRepository.findOne(pk), OrderDTO.class);
        return dto;
    }


}
