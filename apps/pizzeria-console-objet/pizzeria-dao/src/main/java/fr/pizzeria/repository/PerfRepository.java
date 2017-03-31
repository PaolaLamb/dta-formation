package fr.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;

public interface PerfRepository extends JpaRepository<Performance, Integer> {

}
