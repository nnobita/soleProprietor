package com.example.soleProprietor.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.soleProprietor.model.Notice;

public interface NoticeService {
    Notice create(Notice notice) throws DataAccessException;
    Notice delete(int id) throws DataAccessException;
    List<Notice> findByOwner(int ownerId) throws DataAccessException;
    Notice findById(int id) throws DataAccessException;
    Notice update(Notice notice) throws DataAccessException;

}
