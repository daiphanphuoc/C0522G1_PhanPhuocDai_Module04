package daiphan.exercise.controller;

import daiphan.exercise.model.Smartphone;
import daiphan.exercise.service.ISmartphoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/smartphone")
@CrossOrigin("*")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService<Smartphone> smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Smartphone>> getAllSmartphonePage() {
        List<Smartphone> smartphoneList = smartphoneService.findAll();
        if (!smartphoneList.isEmpty()) {
            return new ResponseEntity<>(smartphoneList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> getSmartphone(@PathVariable int id) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if (smartphone.isPresent()) {
            return new ResponseEntity<>(smartphone.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable int id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> putSmartphone(@PathVariable int id, @RequestBody Smartphone smartphone) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(smartphone);
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(smartphone, HttpStatus.NO_CONTENT);
    }
}
