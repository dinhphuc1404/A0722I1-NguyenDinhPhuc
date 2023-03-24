package com.example.sping_boot.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findALl();
    Optional<T> findById(Long id);
    void save(T t);
    void remove (Long id);
}
