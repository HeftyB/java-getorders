package local.heftyb.javaorders.services;

import local.heftyb.javaorders.models.Order;

public interface OrderService
{
    Order findOrderById(long id);
}
