package dev.xeo.srrtplanner.notepackage;


import dev.xeo.srrtplanner.entity.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService theNoteService) {
        noteService = theNoteService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listNotes(Model theModel) {

        // get notes from db
        List<Note> theNotes = noteService.findAll();

        // add to the spring model
        theModel.addAttribute("notes", theNotes);

        return "notes/list-notes";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Note theNote = new Note();

        theModel.addAttribute("note", theNote);

        return "notes/note-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("noteId") int theId,
                                    Model theModel) {

        // get the note from the service
        Note theNote = noteService.findById(theId);

        // set note as a model attribute to pre-populate the form
        theModel.addAttribute("note", theNote);

        // send over to our form
        return "notes/note-form";
    }

    @PostMapping("/save")
    public String saveNote(@ModelAttribute("note") Note theNote) {

        // save the note
        noteService.save(theNote);

        // use a redirect to prevent duplicate submissions
        return "redirect:/notes/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("noteId") int theId) {

        // delete the project
        noteService.deleteById(theId);

        // redirect to /notes/list
        return "redirect:/notes/list";

    }

    @GetMapping("/search")
    public String delete(@RequestParam("noteName") String theName,
                         Model theModel) {

        // delete the note
        List<Note> theNotes = noteService.searchBy(theName);

        // add to the spring model
        theModel.addAttribute("notes", theNotes);

        // send to /notes/list
        return "notes/list-notes";

    }

}




