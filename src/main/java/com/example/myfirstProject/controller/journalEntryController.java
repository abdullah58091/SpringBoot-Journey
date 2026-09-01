package com.example.myfirstProject.controller;


import com.example.myfirstProject.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/journal")
public class journalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/sss")
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myENTRY) {
        journalEntries.put(myENTRY.getId(), myENTRY);
        return true;
    }

    @GetMapping("/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return journalEntries.remove(myId);
    }

    @PutMapping("/{id}")
    public JournalEntry updateJournalEntryById(
            @PathVariable Long id,
            @RequestBody JournalEntry myEntry) {

        journalEntries.put(id, myEntry);
        return myEntry;
    }
}