package kea.exam.atletikEksamen.controllers;

import kea.exam.atletikEksamen.entities.Result;
import kea.exam.atletikEksamen.services.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity<List<Result>> getResults() {
        List<Result> results = resultService.getResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResult(@PathVariable int id) {
        Result result = resultService.getResult(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        Result createdResult = resultService.createResult(result);
        return ResponseEntity.ok(createdResult);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Result>> createMultipleResults(@RequestBody List<Result> results) {
        List<Result> newResults = resultService.createMultipleResults(results);
        return new ResponseEntity<>(newResults, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> updateResult(@PathVariable int id, @RequestBody Result result) {
        Result updatedResult = resultService.updateResult(id, result);
        return ResponseEntity.ok(updatedResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable int id) {
        resultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }
}

