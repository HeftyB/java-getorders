package local.heftyb.javaorders.services;

import local.heftyb.javaorders.models.Customer;
import local.heftyb.javaorders.repositories.CustomerRepository;
import local.heftyb.javaorders.views.OrderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImp implements CustomerService
{
    @Autowired
    private CustomerRepository custrepo;

    @Override
    public List<Customer> findAllCustomers()
    {
        List<Customer> customerList = new ArrayList<>();
        custrepo.findAll().iterator().forEachRemaining(customerList::add);
        return customerList;
    }

    @Override
    public Customer findCustomerById(long id) throws EntityNotFoundException
    {
        return custrepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
    }

    @Override
    public List<Customer> findByNameLike(String name)
    {
        ArrayList<Customer> customerList = (ArrayList<Customer>) custrepo.findByCustnameContainingIgnoringCase(name);
        return customerList;
    }

    @Override
    public List<OrderCount> getOrderCounts()
    {
        return custrepo.getOrderCounts();
    }
}
