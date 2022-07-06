package com.example.kch.dockertest.repository;

import com.example.kch.dockertest.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();


}
