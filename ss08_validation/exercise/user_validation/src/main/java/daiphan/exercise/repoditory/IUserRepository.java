package daiphan.exercise.repoditory;

import daiphan.exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {


}
