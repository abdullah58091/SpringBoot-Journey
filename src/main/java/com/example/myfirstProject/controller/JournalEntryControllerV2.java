package com.example.myfirstProject.controller;


import com.example.myfirstProject.entity.JournalEntry;
import com.example.myfirstProject.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/sss")
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public  createEntry(@RequestBody JournalEntry myENTRY) {
        myENTRY.setDate(LocalDateTime);
        journalEntryService.saveEntry(myENTRY);
        return myENTRY;
    }

    @GetMapping("/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
         return JournalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/{myId}")
    public  boolean JournalEntry deleteJournalEntryById(@PathVariable ObjectId myId) {
        JournalEntryService.deleteById(myId);
        return  true;
    }

    @PutMapping("/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if (old != null){
            old.setTitle(newEntry.getTitle() != null && newEntry.getTitle().equals(" ") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && newEntry.getContent().equals(" ") ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}
