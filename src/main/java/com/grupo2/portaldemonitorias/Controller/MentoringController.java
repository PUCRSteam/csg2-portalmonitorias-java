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

import com.grupo2.portaldemonitorias.DTO.MentoringDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value ="/personas")
public class MentoringController {
    
    private static final String URL_PLURAL = "/mentoring";
    private static final String URL_SINGULAR = "/mentoring/{id}";

    private MentoringRepository mentoringRepository;
    private MentoringService mentoringService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public MentoringController(
            MentoringRepository mentoringRepository,
            MentoringService mentoringService
    ){ 
        this.mentoringRepository = mentoringRepository;
        this.mentoringService = mentoringService;
    }
     @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos as monitoria cadastradas")
    public ResponseEntity<List<MentoringDTO>> readAllMetoring(
            @RequestParam(value = "course", required = false) String mentoringCourse
    ){

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de uma monitoria pelo seu ID")
    public ResponseEntity<MentoringDTO> readMentoringById(@PathVariable Long id) {
        Optional<Mentoring> mentoring = mentoringRepository.findById(id);
        return mentoring.map(value -> ResponseEntity.ok(Mentoringapper.MAPPER.MentoringToMentoringDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    }
     @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria uma nova monitoria")
    @Transactional
    public ResponseEntity<MentoringDTO> createMentoring(@RequestBody @Valid MentoringDTO mentoringDTO, UriComponentsBuilder uriComponentsBuilder) {
        Mentoring mentoring = mentoringService.save(MentoringDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(MentoringMapper.MAPPER.MentoringToMentoringDTO(mentoring));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza uma monitoria salva")
    @Transactional
    public ResponseEntity<MentoringDTO> updateMentoring(@PathVariable Long id, @RequestBody @Valid MentoringDTO mentoringDTO) {
        Optional<Mentoring> verifyId = mentoringRepository.findById(id);
        if (verifyId.isPresent()) {
            Mentoring mentoring = mentoringService.update(id, mentoringDTO, mentoringRepository);
            return ResponseEntity.ok(MentoringMapper.MAPPER.MentoringToMentoringDTO(mentoring));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove uma monitoria salva")
    @Transactional
    public ResponseEntity<Long> deleteMentoring(@PathVariable Long id) {
        Optional<Mentoring> verifyId = mentoringRepository.findById(id);
        if (verifyId.isPresent()) {
            mentoringService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }

} 
