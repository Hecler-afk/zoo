package kz.iitu.zoo.service;




import kz.iitu.zoo.entity.Zoo;
import kz.iitu.zoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZooService {

    private final AnimalRepository animalRepository;

    @Autowired
    public ZooService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // Получить список всех животных
    public List<Zoo> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Получить животное по id
    public Optional<Zoo> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    // Добавить новое животное
    public Zoo addAnimal(Zoo zoo) {
        return animalRepository.save(zoo);
    }

    // Обновить информацию о животном
    public Zoo updateAnimal(Long id, Zoo animal) {
        if (animalRepository.existsById(id)) {
            animal.setId(id);
            return animalRepository.save(animal);
        }
        return null;
    }

    // Удалить животное
    public boolean deleteAnimal(Long id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

