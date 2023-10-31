package com.grupo2.portaldemonitorias.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo2.portaldemonitorias.Model.Professor;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByidProfessor(Long id);
}
