package repo;

import entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.UserService;
@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
}