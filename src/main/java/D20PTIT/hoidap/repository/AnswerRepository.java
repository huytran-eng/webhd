package D20PTIT.hoidap.repository;

import D20PTIT.hoidap.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,String> {
}
