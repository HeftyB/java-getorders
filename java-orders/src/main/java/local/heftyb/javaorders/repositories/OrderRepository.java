package local.heftyb.javaorders.repositories;

import local.heftyb.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
}
