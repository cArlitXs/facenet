package es.eoi.redsocial.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import es.eoi.redsocial.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "select * from User where pass like '?1' and user like '?2'", 
			  nativeQuery = true)
			List<User> findUserByUsernameAndPass(String user,String pass);
}
