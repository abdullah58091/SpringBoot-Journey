package com.example.myfirstProject.service;

import com.example.myfirstProject.entity.JournalEntry;
import com.example.myfirstProject.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {




    @Autowired
    private JournalEntryRepository JournalEntryRepository;

    public void  saveEntry(JournalEntry journalEntry){
        JournalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return JournalEntryRepository.findAll();
    }
    public Optional <JournalEntry> findById(Object id){
        return  JournalEntryRepository.findById(id);
    }
    public  void  deleteById(Object id){
        JournalEntryRepository.deleteById(id);
    }
}




//controller  ---> service  ---> repository