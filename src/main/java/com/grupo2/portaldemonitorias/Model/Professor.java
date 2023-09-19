//Updated Professor Model

package com.grupo2.portaldemonitorias.Model;

import lombok.Getter;
import lombok.Setter;

import com.grupo2.portaldemonitorias.Enum.Gender;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public Professor() {}

    public Long getId() {
        return getIdProfessor();
    }

}
