package ages.alfa.api;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.model.entity.Student;
import ages.alfa.service.StudentService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
@RequiredArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos alunos."),
    })
    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Registra estudante."),
    })
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody final CreateStudentRequest request) {
        return ResponseEntity.ok().body(studentService.create(request));
    }
}
