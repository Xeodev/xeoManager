package dev.xeo.srrtplanner.notepackage;


import dev.xeo.srrtplanner.entity.Note;

import java.util.List;

public interface NoteService {

    List<Note> findAll();

    Note findById(int theId);

    void save(Note theNote);

    void deleteById(int theId);

    List<Note> searchBy(String theName);
}




