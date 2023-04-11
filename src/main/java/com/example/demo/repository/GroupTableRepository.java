package com.example.demo.repository;

import com.example.demo.model.GroupTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GroupTableRepository extends CrudRepository<GroupTable,Long> {



    Optional<GroupTable> findByName(String name);


}
