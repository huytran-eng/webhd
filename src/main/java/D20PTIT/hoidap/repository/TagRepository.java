package D20PTIT.hoidap.repository;

import D20PTIT.hoidap.model.Question;
import D20PTIT.hoidap.model.Tag;
import D20PTIT.hoidap.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
    @Query("SELECT t FROM Tag t WHERE " +
            "t.tagName LIKE CONCAT('%',:query, '%')" +
            "Or t.tagDescription LIKE CONCAT('%', :query, '%')")
    List<Tag> searchTags(String query);

//    @Override
//    @Query(value = " SELECT t from Tag t left join fetch  t.questions",
//            countQuery = " SELECT COUNT(t) from Tag t")
//    List<Tag> findAll();
//
//    @Query(value = " SELECT t from Tag t left join fetch  t.questions",
//            countQuery = " SELECT COUNT(t) from Tag t")
//    Page<Tag> findAll(Pageable pageable);

    Optional<Tag> findByTagName(String tagName);
}
