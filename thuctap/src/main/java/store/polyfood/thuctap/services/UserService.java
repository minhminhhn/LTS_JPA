package store.polyfood.thuctap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import store.polyfood.thuctap.models.entities.*;
import store.polyfood.thuctap.models.responobject.Response;
import store.polyfood.thuctap.repositories.AccountRepo;
import store.polyfood.thuctap.repositories.UserRepo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Response createNew(User request) {
        Account account = accountRepo.findById(request.getAccountId()).orElse(null);
        if (account == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "Account not found", null);
        }
        request.setAccount(account);
        request.setCreatedAt(LocalDateTime.now());
        userRepo.save(request);
        return new Response<>(LocalDateTime.now().toString(), 200, null ,"Success");
    }

    @Override
    public Response<Map<String, Object>> getAll(int page, int pageSize) {
        Pageable pageRequest = PageRequest.of(page, pageSize);
        Page<User> pagedData = userRepo.findAll(pageRequest);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("data", pagedData.getContent());
        responseData.put("currentPage", pagedData.getNumber());
        responseData.put("totalItems", pagedData.getTotalElements());
        responseData.put("totalPages", pagedData.getTotalPages());
        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Get all user success", responseData);
    }

    @Override
    public Response update(User request) {
        User user = userRepo.findById(request.getUserId()).orElse(null);
        if (user == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }
        Account account = accountRepo.findById(request.getAccountId()).orElse(null);
        if (account == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "Account not found", null);
        }
        request.setAccount(account);
        request.setCreatedAt(user.getCreatedAt());
        request.setUpdatedAt(LocalDateTime.now());
        userRepo.save(request);
        return new Response(LocalDateTime.now().toString(),
                200, null, "Update success");
    }

    @Override
    public Response delete(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }
        userRepo.delete(user);
        return new Response(LocalDateTime.now().toString(),
                200, null, "Delete success");
    }

    @Override
    public Response<User> getById(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }
        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Success", user);
    }

    @Override
    public Response<User> findByName(String fullName) {
        User user = userRepo.findByFullName(fullName);
        if (user == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }
        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Success", user);
    }

    @Override
    public Response<Set<ProductReview>> getProductReview(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }

        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Success", user.getProductReviews());
    }

    @Override
    public Response<Map<String, Double>> getTotalPriceInCart(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return  new Response<>(LocalDateTime.now().toString(),
                    404, "User not found", null);
        }
        Double price = (double) 0;
        for(Carts cart : user.getCarts()) {
            for(CartItem item : cart.getCartItems()) {
                price = item.getQuantity() * (item.getProduct().getPrice() * (100 - item.getProduct().getDiscount())/100);
            }
        }
        Map<String, Double> totalPrice = new HashMap<>();
        totalPrice.put("totalPrice", price);
        return new Response<>(LocalDateTime.now().toString(),
                200, null, "Success", totalPrice);
    }
}
