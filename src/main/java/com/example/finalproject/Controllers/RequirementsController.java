package com.example.finalproject.Controllers;

import com.example.finalproject.DTO.API;
import com.example.finalproject.Exptions.InvalidIdException;
import com.example.finalproject.Models.Requirements;
import com.example.finalproject.Services.RequirementsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/requirements")
public class RequirementsController {
    private final RequirementsService requirementsService;
    Logger logger= LoggerFactory.getLogger(RequirementsController.class);

    @GetMapping("/admin")
    public ResponseEntity<List<Requirements>> getRequirements(){
        logger.info("Request to get  all requirements");
        return ResponseEntity.status(200).body(requirementsService.getNeeds());
    }
    @PostMapping("/admin")
    public ResponseEntity<API> addRequirements(@RequestBody @Valid Requirements requirements){
        logger.info("Request to add Needs");
        requirementsService.addNeeds(requirements);
        return ResponseEntity.status(200).body(new API("Added new Requirement",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity<API> updateRequirements(@RequestBody @Valid Requirements requirements, @PathVariable Integer id) throws InvalidIdException {
        logger.info("Request to update Needs");
        requirementsService.updateNeeds(requirements,id);
        return ResponseEntity.status(200).body(new API("Updated the requirements",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<API> deleteRequirements(@PathVariable Integer id){
        logger.info("Request to delete Needs");
        requirementsService.deleteNeeds(id);
        return ResponseEntity.status(200).body(new API("Deleted the requirement",200));
    }


}
