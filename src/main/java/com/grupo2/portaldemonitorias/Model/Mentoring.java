package com.grupo2.portaldemonitorias.Model;

import com.grupo2.portaldemonitorias.Enum.MentoringStatus;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "mentorings", schema = "informations")

public class Mentoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mentoring")
    private Long idMentoring;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "description_mentoring")
    private String description;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "disciline_name")
    private String discipline;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MentoringStatus status;


    /**
     * Table Relations
     */
    @JoinColumn(name = "id_student")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @JoinColumn(name = "id_professor")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;


    /**
     * Methods
     */
    public Mentoring() {}

    public Long getId() {
        return getIdMentoring();
    }

    public String getDiscipline() {
        return getDiscipline();
    }

    public String getDescription() {
        return getDiscipline();
    }

}