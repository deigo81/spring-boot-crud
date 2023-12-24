package com.codesnippet.springbootcrudh2.dao;

import com.codesnippet.springbootcrudh2.entity.ComEntity;
import org.springframework.data.repository.CrudRepository;

public interface IComEntityDAO extends CrudRepository<ComEntity,Long> {
}
