package com.grupo2.portaldemonitorias.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StudentDTO {
    //@ApiModelProperty(position = 1, notes = "Identificação única do estudante")
    private Long idStudent;
    //@ApiModelProperty(position = 2, notes = "Nome do estudante")
    private String StudentName;
   // @ApiModelProperty(position = 3, notes = "Curso do estudante")
    private String course;

    public StudentDTO() {}

    public Long getId(){
        return getIdStudent();
    }

   /* 
   == Retirar este bloco se não for necessário == 
    public StudentDTO(Long idStudent, String StudentName, String course){
        this.idStudent = idStudent;
        this.StudentName = StudentName;
        this.course = course;
    }
    public Long getId(){
        return idStudent;
    }
    public void setId(Long idStudent){
        this.idStudent = idStudent;
    }
    public String getStudentName(){
        return StudentName;
    }
    public void setStudentName(String StudentName){
        this.StudentName = StudentName;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
*/
}