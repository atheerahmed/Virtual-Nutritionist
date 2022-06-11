package com.example.finalproject.Repositorys;

import com.example.finalproject.Models.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementsRepository extends JpaRepository<Requirements,Integer> {
}
