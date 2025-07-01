package com.ykdev.spring_rest_api;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findFirstById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update book SET title = ?1, year = ?2 where id = ?3", nativeQuery = true)
    int updateBookTitleAndYear(String title, int year, Long id);
}