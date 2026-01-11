package com.bruno.gerenciador.de.tarefas.services;

import com.bruno.gerenciador.de.tarefas.repository.TaskRepository;
import com.bruno.gerenciador.de.tarefas.entity.TaskEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServices {

private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public TaskEntity criarTarefa(TaskEntity novaTarefa) {
        return this.taskRepository.save(novaTarefa);
    }

    public List<TaskEntity> findAll() {
        return this.taskRepository.findAll();
    }

    public void delteById(Long id) {
        this.taskRepository.deleteById(id);

    }
}
