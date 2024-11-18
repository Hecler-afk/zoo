package kz.iitu.zoo.controller;


import kz.iitu.zoo.entity.Zoo;
import kz.iitu.zoo.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class ZooController {

    private final ZooService zooService;

    @Autowired
    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    // Получить список всех животных
    @GetMapping
    public List<Zoo> getAllAnimals() {
        return zooService.getAllAnimals();
    }

    // Получить информацию о конкретном животном по id
    @GetMapping("/{id}")
    public ResponseEntity<Zoo> getAnimalById(@PathVariable Long id) {
        Optional<Zoo> animal = zooService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Добавить новое животное
    @PostMapping
    public ResponseEntity<Zoo> addAnimal(@RequestBody Zoo animal) {
        Zoo createdAnimal = zooService.addAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
    }

    // Обновить информацию о животном
    @PutMapping("/{id}")
    public ResponseEntity<Zoo> updateAnimal(@PathVariable Long id, @RequestBody Zoo animal) {
        Zoo updatedAnimal = zooService.updateAnimal(id, animal);
        return updatedAnimal != null ? ResponseEntity.ok(updatedAnimal) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Удалить животное
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        boolean isDeleted = zooService.deleteAnimal(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

