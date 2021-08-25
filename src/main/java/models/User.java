package models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@SelectBeforeUpdate(value = false)
@Table (name = "users")
public class User {
    @Getter
    @Setter
    @Id
    @Column( columnDefinition = "uuid", updatable = false, unique = true)
    private UUID guid;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "age")
    private int age;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    public User(){
        autos = new ArrayList<>();
    }

    public User(String name, int age) {
        this();
        this.guid = UUID.randomUUID();
        this.name = name;
        this.age = age;
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
        auto.setUser(null);
    }
}

