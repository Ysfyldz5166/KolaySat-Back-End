package com.satdegerlendir.demo.Card;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long>{
    List<Card> findByUserId(Long userId);

}
