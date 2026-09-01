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

    private Map<Long , JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/sss")
    public List<JournalEntry> getAll(){
      return  new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myENTRY){
        journalEntries.put(myENTRY.getId(), myENTRY);
        return true;
    }
}
