package com.example.soleProprietor.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.stereotype.Service;

import com.example.soleProprietor.model.Notice;
import com.example.soleProprietor.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeRepository repository;

    @Override
    public Notice create(Notice owner) {
        return repository.save(owner);
    }

    @Override
    public Notice delete(int id) {
        Notice notice = findById(id);
        if(notice != null){
            repository.delete(notice);
        }
        return notice;
    }

    @Override
    public List<Notice> findByOwner(int ownerId) {
        List<Notice> sortedNotices = repository.findByOwnerId(ownerId);
        PropertyComparator.sort(sortedNotices, new MutableSortDefinition("lastUpdate", true, true));
        return Collections.unmodifiableList(sortedNotices);
    }


    @Override
    public Notice findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Notice update(Notice notice) {
    	return repository.save(notice);
    }

}
