package com.example.dbsbackend.services;

import com.example.dbsbackend.entities.Customer;
import com.example.dbsbackend.exceptions.RecordNotFoundException;
import com.example.dbsbackend.repositories.CustomerRepository;
import com.example.dbsbackend.viewmodels.CustomerCreateViewModel;
import com.example.dbsbackend.viewmodels.CustomerUpdateViewModel;
import com.example.dbsbackend.viewmodels.CustomerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImplementation(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerViewModel> getAll() {
        return repository.findAll()
                .stream()
                .map(c -> toViewModel(c))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerViewModel getById(int id) {
        return toViewModel(getEntityById(id));
    }

    @Override
    public CustomerViewModel create(CustomerCreateViewModel viewModel) {
        return toViewModel(repository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public CustomerViewModel update(int id, CustomerUpdateViewModel viewModel) {
        var entityDb = getEntityById(id);
        var entityUpdated = toEntity(entityDb, viewModel);
        repository.saveAndFlush(entityUpdated);
        return toViewModel(entityUpdated);

//        return toViewModel(repository.saveAndFlush(toEntity(getEntityById(id), viewModel)));
    }

    @Override
    public void deleteById(int id) {
        repository.delete(getEntityById(id));
    }

    private Customer getEntityById(int id) {
        return repository.findById(id)
                .orElseThrow(
                        () ->
                                new RecordNotFoundException(
                                        String.format(
                                                "Customer with id: %d is not found", id
                                        )
                                )
                );
    }

    private CustomerViewModel toViewModel(Customer entity) {
        var viewModel = new CustomerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private Customer toEntity(CustomerCreateViewModel viewModel) {
        var entity = new Customer();
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }

    private Customer toEntity(Customer entityDb, CustomerUpdateViewModel viewModel) {
        BeanUtils.copyProperties(viewModel, entityDb);
        return entityDb;
    }
}
