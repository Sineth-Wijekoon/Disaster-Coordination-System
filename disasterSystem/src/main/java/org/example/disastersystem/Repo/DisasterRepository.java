package org.example.disastersystem.Repo;

import org.example.disastersystem.Models.Disaster;
import org.example.disastersystem.Objects.DisasterCount;
import org.example.disastersystem.Objects.RequestStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisasterRepository extends JpaRepository<Disaster,Long> {
    @Query("SELECT new org.example.disastersystem.Objects.DisasterCount(d.disasterType, COUNT(d)) FROM Disaster d GROUP BY d.disasterType")
    List<DisasterCount> countByDisasterType();

    @Query("SELECT new org.example.disastersystem.Objects.DisasterCount(d.disasterType, COUNT(d)) " +
            "FROM Disaster d " +
            "WHERE d.urgencyLevel = 'LOW' " +
            "GROUP BY d.disasterType")
    List<DisasterCount> countByDisasterTypeAndUrgencyLevelLow();

    @Query("SELECT new org.example.disastersystem.Objects.DisasterCount(d.disasterType, COUNT(d)) " +
            "FROM Disaster d " +
            "WHERE d.urgencyLevel = 'MEDIUM' " +
            "GROUP BY d.disasterType")
    List<DisasterCount> countByDisasterTypeAndUrgencyLevelMedium();

    @Query("SELECT new org.example.disastersystem.Objects.DisasterCount(d.disasterType, COUNT(d)) " +
            "FROM Disaster d " +
            "WHERE d.urgencyLevel = 'CRITICAL' " +
            "GROUP BY d.disasterType")
    List<DisasterCount> countByDisasterTypeAndUrgencyLevelHigh();

    @Query("SELECT new org.example.disastersystem.Objects.DisasterCount(d.disasterType, COUNT(d)) " +
            "FROM Disaster d " +
            "WHERE d.status = 'PENDING' " +
            "GROUP BY d.disasterType")
    List<DisasterCount> countByDisasterTypePending();


}