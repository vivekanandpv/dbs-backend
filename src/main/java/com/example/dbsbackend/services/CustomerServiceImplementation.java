package com.example.dbsbackend.services;

import com.example.dbsbackend.repositories.CustomerRepository;
import com.example.dbsbackend.viewmodels.CustomerCreateViewModel;
import com.example.dbsbackend.viewmodels.CustomerUpdateViewModel;
import com.example.dbsbackend.viewmodels.CustomerViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImplementation(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerViewModel> getAll() {
        return null;
    }

    @Override
    public CustomerViewModel getById(int id) {
        return null;
    }

    @Override
    public CustomerViewModel create(CustomerCreateViewModel viewModel) {
        return null;
    }

    @Override
    public CustomerViewModel update(int id, CustomerUpdateViewModel viewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
