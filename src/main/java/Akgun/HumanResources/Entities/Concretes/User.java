package Akgun.HumanResources.Entities.Concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER", schema = "public")
// User Object
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String userName;
    private String password;
    private boolean active;
    private String roles;

}
