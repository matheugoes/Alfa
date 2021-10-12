package ages.alfa.service;


import ages.alfa.dto.CreateTeacherRequest;

import ages.alfa.model.entity.Teacher;

import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> findByUserId(Long userId);

    Teacher create(CreateTeacherRequest request);
}
