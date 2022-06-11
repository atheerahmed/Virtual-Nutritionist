package com.example.finalproject.Services;

import com.example.finalproject.Exptions.InvalidIdException;
import com.example.finalproject.Models.Requirements;
import com.example.finalproject.Repositorys.NeedsRepository;
import com.example.finalproject.Repositorys.RequirementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequirementsService {
    private final RequirementsRepository requirementsRepository;
    private final NeedsRepository needsRepository;

    public List<Requirements> getNeeds(){
        return requirementsRepository.findAll();
    }

    public void addNeeds(Requirements requirements){
        requirementsRepository.save(requirements);
    }
    public void updateNeeds(Requirements requirements, Integer id) throws InvalidIdException{
       Requirements requirements1 = requirementsRepository.findById(id)
               .orElseThrow(
                       () -> new InvalidIdException("Invalid ID"));
       requirements1.setAge(requirements.getAge());
       requirements1.setHeight(requirements.getHeight());
       requirements1.setWeight(requirements.getWeight());
       requirements1.setGender(requirements.getGender());
       requirementsRepository.save(requirements1);
    }

    public void deleteNeeds(Integer id){
        requirementsRepository.deleteById(id);
    }

    public Requirements getNeedsById(Integer id){
       return requirementsRepository.findById(id).get();
    }






}
