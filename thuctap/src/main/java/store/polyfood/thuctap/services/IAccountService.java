package store.polyfood.thuctap.services;

import org.springframework.http.ResponseEntity;
import store.polyfood.thuctap.models.entities.Account;
import store.polyfood.thuctap.models.responobject.Response;

import java.util.Map;

public interface IAccountService {
    public ResponseEntity<Response> createNew(Account request);
    public ResponseEntity<Response<Map<String, Object>>> getAll(int page, int pageSize);
    public ResponseEntity<Response> update(Account request);
    public ResponseEntity<Response> delete(int id);
}
