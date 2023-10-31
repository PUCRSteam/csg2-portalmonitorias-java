//Updated Professor Model

package com.grupo2.portaldemonitorias.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

     /**
     * Table Relations
     */
    @JsonProperty("mentorings")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor", cascade = CascadeType.REMOVE)
    private List<Mentoring> mentorings;

    /**
     * Methods
     */
    public Professor() {}

    public Long getId() {
        return getIdProfessor();
    }

}
