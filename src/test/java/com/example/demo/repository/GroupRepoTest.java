package com.example.demo.repository;



import com.example.demo.model.GroupTable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest // Utilisation d'une base de données en mémoire pour les tests
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GroupRepoTest {

    @Autowired
    private GroupTableRepository groupTableRepository;

    @Test
    public void testSaveGroupTable() {
        GroupTable groupTable = new GroupTable();
        groupTable.setName("Test Group");
        GroupTable savedGroupTable = groupTableRepository.save(groupTable);
        assertThat(savedGroupTable).isNotNull();
        assertThat(savedGroupTable.getId()).isNotNull();
        assertThat(savedGroupTable.getName()).isEqualTo("Test Group");
    }

    @Test
    public void testFindByName() {
        GroupTable groupTable = new GroupTable();
        groupTable.setName("Test Group");
        groupTableRepository.save(groupTable);

        GroupTable foundGroupTable = groupTableRepository.findByName("Test Group").orElse(null);
        assertThat(foundGroupTable).isNotNull();
        assertThat(foundGroupTable.getId()).isNotNull();
        assertThat(foundGroupTable.getName()).isEqualTo("Test Group");
    }

    @Test
    public void testDeleteGroupTable() {
        GroupTable groupTable = new GroupTable();
        groupTable.setName("Test Group");
        groupTableRepository.save(groupTable);

        groupTableRepository.deleteById(groupTable.getId());
        GroupTable foundGroupTable = groupTableRepository.findByName("Test Group").orElse(null);
        assertThat(foundGroupTable).isNull();
    }



}
