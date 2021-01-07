package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
