package Akgun.HumanResources.Entities.Concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "applications")
@AllArgsConstructor
@NoArgsConstructor
// Application Object
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationID")
    private int applicationID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Age")
    private int age;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Education")
    private String education;

    @Column(name = "City")
    private String city;

    @Column(name = "District")
    private String district;

    @Column(name = "military_status")
    private String militaryStatus;

    //kendime not, değişken adı nasıl ise select yaparken json o şekilde oluşuyor

    @Column(name = "programming_languages")
    private String programmingLanguages;

    @Column(name = "Certificates")
    private String certificates;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;



}
