package dev.xeo.srrtplanner.notepackage;


import dev.xeo.srrtplanner.dao.NoteRepository;
import dev.xeo.srrtplanner.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NoteServiceImpl implements NoteService{


    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository theNoteRepository) {
        noteRepository = theNoteRepository;
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAllByOrderByNoteNameAsc();
    }

    @Override
    public Note findById(int theId) {
        Optional<Note> result = noteRepository.findById(theId);

        Note theNote = null;

        if (result.isPresent()) {
            theNote = result.get();
        }
        else {
            // we didn't find the note
            throw new RuntimeException("Did not find note id - " + theId);
        }

        return theNote;
    }

    @Override
    public void save(Note theNote) {
        noteRepository.save(theNote);
    }

    @Override
    public void deleteById(int theId) {
        noteRepository.deleteById(theId);
    }

    @Override
    public List<Note> searchBy(String theName) {

        List<Note> results = null;

        if (theName != null && (theName.trim().length() > 0)) {
            results = noteRepository.findByNoteNameContainsOrNoteDescriptionContainsAllIgnoreCase(theName, theName);
        }
        else {
            results = findAll();
        }

        return results;
    }




}



