package com.grupo2.portaldemonitorias.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class MentoringDTO {
    // @ApiModelProperty(position = 1, notes = "Identificação única da monitoria")
    private Long idMentoring;
    // @ApiModelProperty(position = 2, notes = "Curso da monitoria")
    private String course;

    public MentoringDTO() {}

    public Long getId(){
        return getIdMentoring();
    }

/* 
  == Retirar este bloco se não for necessário ==
    public MentoringDTO(Long idMentoring, String course){
        this.idMentoring = idMentoring;
        this.course = course;
    }

    public Long getIdMentoring(){
        return idMentoring;
    }

    public void setIdMentoring(Long idMentoring){
        this.idMentoring = idMentoring;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }
*/
}
