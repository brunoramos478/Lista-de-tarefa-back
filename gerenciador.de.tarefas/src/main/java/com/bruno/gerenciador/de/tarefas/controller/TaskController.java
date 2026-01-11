package com.bruno.gerenciador.de.tarefas.controller;

import com.bruno.gerenciador.de.tarefas.entity.TaskEntity;
import com.bruno.gerenciador.de.tarefas.services.TaskServices;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskServices taskServices;

    public  TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @PostMapping("/criartarefa")
    public ResponseEntity<String> criarNovaTarefa(@RequestBody TaskEntity enviarTarefa) {
        taskServices.criarTarefa(enviarTarefa);

        return ResponseEntity.ok("Criado com sucesso " + HttpStatusCode.valueOf(200));
    }

    @PutMapping("/alterartarefa")
    public ResponseEntity<String> atualizarTarefa(@RequestBody TaskEntity enviarTarefaAtualizada) {
        taskServices.criarTarefa(enviarTarefaAtualizada);
        return ResponseEntity.ok("Atualizado com sucesso " + HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deletartarefa/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id) {
        taskServices.delteById(id);
        return ResponseEntity.ok("Deletado com sucesso " + HttpStatusCode.valueOf(200));
    }

    @GetMapping("listartarefa")
    public ResponseEntity<List<TaskEntity>> listarTarefa(@RequestParam (required = false)Boolean concluida) {
        List<TaskEntity> todas = taskServices.findAll();

        List<TaskEntity> filtro = (concluida == null)
                ? todas
                : todas.stream()
                       .filter( taskEntity -> Boolean.valueOf(taskEntity.isCompleted()).equals(concluida))
                       .collect(Collectors.toList());
        return ResponseEntity.ok(filtro);
    }
}
