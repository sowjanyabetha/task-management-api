package com.sowjanyabetha.taskmanagementapi.repository;

import com.sowjanyabetha.taskmanagementapi.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
