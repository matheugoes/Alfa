package ages.alfa.service.impl;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.model.entity.Address;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Student;
import ages.alfa.model.entity.User;
import ages.alfa.repository.StudentRepository;
import ages.alfa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findByUserId(Long userId) {
        return studentRepository.findOne(Example.of(Student.builder().user(User.builder().id(userId).build()).build()));
    }

    @Override
    public Student create(CreateStudentRequest request) {

        //TODO criar mapper ou utilizar dep de object mapper
        Address address = Address.builder()
                .city(request.getCity())
                .country(request.getCountry())
                .firstLine(request.getFirstLine())
                .secondLine(request.getSecondLine())
                .build();

        User user = User.builder()
                .address(address)
                .gender(request.getGender())
                .name(request.getName())
                .race(request.getRace())
                .email(request.getEmail())
                .build();

        Student student = Student.builder()
                .user(user)
                .build();

        return studentRepository.save(student);
    }
}
