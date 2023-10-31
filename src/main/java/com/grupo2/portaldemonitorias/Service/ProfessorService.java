package com.grupo2.portaldemonitorias.Service;

import org.springframework.stereotype.Service;

import com.grupo2.portaldemonitorias.DTO.ProfessorDTO;
import com.grupo2.portaldemonitorias.Model.Professor;
import com.grupo2.portaldemonitorias.Repository.MentoringRepository;
import com.grupo2.portaldemonitorias.Repository.ProfessorRepository;

@Service
public class ProfessorService {

    public ProfessorService() {}

    @Transactional
    public Professor save (ProfessorDTO professorDTO) {

        @Autowired
        private ProfessorRepository professorRepository;

        @Autowired
        private MentoringRepository mentoringRepository;

        //service estudante
        //service professor
        
        Professor professor= ProfessorMapper.MAPPER.ProfessorDTO(professorDTO);

        professorRepository.save(professor);
    }

    @Transactional
    public Professor delete (@PathVariable Long id) {
        Optional<Professor> professorGetter = ProfessorRepository.findByidProfessor(id);
        Professor professor = professorGetter.get();

        ProfessorService.delete(professor.getProfessorName());

        if(professor.getMentorings() != null && professor.getMentorings().getId() != null) {
            professorRepository.delete(mentoring);
        }

        professorRepository.delete(professor);

    }

    //Metodos extras

}