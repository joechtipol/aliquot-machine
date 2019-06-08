package fr.ych.userstory.primes_portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.ych.userstory.primes_portal.model.AliquotNumber;
import fr.ych.userstory.primes_portal.service.AliquotService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/api/aliquot"})
//@RequestMapping({"/users"})
public class AliquotController {

    @Autowired
    private AliquotService aliquotService;
    


    @GetMapping(path = {"/{id}"})
    public AliquotNumber findOne(@PathVariable("id") int id){
        return aliquotService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public AliquotNumber update(@PathVariable("id") long id, @RequestBody AliquotNumber account){
        account.setNumber(id);
        return aliquotService.update(account);
    }
    
    @GetMapping
    public List<AliquotNumber> findAll(){
        return aliquotService.findAll();
    }
}
