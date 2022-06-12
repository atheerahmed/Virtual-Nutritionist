package com.example.finalproject.Services;

import com.example.finalproject.Exptions.InvalidIdException;
import com.example.finalproject.Models.Dite;
import com.example.finalproject.Models.Requirements;
import com.example.finalproject.Repositorys.DiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class DiteService {
    private final DiteRepository diteRepository;


   public List<Dite> getDites(){
       return diteRepository.findAll();
   }

    public void addDite(Dite dite){
        diteRepository.save(dite);
    }
    public void updateDite(Dite dite , Integer id) throws InvalidIdException {
        Dite dite1 = diteRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid ID"));
        dite1.setBreakfast(dite.getBreakfast());
        dite1.setSnack1(dite.getSnack1());
        dite1.setLunch(dite.getLunch());
        dite1.setSnack2(dite.getSnack2());
        dite1.setDinner(dite.getDinner());
        dite1.setCalories(dite.getCalories());
        diteRepository.save(dite1);

    }



    public void deleteDite(Integer id){
        diteRepository.deleteById(id);
    }


}
