package com.example.demo.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.domain.FullList;
@Repository
public interface FullListRepo extends JpaRepository<FullList, Long> {

}
