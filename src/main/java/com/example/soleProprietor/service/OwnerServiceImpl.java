package com.example.soleProprietor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soleProprietor.model.Notice;
import com.example.soleProprietor.model.Owner;
import com.example.soleProprietor.repository.NoticeRepository;
import com.example.soleProprietor.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository repository;
    
    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public Owner create(Owner owner) {
        return repository.save(owner);
    }

    @Override
    public Owner delete(int id) {
        Owner owner = findById(id);
        if(owner != null){
            repository.delete(owner);
            //noticeRepository.deleteByOwner(id);
        }
        return owner;
    }

    @Override
    public List<Owner> findAll() {
        return repository.findAll();
    }
    
    @Override
    public List<Owner> findByStatus(int status) {
        return repository.findByStatus(status);
    }
    
    @Override
    public Owner findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Owner update(Owner owner) {
    	return repository.save(owner);
    }
}
