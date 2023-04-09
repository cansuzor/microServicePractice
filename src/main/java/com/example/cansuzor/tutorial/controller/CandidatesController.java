package com.example.cansuzor.tutorial.controller;

import com.example.cansuzor.tutorial.model.Candidate;
import com.example.cansuzor.tutorial.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CandidatesController {
    @Autowired
    private CandidateRepo candidateRepo;

    @RequestMapping(path= "/allCandidates", method = RequestMethod.GET)
    public String getCandidates(){
        return "Hi, this is Cansu Zor and I love kofte";
    }

    @GetMapping("/getAllCandidates")
    public ResponseEntity<List<Candidate>> getAllCandidates(){
        try{
            List<Candidate> candidateList = new ArrayList<>();
            candidateRepo.findAll().forEach(candidateList::add);
            if (candidateList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(candidateList,HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
    @GetMapping("/getCandidateById/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id){
        try {
            Optional<Candidate> candidateData = candidateRepo.findById(id);

            if (candidateData.isPresent()) {
                return new ResponseEntity<>(candidateData.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @PostMapping("/addCandidate")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate){
        try {
            Candidate candidateObj = candidateRepo.save(candidate);

            return new ResponseEntity(candidateObj, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/updateCandidateById/{id}")
    public ResponseEntity updateCandidateById(@PathVariable Long id, @RequestBody Candidate newCandidateData){
        try {
            Optional<Candidate> oldCandidateData = candidateRepo.findById(id);

            if (oldCandidateData.isPresent()) {
                Candidate updatedCandidateData = oldCandidateData.get();
                updatedCandidateData.setJobName(newCandidateData.getJobName());
                updatedCandidateData.setNickName(newCandidateData.getNickName());

                candidateRepo.save(updatedCandidateData);
                return new ResponseEntity(updatedCandidateData, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @DeleteMapping("/deleteCandidateById/{id}")
    public ResponseEntity<Object> deleteCandidate(@PathVariable Long id){
        candidateRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }




}
