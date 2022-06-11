package com.example.finalproject.Repositorys;

import com.example.finalproject.Models.Needs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedsRepository extends JpaRepository<Needs, Integer> {
}
