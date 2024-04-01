package com.sowjanyabetha.taskmanagementapi.service;

import com.sowjanyabetha.taskmanagementapi.model.Task;
import com.sowjanyabetha.taskmanagementapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task){
       return taskRepository.save(task);
    }

    public Task updateTask(Task task){
        Task existingTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Task not found with id %s", task.getId())));
        existingTask.setTaskTitle(task.getTaskTitle());
        existingTask.setTaskDescription(task.getTaskDescription());
        existingTask.setTaskStatus(task.getTaskStatus());

        return taskRepository.save(existingTask);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(String id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Task not found with id %s", id)));
    }
    public void deleteTask(String id){
        taskRepository.deleteById(id);
    }
}
