package com.sofka.project.TDF.repository;

import com.sofka.project.TDF.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends JpaRepository<Cyclist, Long> {
}
