package daiphan.exercise.repository;

import daiphan.exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByName(String userName);
}
