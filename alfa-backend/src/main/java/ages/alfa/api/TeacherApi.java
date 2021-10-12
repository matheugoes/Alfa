package ages.alfa.api;

import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.model.entity.Teacher;
import ages.alfa.service.TeacherService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teacher")
@RequiredArgsConstructor
public class TeacherApi {

    private final TeacherService teacherService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Registra estudante."),
    })
    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody final CreateTeacherRequest request) {
        return ResponseEntity.ok().body(teacherService.create(request));
    }
}
