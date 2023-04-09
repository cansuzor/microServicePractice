package com.example.cansuzor.tutorial.repo;

import com.example.cansuzor.tutorial.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long> {
}
