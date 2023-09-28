package com.grupo2.portaldemonitorias.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProfessorDTO {
   // @ApiModelProperty(position = 1, notes = "Identificação única do professor")
    private Long idProfessor;
   // @ApiModelProperty(position = 2, notes = "Nome do professor")
    private String professorName;

    public ProfessorDTO() {}

    public Long getId(){
        return getIdProfessor();
    }

    public ProfessorDTO(Long idProfessor, String professorName){
        this.idProfessor = idProfessor;
        this.professorName = professorName;
    }
    public Long getIdProfessor(){
        return idProfessor;
    }
    public void setIdProfessor(Long idProfessor){
        this.idProfessor = idProfessor;
    }
    public String getProfessorName(){
        return professorName;
    }
    
    public void setProfessorName(String professorName){
        this.professorName = professorName;
    }


}

