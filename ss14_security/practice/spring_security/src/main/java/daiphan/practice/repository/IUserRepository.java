package daiphan.practice.repository;


import daiphan.practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
