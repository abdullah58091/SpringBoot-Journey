package com.example.myfirstProject.controller;

import com.example.myfirstProject.entity.JournalEntry;
import com.example.myfirstProject.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public JournalEntry createEntry(@RequestBody JournalEntry myENTRY) {
        journalEntryService.saveEntry(myENTRY);
        return myENTRY;
    }

    @GetMapping("/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/{id}")
    public JournalEntry updateJournalEntryById(
            @PathVariable ObjectId id,
            @RequestBody JournalEntry newEntry) {

        JournalEntry old = journalEntryService.findById(id).orElse(null);

        if (old != null) {
            if (newEntry.getTitle() != null && !newEntry.getTitle().isBlank()) {
                old.setTitle(newEntry.getTitle());
            }

            if (newEntry.getContent() != null && !newEntry.getContent().isBlank()) {
                old.setContent(newEntry.getContent());
            }

            journalEntryService.saveEntry(old);
        }

        return old;
    }
}
