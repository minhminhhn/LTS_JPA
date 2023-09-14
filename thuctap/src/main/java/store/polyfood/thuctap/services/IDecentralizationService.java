package store.polyfood.thuctap.services;

import org.springframework.http.ResponseEntity;
import store.polyfood.thuctap.models.entities.Decentralization;
import store.polyfood.thuctap.models.responobject.Response;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface IDecentralizationService {
    public ResponseEntity<Response> createNew(Decentralization request);
    public ResponseEntity<Response<Map<String, Object>>> getAll(int page, int pageSize);
    public ResponseEntity<Response> update(Decentralization request);
    public ResponseEntity<Response> delete(int id);
}
