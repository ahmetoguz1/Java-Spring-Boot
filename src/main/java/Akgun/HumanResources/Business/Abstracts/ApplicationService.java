package Akgun.HumanResources.Business.Abstracts;

import Akgun.HumanResources.Entities.Concretes.Application;

import java.util.List;

/*
Interface for Application Service
*/
public interface ApplicationService {
    List<Application> getAllApplications();
    Application addApplication(Application app);
    // TODO: If requested different filtering it will be used
   /* List<Application> getFilteredApplications(int a, int b);
    List<Application> getFilteredApplications(String militaryStatus);
    List<Application> getFilteredApplications(int ageStart, int ageFinish, String militaryStatus);*/
    List<Application> getFilteredApplications(int ageStart, int ageFinish, String militaryStatus,String gender);

}
