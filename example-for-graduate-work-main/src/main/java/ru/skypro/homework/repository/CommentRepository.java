package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.homework.entity.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByAdsId(Integer adsPk);

    @Query(nativeQuery = true, value = "SELECT * FROM comment WHERE comment_id = :id AND ads_id = :adsId")
    Optional<Comment> findByIdAndAdsId(@Param(value = "id") Integer id,
                                       @Param(value = "adsId") Integer adsPk);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM comment WHERE comment_id = :id AND ads_id = :adsId")
    void deleteByIdAndAdsId(@Param(value = "id") Integer id,
                            @Param(value = "adsId") Integer adsPk);

    @Transactional
    void deleteAllByAdsId(Integer adsPk);
}
