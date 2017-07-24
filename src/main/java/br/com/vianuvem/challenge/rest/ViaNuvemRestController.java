package br.com.vianuvem.challenge.rest;

import br.com.vianuvem.challenge.converter.ConverterUtils;
import br.com.vianuvem.challenge.dto.ListsDTO;
import br.com.vianuvem.challenge.dto.OrderDTO;
import br.com.vianuvem.challenge.rest.request.ListsRQ;
import br.com.vianuvem.challenge.rest.request.OrderRQ;
import br.com.vianuvem.challenge.rest.response.ListsRS;
import br.com.vianuvem.challenge.rest.response.OrderRS;
import br.com.vianuvem.challenge.service.ListsService;
import br.com.vianuvem.challenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by eltonmoraes on 7/17/17.
 */
@RestController
public class ViaNuvemRestController {

    @Autowired
    private ListsService listsService;

    @Autowired
    private OrderService orderService;


    @RequestMapping(
            value = "findAllLists",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.OK)
    public List<ListsRS> findAllLists() throws Exception {
        List<ListsRS> lists = ConverterUtils.convertTo(listsService.findAllLists(), List.class);
        return lists;
    }

    @RequestMapping(
            value = "saveList",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json"
    )
    @ResponseStatus(code = HttpStatus.CREATED)
    public ListsRS saveNewList(@RequestBody ListsRQ rq) throws Exception {
        ListsDTO dto = ConverterUtils.convertTo(rq, ListsDTO.class);
        ListsRS response = ConverterUtils.convertTo(listsService.saveList(dto), ListsRS.class);

        return response;
    }

    @RequestMapping(
            value = "saveList",
            method = RequestMethod.PUT,
            produces = "application/json",
            consumes = "application/json"
    )
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ListsRS updateList(@Valid
                              @RequestBody
                               ListsRQ rq) throws Exception{
        ListsDTO dto = ConverterUtils.convertTo(rq, ListsDTO.class);
        ListsRS response = ConverterUtils.convertTo(listsService.saveList(dto), ListsRS.class);

        return response;
    }

    @RequestMapping(
            value = "deleteList",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteList(
            @Valid
            @NotNull(message = "lists.pk.notnull")
            @RequestParam("pk")
            @Min(value = 0, message = "lists.pk.min")
            Integer pk) throws Exception{

        listsService.deleteList(pk);
    }

    @RequestMapping(
            value = "saveOrder",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderRS saveOrder(@RequestBody OrderRQ rq) throws Exception{
        OrderDTO dto = ConverterUtils.convertTo(rq, OrderDTO.class);
        OrderRS response = ConverterUtils.convertTo(orderService.saveOrder(dto), OrderRS.class);

        return response;
    }

    @RequestMapping(
            value = "saveOrder",
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public OrderRS updateOrder(
            @Valid
            @RequestBody OrderRQ rq) throws Exception{
        OrderDTO dto = ConverterUtils.convertTo(rq, OrderDTO.class);
        OrderRS response = ConverterUtils.convertTo(orderService.saveOrder(dto), OrderRS.class);

        return response;
    }

    @RequestMapping(
            value = "deleteOrder",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteOrder(@Valid
                            @NotNull(message = "order.pk.notnull")
                            @RequestParam("pk")
                            @Min(value = 0, message = "order.pk.min")
                            Integer pk) throws Exception{
        orderService.deleteOrder(pk);
    }

    @RequestMapping(
            value = "findAllOrders",
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.OK)
    public List<OrderRS> findAllOrders() throws Exception{
        List<OrderRS> response = ConverterUtils.convertTo(orderService.findAllOrders(),List.class);
        return response;
    }

    @RequestMapping(
            value = "findOrdersByList",
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.OK)
    public List<OrderRS> findOrdersByList(
            @Valid
            @NotNull(message = "{lists.pk.notnull}")
            @RequestParam("list_pk")
            Integer listsPk) throws Exception{
        List<OrderRS> response = ConverterUtils.convertTo(orderService.findOrdersByList(listsPk),List.class);
        return response;
    }

    @RequestMapping(
            value = "findOrderByPk",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseStatus(code = HttpStatus.OK)
    public OrderRS findOrderByPk(@RequestParam("pk") Integer pk) throws Exception{
        OrderRS response = ConverterUtils.convertTo(orderService.findOrderByPk(pk), OrderRS.class);
        return response;
    }

}
