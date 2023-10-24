package com.example.dbsbackend.apis;

import com.example.dbsbackend.services.CustomerService;
import com.example.dbsbackend.viewmodels.CustomerCreateViewModel;
import com.example.dbsbackend.viewmodels.CustomerUpdateViewModel;
import com.example.dbsbackend.viewmodels.CustomerViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CustomerApi {
    private final CustomerService service;

    public CustomerApi(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerViewModel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerViewModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerViewModel> create(@RequestBody CustomerCreateViewModel viewModel) {
        return ResponseEntity.ok(service.create(viewModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerViewModel> update(@PathVariable int id, @RequestBody CustomerUpdateViewModel viewModel) {
        return ResponseEntity.ok(service.update(id, viewModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
