package com.example.demo.repository;

import com.example.demo.model.GroupTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface GroupTableRepository extends CrudRepository<GroupTable,Long> {
    Optional<GroupTable> findByName(String name);


}
