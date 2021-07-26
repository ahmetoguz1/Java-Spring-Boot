package Akgun.HumanResources.DataAccess.Abstracts;

import Akgun.HumanResources.Entities.Concretes.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/*
ApplicationDao is an interface and it is used as Data Access Object interface
*/
public interface ApplicationDao extends JpaRepository<Application,Integer> {

    // getFilteredApplications used for search data in the database
    @Query(value = "SELECT * FROM applications WHERE age between ?1 AND ?2 AND military_status = ?3 AND gender = ?4", nativeQuery = true)
    List<Application> getFilteredApplications(int ageStart, int ageFinish, String militaryStatus, String gender);

}
