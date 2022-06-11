package com.example.finalproject.Controllers;

import com.example.finalproject.DTO.API;
import com.example.finalproject.Exptions.InvalidIdException;
import com.example.finalproject.Models.Dite;
import com.example.finalproject.Services.DiteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/dite")
public class DiteController {
    private final DiteService diteService;
    Logger logger= LoggerFactory.getLogger(DiteController.class);
    @GetMapping
    public ResponseEntity<List<Dite>> getDites(){
        logger.info("Request to get Dite");
        return ResponseEntity.status(200).body(diteService.getDites());
    }
    @PostMapping
    public ResponseEntity<API> addDite(@RequestBody @Valid Dite dite){
        logger.info("Request to add Dite");
        diteService.addDite(dite);
        return ResponseEntity.status(200).body(new API("Added new Dite",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity<API> updateDite(@RequestBody @Valid Dite dite, @PathVariable Integer id) throws InvalidIdException {
        logger.info("Request to update Dite");
        diteService.updateDite(dite,id);
        return ResponseEntity.status(200).body(new API("Updated Dite",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<API> deleteDite(@PathVariable Integer id){
        logger.info("Request to delete Dite");
        diteService.deleteDite(id);
        return ResponseEntity.status(200).body(new API("Deleted Dite",200));
    }

}
