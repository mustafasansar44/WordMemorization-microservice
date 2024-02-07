package com.msansar.wordgroupservice.repository;


import com.msansar.wordgroupservice.model.WordGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordGroupRepository extends JpaRepository<WordGroup, String> {

}
