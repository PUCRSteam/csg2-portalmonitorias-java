package com.grupo2.portaldemonitorias.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.grupo2.portaldemonitorias.Enum.StudentStatus;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StudentStatus status;

    /**
     * Table Relations
     */
    @JsonProperty("mentorings")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<Mentoring> mentorings;

    /**
     * Methods
     */
    public Student() {}

    public Long getId() {
        return getIdStudent();
    }

}