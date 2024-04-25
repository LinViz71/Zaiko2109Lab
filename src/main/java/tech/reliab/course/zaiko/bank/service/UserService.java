package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.entity.User;

import java.time.LocalDate;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Create user.
     *
     * @param id          the id
     * @param fullName    the full name
     * @param dateOfBirth the date of birth
     * @param placeOfWork the place of work
     * @return the user
     */
    User createUser(Long id, String fullName, LocalDate dateOfBirth, String placeOfWork);

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    User getUserById(Long id);

    /**
     * Update user by id.
     *
     * @param id the id
     */
    void updateUserById(Long id);

    /**
     * Delete user by id.
     *
     * @param id the id
     */
    void deleteUserById(Long id);
}
