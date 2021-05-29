package kadumi.hrms.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kadumi.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
