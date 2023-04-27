package com.boo.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

    Optional<Cat> findAllByEmail(String email);

}
