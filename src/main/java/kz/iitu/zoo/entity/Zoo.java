package kz.iitu.zoo.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Zoo {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String type;
    private int age;

}
