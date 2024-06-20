package kea.exam.atletikEksamen.controllers;

import kea.exam.atletikEksamen.entities.Discipline;
import kea.exam.atletikEksamen.services.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public ResponseEntity<List<Discipline>> getDisciplines() {
        List<Discipline> disciplines = disciplineService.getDisciplines();
        return ResponseEntity.ok(disciplines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discipline> getDiscipline(@PathVariable int id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        return ResponseEntity.ok(discipline);
    }

    @PostMapping
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
        Discipline createdDiscipline = disciplineService.createDiscipline(discipline);
        return ResponseEntity.ok(createdDiscipline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discipline> updateDiscipline(@PathVariable int id, @RequestBody Discipline discipline) {
        Discipline updatedDiscipline = disciplineService.updateDiscipline(id, discipline);
        return ResponseEntity.ok(updatedDiscipline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable int id) {
        disciplineService.deleteDiscipline(id);
        return ResponseEntity.noContent().build();
    }
}

