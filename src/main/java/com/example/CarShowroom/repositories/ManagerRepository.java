package com.example.CarShowroom.repositories;

import com.example.CarShowroom.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    List<Manager> findAllByOrderByNameBadgeAsc();

    Manager findManagerById(Integer managerId);

    @Query("SELECT COUNT(cm) FROM Manager m JOIN m.clientManager cm WHERE cm.client.clientStatus = 'Постоянный клиент' AND m.id = :managerId")
    int findNumberOfRegularClientsByManagerId(@Param("managerId") int managerId);
}
