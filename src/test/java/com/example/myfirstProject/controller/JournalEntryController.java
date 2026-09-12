package com.example.myfirstProject.controller;

import com.example.myfirstProject.entity.JournalEntry;
import com.example.myfirstProject.entity.User;
import com.example.myfirstProject.service.JournalEntryService;
import com.example.myfirstProject.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;


    // Get all journal entries of user
    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(
            @PathVariable("userName") String userName) {

        User user = userService.findByUserName(userName);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<JournalEntry> all = user.getJournalEntries();

        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/test")
    public String test() {
        return "Journal Controller is working";
    }


    // Create journal entry
    @PostMapping("/{userName}")
    public ResponseEntity<JournalEntry> createEntry(
            @RequestBody JournalEntry myEntry,
            @PathVariable("userName") String userName) {

        try {

            journalEntryService.saveEntry(myEntry, userName);

            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // Delete journal entry
    @DeleteMapping("/id/{userName}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(
            @PathVariable("myId") ObjectId myId,
            @PathVariable("userName") String userName) {

        journalEntryService.deleteById(myId, userName);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // Update journal entry
    @PutMapping("/id/{userName}/{myId}")
    public ResponseEntity<?> updateJournalById(
            @PathVariable("myId") ObjectId myId,
            @RequestBody JournalEntry newEntry,
            @PathVariable("userName") String userName) {

        JournalEntry old =
                journalEntryService.findById(myId).orElse(null);

        if (old != null) {

            if (newEntry.getTitle() != null
                    && !newEntry.getTitle().equals(" ")) {

                old.setTitle(newEntry.getTitle());
            }

            if (newEntry.getContent() != null
                    && !newEntry.getContent().equals(" ")) {

                old.setContent(newEntry.getContent());
            }

            journalEntryService.saveEntry(old);

            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}