package daiphan.exercise.service;

import daiphan.exercise.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(int id);
}
