package Akgun.HumanResources.Business.Concretes;

import Akgun.HumanResources.Business.Abstracts.ApplicationService;
import Akgun.HumanResources.Entities.Concretes.Application;
import Akgun.HumanResources.DataAccess.Abstracts.ApplicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
ApplicationManager class is used as Service to reach it from API.
Basically this class is an adapter between API and Data Access Layer
*/
public class ApplicationManager implements ApplicationService {
    private ApplicationDao applicationDao;

    @Autowired
    public ApplicationManager(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }



    @Override
    public List<Application> getAllApplications() {

        return (List<Application>) applicationDao.findAll();
    }

    @Override
    public Application addApplication(Application app) {
        return applicationDao.save(app);
    }

    @Override
    public List<Application> getFilteredApplications(int ageStart, int ageFinish, String militaryStatus, String gender) {
        return applicationDao.getFilteredApplications(ageStart,ageFinish,militaryStatus,gender);
    }

}
