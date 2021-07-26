package Akgun.HumanResources.API.Controllers;


import Akgun.HumanResources.Business.Abstracts.ApplicationService;
import Akgun.HumanResources.Entities.Concretes.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")

/*
It is a controller class for API requests
*/
public class ApplicationController {
    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

/*
    Get all Applications from database
*/
    @GetMapping("/applications")
    public List<Application> getAll()
    {
        return this.applicationService.getAllApplications();
    }

    /*
     Get request from user and search it in database if it found return it as list of Application object
    */
    @RequestMapping(value = "/applications/search", method = RequestMethod.GET)
    public List<Application> participants(@RequestParam Map<String,String> q) {

        boolean age = false;
        boolean military = false;
        boolean gender = false;

        if(q.containsKey("ageStart"))
        {
            age = true;
            //query = query.concat(" AND age between " + q.get("ageStart") + " AND " + q.get("ageFinish"));
        }
        if(q.containsKey("militaryStatus")) {
            military = true;
            //query = query.concat(" AND " + "military_status = " + "'" + q.get("militaryStatus") + "'");
        }
        if(q.containsKey("gender")) {
            gender = true;
            //query = query.concat(" AND " + "gender = " + "'" + q.get("gender") + "'");
        }

        if(age && military && gender) {
            String qq = (Integer.parseInt(q.get("ageStart")) + Integer.parseInt(q.get("ageFinish")) + q.get("militaryStatus").toLowerCase(Locale.ROOT)+  q.get("gender").toLowerCase(Locale.ROOT));

            return this.applicationService.getFilteredApplications(Integer.parseInt(q.get("ageStart")), Integer.parseInt(q.get("ageFinish")), q.get("militaryStatus"), q.get("gender"));
        }

        return null;
    }

    /*
        Get request from user as Application object and insert it values to database
    */
    @PostMapping("/addApplication")
    public Application addApplication(@RequestBody Application app){

        return this.applicationService.addApplication(app);

    }


}
