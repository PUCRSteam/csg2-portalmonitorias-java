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
@Table(name = "mentorings", schema = "personas")

public class Mentoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mentoring")
    private Long idMentoring;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "disciline_name")
    private String discipline;

    public Mentoring() {}

    public Long getId() {
        return getIdMentoring();
    }

    public String getDiscipline() {
        return getDiscipline();
    }

}