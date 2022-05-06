package fr.univrouen.rss22.repositories;

import fr.univrouen.rss22.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    Optional<Item> findByTitle(String title);

    @Query("select i from Item i where i.publishedOrUpdated=?1")
    Optional<Item> findByDate(Date date);
}
