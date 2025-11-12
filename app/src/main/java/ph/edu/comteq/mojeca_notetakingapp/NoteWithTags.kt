package ph.edu.comteq.notetakingapp

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ph.edu.comteq.mojeca_notetakingapp.Note
import ph.edu.comteq.mojeca_notetakingapp.NoteTagCrossRef
import ph.edu.comteq.mojeca_notetakingapp.Tag


data class NoteWithTags(
    @Embedded
    val note: Note,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value= NoteTagCrossRef::class,
            parentColumn = "note_id",
            entityColumn = "tag_id")
    )

    val tags: List<Tag>
)
