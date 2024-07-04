package com.example.demo.introduction.repository;

import com.example.demo.introduction.domain.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IntroductionRepository extends JpaRepository<Introduction, Long> {

    @Query("DELETE FROM section s WHERE s.id = :id")
    void deleteSectionById(Long id);
}
