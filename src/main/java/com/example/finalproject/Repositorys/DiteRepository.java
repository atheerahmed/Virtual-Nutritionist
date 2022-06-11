package com.example.finalproject.Repositorys;

import com.example.finalproject.Models.Dite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiteRepository extends JpaRepository<Dite, Integer> {

    Dite findDiteByCalories(Double calories);
}
