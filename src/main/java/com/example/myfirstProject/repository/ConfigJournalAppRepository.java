package com.example.myfirstProject.repository;

import com.example.myfirstProject.entity.ConfigJournalAppEntity;
import com.example.myfirstProject.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {
}
