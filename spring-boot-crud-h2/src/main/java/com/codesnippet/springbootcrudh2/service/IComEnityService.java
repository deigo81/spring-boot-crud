package com.codesnippet.springbootcrudh2.service;

import com.codesnippet.springbootcrudh2.entity.ComEntity;

import java.util.Optional;

public interface IComEnityService {

    Iterable<ComEntity> findAll();

    ComEntity save(ComEntity c);

    void delete(Long id);

    Optional<ComEntity> findId(Long id);
}
