package com.example.dbsbackend.services;

import com.example.dbsbackend.viewmodels.CustomerCreateViewModel;
import com.example.dbsbackend.viewmodels.CustomerUpdateViewModel;
import com.example.dbsbackend.viewmodels.CustomerViewModel;

import java.util.List;

public interface CustomerService {
    List<CustomerViewModel> getAll();
    CustomerViewModel getById(int id);
    CustomerViewModel create(CustomerCreateViewModel viewModel);
    CustomerViewModel update(int id, CustomerUpdateViewModel viewModel);
    void deleteById(int id);
}
