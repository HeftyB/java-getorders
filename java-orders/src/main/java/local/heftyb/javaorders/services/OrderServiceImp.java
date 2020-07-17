package local.heftyb.javaorders.services;

import local.heftyb.javaorders.models.Order;
import local.heftyb.javaorders.repositories.OrderRepository;
import local.heftyb.javaorders.views.OutstandingAdvance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class OrderServiceImp implements OrderService
{

    @Autowired
    OrderRepository ordrepo;

    @Override
    public Order findOrderById(long id) throws EntityNotFoundException
    {
        return ordrepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Order " + id + " Not Found"));
    }

    @Override
    public List<OutstandingAdvance> findAllOutstandingAdvance()
    {
        return ordrepo.findAllOutstandingAdvance();
    }
}
