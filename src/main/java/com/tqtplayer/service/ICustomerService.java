package com.tqtplayer.service;

import com.tqtplayer.model.User;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<User>{
    Optional<User> findByEmail(String email);
}
