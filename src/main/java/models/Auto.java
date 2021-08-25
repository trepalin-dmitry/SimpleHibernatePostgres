package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "autos")
public class Auto {
    @Getter
    @Setter
    @Id
    @Column( columnDefinition = "uuid", updatable = false, unique = true)
    private UUID guid;

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
        this.guid = UUID.randomUUID();
        this.model = model;
        this.color = color;
    }
}
