package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Ads;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM ads WHERE ads_author_id = :id")
    List<Ads> findByAdsAuthorId(@Param(value = "id") Integer id);

    List<Ads> findAdsByTitleContainingIgnoreCase(String name);
}
