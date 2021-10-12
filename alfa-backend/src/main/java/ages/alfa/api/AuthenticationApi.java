package ages.alfa.api;

import ages.alfa.model.entity.Student;
import ages.alfa.model.entity.Teacher;
import ages.alfa.model.entity.User;
import ages.alfa.service.StudentService;
import ages.alfa.service.TeacherService;
import ages.alfa.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final UserService userService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna os dados do usuário pelo email."),
            @ApiResponse(code = 404, message = "Usuário não foi encontrado.")
    })
    @GetMapping()
    public ResponseEntity<?> findByEmail(@RequestParam(name = "email") String email) {

        // Busca o user pelo email
        Optional<User> user = userService.findByEmail(User.builder().email(email).build());
        if (user.isPresent()) {

            // Procura na base de professores pelo userId
            Optional<Teacher> teacher = teacherService.findByUserId(user.get().getId());

            if (teacher.isPresent()) {
                return ResponseEntity.ok(teacher.get());
            } else {

                // Procura na base de alunos pelo userId
                Optional<Student> student = studentService.findByUserId(user.get().getId());

                if (student.isPresent()) {
                    return ResponseEntity.ok(student.get());
                }
            }
        }

        // User não foi encontrado
        return ResponseEntity.notFound().build();
    }

}
