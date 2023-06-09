
package com.app.repository;

import com.app.model.GroupTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GroupTableRepository extends CrudRepository<GroupTable,Long> {
    Optional<GroupTable> findByName(String name);


}