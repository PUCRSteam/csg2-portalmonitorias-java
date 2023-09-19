package com.grupo2.portaldemonitorias.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo2.portaldemonitorias.Model.Mentoring;

import java.util.List;

@Repository
public interface MentoringRepository extends JpaRepository<Mentoring, Long> {
    Mentoring findByidStudent(Long id);

    Mentoring findByDiscipline(String discipline);
}