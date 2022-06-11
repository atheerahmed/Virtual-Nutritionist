package com.example.finalproject.Services;

import com.example.finalproject.DTO.RequirementsDTO;
import com.example.finalproject.Exptions.InvalidIdException;
import com.example.finalproject.Models.MyUsers;
import com.example.finalproject.Models.Requirements;
import com.example.finalproject.Repositorys.MyUsersRepository;
import com.example.finalproject.Repositorys.RequirementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUsersService {
    private final MyUsersRepository myUsersRepository;
    private final RequirementsRepository requirementsRepository;
    private final RequirementsService requirementsService;

    public List<MyUsers> getUsers() {
        return myUsersRepository.findAll();
    }

    public void addUser(MyUsers user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        myUsersRepository.save(user);
    }

    public void updateUser(MyUsers user, Integer id) throws InvalidIdException {
        MyUsers user1 = getUserById(id);
        myUsersRepository.save(user1);
    }

    public MyUsers getUserById(Integer id) throws InvalidIdException {
        return myUsersRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid ID"));
    }

    public void deleteUser(Integer id) {
        myUsersRepository.deleteById(id);
    }


    public void addNeeds(RequirementsDTO requirementsDTO) throws InvalidIdException {
        MyUsers user = myUsersRepository.findById(requirementsDTO.getUserId()).orElseThrow(
                () -> new InvalidIdException("Invalid ID"));

        Requirements requirements = new Requirements(null, requirementsDTO.getAge(),
                requirementsDTO.getGender(), requirementsDTO.getHeight(), requirementsDTO.getWeight(), requirementsDTO.getActive(),user,null);

        user.setRequirements(requirements);
        requirementsRepository.save(requirements);
    }
}