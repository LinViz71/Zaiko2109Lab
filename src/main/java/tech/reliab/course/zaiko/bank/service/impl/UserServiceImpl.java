package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.User;
import tech.reliab.course.zaiko.bank.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class UserServiceImpl implements UserService {

    /**
     * @param id          the id
     * @param fullName    the full name
     * @param dateOfBirth the date of birth
     * @param placeOfWork the place of work
     *                    <br>Monthly income (generated randomly, but not more than 10,000)
     *                    <br>Credit accounts (by default empty)
     *                    <br>Debit accounts (by default empty)
     *                    <br>Credit rating for the bank (generated randomly based on
     *                    the monthly income, from less than 1000 - 100, from 1000 to 2000 - 200 and so on up to 10000)
     * @return {@link User}
     */
    @Override
    public User createUser(Long id,
                           String fullName,
                           LocalDate dateOfBirth,
                           String placeOfWork) {
        Random random = new Random();
        User user = User.builder()
                .id(id)
                .fullName(fullName)
                .dateOfBirth(dateOfBirth)
                .placeOfWork(placeOfWork)
                .monthlyIncome(Math.round(random.nextDouble(10_000) * 100.0) / 100.0)
                .banks(new ArrayList<>())
                .creditAccounts(new ArrayList<>())
                .paymentAccounts(new ArrayList<>())
                .build();
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
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void updateUserById(Long id) {

    }

    @Override
    public void deleteUserById(Long id) {

    }
}
