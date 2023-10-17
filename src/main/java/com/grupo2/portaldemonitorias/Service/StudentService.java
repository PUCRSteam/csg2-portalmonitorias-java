import com.grupo2.portaldemonitorias.DTO.StudentDTO;
import com.grupo2.portaldemonitorias.Model.Student;
import com.grupo2.portaldemonitorias.Repository.MentoringRepository;
import com.grupo2.portaldemonitorias.Repository.StudentRepository;

@Service
public class StudentService {

    public StudentService() {}

    @Transactional
    public Student save (StudentDTO studentDTO) {

        @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private MentoringRepository mentoringRepository;

        //service estudante
        //service professor
        
        Student student= StudentMapper.MAPPER.StudentDTO(studentDTO);

        studentRepository.save(student);
    }

    @Transactional
    public Student delete (@PathVariable Long id) {
        Optional<Student> studentGetter = studentRepository.getIdStudent(id);
        Student student = studentGetter.get();

        StudentService.delete(student.getStudentName());
        StudentService.delete(student.getStatus());

        if(student.getMentorings() != null && student.getMentorings().getId() != null) {
            mentoringRepository.delete(mentoring);
        }

        studentRepository.delete(student);

    }

    //Metodos extras

}