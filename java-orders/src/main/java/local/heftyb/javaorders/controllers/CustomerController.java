package local.heftyb.javaorders.controllers;

import local.heftyb.javaorders.models.Customer;
import local.heftyb.javaorders.services.CustomerService;
import local.heftyb.javaorders.views.OrderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllOrders ()
    {
        List<Customer> allCustomers = customerService.findAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> listCustomerById (@PathVariable Long id)
    {
        Customer cust = customerService.findCustomerById(id);
        return new ResponseEntity<>(cust, HttpStatus.OK);
    }

    @GetMapping(value = "/namelike/{name}", produces = {"application/json"})
    public ResponseEntity<?> listCustomersLike (@PathVariable String name)
    {
        List<Customer> likeCustomers = customerService.findByNameLike(name);
        return new ResponseEntity<>(likeCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "/orders/count", produces = {"application/json"})
    public ResponseEntity<?> listCustomerOrderCount ()
    {
        List<OrderCount> list = customerService.getOrderCounts();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
