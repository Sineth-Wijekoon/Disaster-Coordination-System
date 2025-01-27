package org.example.disastersystem.Repo;

import org.example.disastersystem.Models.Disaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisasterRepository extends JpaRepository<Disaster,Long> {
}
