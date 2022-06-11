package com.example.finalproject.Services;

import com.example.finalproject.Exptions.InvalidIdException;
import com.example.finalproject.Models.Dite;
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
        Dite dite1=getDiteById(id);
        diteRepository.save(dite);
    }

    public Dite getDiteById(Integer id) throws InvalidIdException {
        return diteRepository.findById(id).orElseThrow(() -> new InvalidIdException("Invalid ID"));
    }

    public void deleteDite(Integer id){
        diteRepository.deleteById(id);
    }


}
