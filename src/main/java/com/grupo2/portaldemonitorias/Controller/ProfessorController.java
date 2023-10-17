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

import com.grupo2.portaldemonitorias.DTO.ProfessorDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value ="/personas")
public class ProfessorController {
    
    private static final String URL_PLURAL = "/professors";
    private static final String URL_SINGULAR = "/professor/{id}";

    private ProfessorRepository studentRepository;
    private StudentService studentService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ProfessortController(
            ProfessorRepository professorRepository,
            ProfessorService professorService
    ){ 
        this.professorRepository = professorRepository;
        this.professorService = professorService;
    }
     @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os professor cadastrados")
    public ResponseEntity<List<ProfessorDTO>> readAllProfessors(
            @RequestParam(value = "professorName", required = false) String professorName
    ){

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um professor pelo seu ID")
    public ResponseEntity<ProfessorDTO> readProfessorById(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.map(value -> ResponseEntity.ok(ProfessorMapper.MAPPER.ProfessorToProfessorDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    }
     @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo professor")
    @Transactional
    public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody @Valid ProfessorDTO professorDTO, UriComponentsBuilder uriComponentsBuilder) {
        Professor professor = professorService.save(professorDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(ProfessorMapper.MAPPER.ProfessorToProfessorDTO(professor));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um professor salvo")
    @Transactional
    public ResponseEntity<ProfessorDTO> updateProfessor(@PathVariable Long id, @RequestBody @Valid ProfessorDTO professorDTO) {
        Optional<Professor> verifyId = professorRepository.findById(id);
        if (verifyId.isPresent()) {
            Professor professor = professorService.update(id, professorDTO, professorRepository);
            return ResponseEntity.ok(ProfessorMapper.MAPPER.ProfessorToProfessorDTO(professor));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um professor salvo")
    @Transactional
    public ResponseEntity<Long> deleteProfessor(@PathVariable Long id) {
        Optional<Professor> verifyId = professorRepository.findById(id);
        if (verifyId.isPresent()) {
            professorService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }

} 
