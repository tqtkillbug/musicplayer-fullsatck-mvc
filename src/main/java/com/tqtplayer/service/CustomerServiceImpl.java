package com.tqtplayer.service;

import com.tqtplayer.model.User;
import com.tqtplayer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public User save(User user) {
        return customerRepository.save(user);
    }
}
