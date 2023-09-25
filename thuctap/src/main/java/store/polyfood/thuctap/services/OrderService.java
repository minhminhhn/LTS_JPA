package store.polyfood.thuctap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import store.polyfood.thuctap.models.entities.*;
import store.polyfood.thuctap.models.responobject.Response;
import store.polyfood.thuctap.repositories.OrderRepo;
import store.polyfood.thuctap.repositories.OrderStatusRepo;
import store.polyfood.thuctap.repositories.PaymentRepo;
import store.polyfood.thuctap.repositories.UserRepo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderStatusRepo orderStatusRepo;
    @Autowired
    private PaymentRepo paymentRepo;


    @Override
    public Response createNew(Orders request) {
        User user = userRepo.findById(request.getUserId()).orElse(null);
        if (user == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }
        OrderStatus orderStatus = orderStatusRepo.findById(request.getOrderStatusId()).orElse(null);
        if (orderStatus == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Order status not found", null);
        }
        Payment payment = paymentRepo.findById(request.getPaymentId()).orElse(null);
        if (payment == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Payment not found", null);
        }
        request.setUser(user);
        request.setOrderStatus(orderStatus);
        request.setPayment(payment);
        request.setCreatedAt(LocalDateTime.now());
        orderRepo.save(request);
        return new Response<>(LocalDateTime.now().toString(), 200, null, "Success");

    }

    @Override
    public Response<Map<String, Object>> getAll(int page, int pageSize) {
        Pageable pageRequest = PageRequest.of(page, pageSize);
        Page<Orders> pagedData = orderRepo.findAll(pageRequest);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("data", pagedData.getContent());
        responseData.put("currentPage", pagedData.getNumber());
        responseData.put("totalItems", pagedData.getTotalElements());
        responseData.put("totalPages", pagedData.getTotalPages());
        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Get all order success", responseData);
    }

    @Override
    public Response update(Orders request) {
        Orders orders = orderRepo.findById(request.getOrderId()).orElse(null);
        if (orders == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Order not found", null);
        }
        User user = userRepo.findById(request.getUserId()).orElse(null);
        if (user == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }
        OrderStatus orderStatus = orderStatusRepo.findById(request.getOrderStatusId()).orElse(null);
        if (orderStatus == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Order status not found", null);
        }
        Payment payment = paymentRepo.findById(request.getPaymentId()).orElse(null);
        if (payment == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Payment not found", null);
        }
        request.setUser(user);
        request.setOrderStatus(orderStatus);
        request.setPayment(payment);
        request.setCreatedAt(orders.getCreatedAt());
        request.setUpdatedAt(LocalDateTime.now());
        orderRepo.save(request);
        return new Response<>(LocalDateTime.now().toString(), 200,
                null, "Update success");
    }

    @Override
    public Response delete(int id) {
        Orders orders = orderRepo.findById(id).orElse(null);
        if (orders == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Order not found", null);
        }
        orderRepo.delete(orders);
        return new Response(LocalDateTime.now().toString(),
                200, null, "Delete success");
    }

    @Override
    public Response<Orders> getById(int id) {
        Orders orders = orderRepo.findById(id).orElse(null);
        if (orders == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Order not found", null);
        }
        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Success", orders);
    }

    @Override
    public Response updatePayment(int orderId, int paymentId) {
        Orders orders = orderRepo.findById(orderId).orElse(null);
        if (orders == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Order not found", null);
        }
        Payment payment = paymentRepo.findById(paymentId).orElse(null);
        if (payment == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Payment not found", null);
        }

        orders.setUpdatedAt(LocalDateTime.now());
        orders.setPayment(payment);

        return new Response(LocalDateTime.now().toString(),
                200, null, "Success");
    }

    @Override
    public Response<Set<OrderDetail>> getOrderDetails(int orderId) {
        Orders orders = orderRepo.findById(orderId).orElse(null);
        if (orders == null) {
            return new Response<>(LocalDateTime.now().toString(),
                    404, "Order not found", null);
        }
        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Success", orders.getOrderDetails());
    }

    @Override
    public Response<List<Object[]>> getOrders() {
        return new Response<>(LocalDateTime.now().toString(),200,null, "Success", orderRepo.getOrders());
    }
}
