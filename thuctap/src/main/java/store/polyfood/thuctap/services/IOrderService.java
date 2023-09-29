package store.polyfood.thuctap.services;

import org.springframework.http.ResponseEntity;
import store.polyfood.thuctap.models.entities.OrderDetail;
import store.polyfood.thuctap.models.entities.Orders;
import store.polyfood.thuctap.models.responobject.Response;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IOrderService {
    public Response createNew(Orders request);
    public Response<Map<String, Object>> getAll(int page, int pageSize);
    public Response update(Orders request);
    public Response delete(int id);
    public Response<Orders> getById(int id);
    public Response updatePayment(int orderId, int paymentId);
    public Response<Set<OrderDetail>> getOrderDetails(int orderId);

    public Response<List<Orders>> getOrders();
}
