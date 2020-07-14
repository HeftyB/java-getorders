package local.heftyb.javaorders.controllers;

import local.heftyb.javaorders.models.Order;
import local.heftyb.javaorders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/order/{id}", produces = {"application/json"})
    public ResponseEntity<?> listOrderById (@PathVariable long id)
    {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
