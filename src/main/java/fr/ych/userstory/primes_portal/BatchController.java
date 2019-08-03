package fr.ych.userstory.primes_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ych.userstory.primes_portal.service.BatchComputeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/batch/aliquot"})
//@RequestMapping({"/users"})
public class BatchController {


    @Autowired
    private BatchComputeService batchComputeService;
    


    @GetMapping(path = {"/{id}"})
    public void batch(@PathVariable("id") int id){
         batchComputeService.startBatchComputeAliquot(id, id+100000);
    }

}
