package dev.xeo.srrtplanner.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Note name field required")
    @Column(name = "note_name")
    private String noteName;

    @Column(name = "note_description")
    private String noteDescription;

    public Note() {
    }

    public Note(int id, String noteName, String noteDescription) {
        this.id = id;
        this.noteName = noteName;
        this.noteDescription = noteDescription;
    }

    public Note(String noteName, String noteDescription) {
        this.noteName = noteName;
        this.noteDescription = noteDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteName='" + noteName + '\'' +
                ", noteDescription='" + noteDescription + '\'' +
                '}';
    }
}





