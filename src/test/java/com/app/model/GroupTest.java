package com.app.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.repository.GroupTableRepository;

@DataJpaTest
public class GroupTest {

    @Autowired
    private GroupTableRepository groupTableRepository;

    private GroupTable groupTable;

    @BeforeEach
    public void setup() {
        groupTable = new GroupTable();
        groupTable.setName("Test Group");
        groupTable.setPersons(new HashSet<>());
    }

    @Test
    @Transactional
    public void testSaveGroupTable() {
        groupTableRepository.save(groupTable);
        assertThat(groupTableRepository.findById(groupTable.getId())).isNotEmpty().get().isEqualTo(groupTable);
    }

    @Test
    @Transactional
    public void testDeleteGroupTable() {
        groupTableRepository.save(groupTable);
        assertThat(groupTableRepository.findById(groupTable.getId())).isNotEmpty().get().isEqualTo(groupTable);
        groupTableRepository.delete(groupTable);
        assertThat(groupTableRepository.findById(groupTable.getId())).isEmpty();
    }

    @Test
    @Transactional
    public void testFindGroupTableByName() {
        groupTableRepository.save(groupTable);
        assertThat(groupTableRepository.findByName(groupTable.getName())).isNotEmpty().get().isEqualTo(groupTable);
    }

    @Test
    @Transactional
    public void testGroupTableToString() {
        String expectedString = "GroupTable{id=null, name='Test Group', persons=[]}";
        assertThat(groupTable.toString()).isEqualTo(expectedString);
    }

}
