package es.eoi.redsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eoi.redsocial.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

	/*@Query(value = "select U.* from event E inner join assistance A on E.id = A.id_event inner join users U on A.id_user = U.id where A.state = 'yesAssistance' and u.id =?1", nativeQuery = true)
	List<User> findAllUsersYesAssistance(int id);*/
}
