package com.example.soleProprietor.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import com.example.soleProprietor.model.Notice;

public interface NoticeRepository extends Repository<Notice, Integer> {
	
	Notice findById(int id) throws DataAccessException;
	
	List<Notice> findByOwner(int ownerId) throws DataAccessException;

	Notice save(Notice notice) throws DataAccessException;

	void delete(Notice notice) throws DataAccessException;
	
}
