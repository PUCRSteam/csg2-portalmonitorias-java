import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.grupo2.portaldemonitorias.DTO.StudentDTO;
import com.grupo2.portaldemonitorias.Model.Student;
import com.grupo2.portaldemonitorias.Service.StudentService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value ="/personas")
public class StudentController {
    
    private static final String URL_PLURAL = "/students";
    private static final String URL_SINGULAR = "/student/{id}";

    private StudentRepository studentRepository;
    private StudentService studentService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public StudentController(
            StudentRepository studentRepository,
            StudentService studentService
    ){ 
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }
     @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os estudantes cadastrados")
    public ResponseEntity<List<StudentDTO>> readAllStudents(
            @RequestParam(value = "course", required = false) String course,
            @RequestParam(value = "studentName", required = false) String studentName
    ){
        ;
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um estudante pelo seu ID")
    public ResponseEntity<StudentDTO> readStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(value -> ResponseEntity.ok(AthleteMapper.MAPPER.StudentTOStudenteDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo estudante")
    @Transactional
    public ResponseEntity<StudentDTO> createAthlete(@RequestBody @Valid StudentDTO studentDTO, UriComponentsBuilder uriComponentsBuilder) {
        Student student = studentService.save(studentDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(StudentMapper.MAPPER.StudentTOStudenteDTO(student));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um estudante salvo")
    @Transactional
    public ResponseEntity<StudentDTO> updateAthlete(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) {
        Optional<Student> verifyId = studentRepository.findById(id);
        if (verifyId.isPresent()) {
            Student student = studentService.update(id, studentDTO, studentRepository);
            return ResponseEntity.ok(StudentMapper.MAPPER.AthleteToAthleteDTO(student));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um estudante salvo")
    @Transactional
    public ResponseEntity<Long> deleteAthlete(@PathVariable Long id) {
        Optional<Student> verifyId = studentRepository.findById(id);
        if (verifyId.isPresent()) {
            studentService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }

} 



