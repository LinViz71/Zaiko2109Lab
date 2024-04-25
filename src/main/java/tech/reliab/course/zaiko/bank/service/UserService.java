package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.model.dto.request.UserRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {

    void create(UserRequestDto userRequestDto);

    UserResponseDto getById(Long id);

    List<UserResponseDto> getAll();

    void update(UserResponseDto userResponseDto);

    void deleteById(Long id);
}
