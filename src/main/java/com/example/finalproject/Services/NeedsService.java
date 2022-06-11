package com.example.finalproject.Services;

import com.example.finalproject.Models.Dite;
import com.example.finalproject.Models.Needs;
import com.example.finalproject.Models.Requirements;
import com.example.finalproject.Repositorys.DiteRepository;
import com.example.finalproject.Repositorys.NeedsRepository;
import com.example.finalproject.Repositorys.RequirementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class NeedsService {
    private final NeedsRepository needsRepository;
    private final RequirementsRepository requirementsRepository;
    private final DiteRepository diteRepository;

    public List<Needs> getResults(){
        return needsRepository.findAll();
    }

    public void addResult(Integer needId){
      Requirements requirements = requirementsRepository.findById(needId).get();
        Needs needs =new Needs();
        //Mass
        Double needsHeight= requirements.getHeight()/100;
        Double height= needsHeight*needsHeight;
        Double BMI= requirements.getWeight()/height;
        needs.setMass(BMI);

        //Calorie
        Double weight = requirements.getWeight();
        Double ABW;
        Double bee;
        if(BMI <18.5 || BMI>25){
            if (requirements.getGender().equals("male")){
                weight=50+(0.91*(needsHeight-152.4));
            }
            else{
                weight=45.5+(0.91*(needsHeight-152.4));
            }
        }if (BMI > 30 ){
            weight= weight +.4*(requirements.getWeight()-weight);
        }

        if (requirements.getGender().equals("male")){
            bee=66.5*(13.8* weight)+(5* requirements.getHeight())-(4.7* requirements.getAge())*1.1;
            if (requirements.getActive().equals("Active"))
                bee*=1.13;
            if (requirements.getActive().equals("Not Active"))
                bee*=1.12;
            if (requirements.getActive().equals("Very Active"))
                bee*=1.15;
        }else {
            bee=66.1*(9.1* weight)+(1.8* requirements.getHeight())-(4.7* requirements.getAge())*1.1;
            if (requirements.getActive().equals("Active"))
                bee*=1.13;
            if (requirements.getActive().equals("Not Active"))
                bee*=1.12;
            if (requirements.getActive().equals("Very Active"))
                bee*=1.15;
        }
        needs.setCalories(bee);

        //Other Needs
        Double carbo=(bee/4)*.6;
        Double protein=(bee/4)*.2;
        Double fat=(bee/9)*.2;
        needs.setCarbohydrates(carbo);
        needs.setProtein(protein);
        needs.setFat(fat);
        needs.setRequirements(requirements);
//        results.setDite(null);

        requirements.setNeeds(needs);
        needsRepository.save(needs);

    }

    public void deleteResult(Integer id){
        needsRepository.deleteById(id);
    }

    public void addDite(Integer resultId){
        Needs needs = needsRepository.findById(resultId).get();
        Dite dite= diteRepository.findDiteByCalories(needs.getCalories());
        needs.setDite(dite);
        needsRepository.save(needs);
    }

}
