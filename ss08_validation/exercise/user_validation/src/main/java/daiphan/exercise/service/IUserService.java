package daiphan.exercise.service;


import daiphan.exercise.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IUserService {

    Page<User> findAll(Pageable pageable);

    void save(User user);
}
