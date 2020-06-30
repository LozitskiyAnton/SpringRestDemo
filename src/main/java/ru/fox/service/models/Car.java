package ru.fox.service.models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "owner")
@Entity
@Table(name = "fix_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private String model;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

//    public Car(long id, String model, User owner) {
//        this.id = id;
//        this.model = model;
//        this.owner = owner;
//    }
}
