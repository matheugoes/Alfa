package ages.alfa.service;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    Optional<Student> findByUserId(Long userId);

    Student create(CreateStudentRequest request);
}
