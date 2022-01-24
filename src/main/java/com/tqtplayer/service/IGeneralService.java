package com.tqtplayer.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T>{
    List<T> findAll();

    Optional<T> findById(long id);

    T getById(long id);

    T save(T t);

    void remove(long id);
 }
