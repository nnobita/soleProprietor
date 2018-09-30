package com.example.soleProprietor.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.soleProprietor.model.Owner;

public interface OwnerService {
    Owner create(Owner user) throws DataAccessException;
    Owner delete(int id) throws DataAccessException;
    List<Owner> findAll() throws DataAccessException;
    List<Owner> findByStatus(int status) throws DataAccessException;
    Owner findById(int id) throws DataAccessException;
    Owner update(Owner user) throws DataAccessException;
}
