package store.polyfood.thuctap.services;

import org.springframework.http.ResponseEntity;
import store.polyfood.thuctap.models.entities.Carts;
import store.polyfood.thuctap.models.responobject.Response;

import java.util.Map;

public interface ICartService {
    public Response createNew(Carts request);
    public Response<Map<String, Object>> getAll(int page, int pageSize);
    public Response update(Carts request);
    public Response delete(int id);
    public Response<Carts> getById(int id);
}
