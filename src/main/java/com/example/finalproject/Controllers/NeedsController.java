package com.example.finalproject.Controllers;

import com.example.finalproject.DTO.API;
import com.example.finalproject.Models.Needs;
import com.example.finalproject.Services.NeedsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/result")
public class NeedsController {
    private final NeedsService needsService;
    Logger logger= LoggerFactory.getLogger(NeedsController.class);
    @GetMapping("admin")
    public ResponseEntity<?> getResults(){
        logger.info("Request to get Results");
        return ResponseEntity.status(200).body(needsService.getResults());
    }
    @PostMapping("/{reqId}")
    public ResponseEntity<API> addNeeds(@PathVariable Integer reqId){
        logger.info("Request to add Needs");
        needsService.addResult(reqId);
        return ResponseEntity.status(200).body(new API("Added new Result",200));
    }
    @PostMapping("addite/{needId}")
    public ResponseEntity<API> addDite(@PathVariable Integer needId){
        logger.info("Request to add Dite to User");
        needsService.addDite(needId);
        return ResponseEntity.status(200).body(new API("Added new Dite",200));
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<API> deleteNeeds(@PathVariable Integer id){
        logger.info("Request to delete Needs");
        needsService.deleteResult(id);
        return ResponseEntity.status(200).body(new API("Deleted Result",200));
    }

}
