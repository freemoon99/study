// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract NoteContract {
    struct Note {
        string title;
        string content;
    }

    Note[] public notes;

    function createNote(string memory title, string memory content) public {
        notes.push(Note(title, content));
    }

    function getNoteCount() public view returns (uint256) {
        return notes.length;
    }

    function getNoteByIndex(uint256 index) public view returns (string memory, string memory) {
        require(index < notes.length, "Invalid index");
        Note memory note = notes[index];
        return (note.title, note.content);
    }

    function updateNoteByIndex(uint256 index, string memory title, string memory content) public {
        require(index < notes.length, "Invalid index");
        Note storage note = notes[index];
        note.title = title;
        note.content = content;
    }

    function deleteNoteByIndex(uint256 index) public {
        require(index < notes.length, "Invalid index");
        if (index < notes.length - 1) {
            notes[index] = notes[notes.length - 1];
        }
        notes.pop();
    }
}
