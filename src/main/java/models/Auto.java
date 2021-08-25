package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "autos")
public class Auto {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Setter
    @ToString.Include
    @Column(name = "model")
    private String model;

    @Getter
    @Setter
    @ToString.Include
    @Column(name = "color")
    private String color;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {
    }

    public Auto(String model, String color) {
        this();
        this.model = model;
        this.color = color;
    }
}
