package ages.alfa.service.impl;

import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.model.entity.Address;
import ages.alfa.model.entity.Teacher;
import ages.alfa.model.entity.User;
import ages.alfa.repository.TeacherRepository;
import ages.alfa.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Optional<Teacher> findByUserId(Long userId) {
        return teacherRepository.findOne(Example.of(Teacher.builder().user(User.builder().id(userId).build()).build()));
    }

    @Override
    public Teacher create(CreateTeacherRequest request) {

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

        Teacher teacher = Teacher.builder()
                .education(request.getEducation())
                .eja(request.getEja())
                .school(request.getSchool())
                .subject(request.getSubject())
                .user(user)
                .build();

        return teacherRepository.save(teacher);
    }
}
