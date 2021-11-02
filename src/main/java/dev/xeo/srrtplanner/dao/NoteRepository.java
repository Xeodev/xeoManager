package dev.xeo.srrtplanner.dao;


import dev.xeo.srrtplanner.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {


    // add a method to sort by NoteName
    List<Note> findAllByOrderByNoteNameAsc();

    // search by name
    List<Note> findByNoteNameContainsOrNoteDescriptionContainsAllIgnoreCase(String name, String lName);


}




