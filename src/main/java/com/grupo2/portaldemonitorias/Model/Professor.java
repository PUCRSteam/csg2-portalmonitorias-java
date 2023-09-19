//Updated Professor Model

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
@Table(name = "professores", schema = "personas")

public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long idProfessor;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "professor_name")
    private String professorName;

    public Professor() {}

    public Long getId() {
        return getIdProfessor();
    }

}
