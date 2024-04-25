package tech.reliab.course.zaiko.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.zaiko.bank.exception.CustomNotFoundException;
import tech.reliab.course.zaiko.bank.model.dto.request.UserRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.UserResponseDto;
import tech.reliab.course.zaiko.bank.model.entity.User;
import tech.reliab.course.zaiko.bank.repository.UserRepository;
import tech.reliab.course.zaiko.bank.service.UserService;
import tech.reliab.course.zaiko.bank.utlis.MappingUtils;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final Random random = new Random();
    private final UserRepository userRepository;
    private final MappingUtils mappingUtils;

    @Transactional
    @Override
    public void create(UserRequestDto userRequestDto) {
        User user = mappingUtils.mapToUserEntity(userRequestDto);
        user.setMonthlyIncome(Math.round(random.nextDouble(10_000) * 100.0) / 100.0);
        user.setCreditRating(switch ((int) (user.getMonthlyIncome() / 1000)) {
            case 2 -> 200;
            case 3 -> 300;
            case 4 -> 400;
            case 5 -> 500;
            case 6 -> 600;
            case 7 -> 700;
            case 8 -> 800;
            case 9 -> 900;
            case 10 -> 1000;
            default -> 100;
        });
        userRepository.save(user);
    }

    @Override
    public UserResponseDto getById(Long id) {
        return mappingUtils.mapToUserResponseDto(
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomNotFoundException(User.class, id))
        );
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(mappingUtils::mapToUserResponseDto)
                .toList();
    }

    @Transactional
    @Override
    public void update(UserResponseDto userResponseDto) {
        User user = mappingUtils.mapToUserEntity(userResponseDto);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new CustomNotFoundException(User.class, id);
        }
        userRepository.deleteById(id);
    }
}
