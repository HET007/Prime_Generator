package com.primRest.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.primRest.entities.PrimeSet;
@Service
public interface PrimeDao extends JpaRepository<PrimeSet, String> {

}