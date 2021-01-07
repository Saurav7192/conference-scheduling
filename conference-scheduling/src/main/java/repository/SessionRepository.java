package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
