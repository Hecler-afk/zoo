package kz.iitu.zoo.repository;

import kz.iitu.zoo.entity.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AnimalRepository extends JpaRepository<Zoo, Long> {
}

