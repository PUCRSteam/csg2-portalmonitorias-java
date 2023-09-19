package com.grupo2.portaldemonitorias.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;

import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "students", schema = "personas")

public class Student {

    /**
     * O id do estudante é equivalente a sua matricula;
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long idStudent;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "student_name")
    private String studentName;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "disciline_name")
    private String discipline;

    public Student() {}

    public Long getId() {
        return getIdStudent();
    }

}