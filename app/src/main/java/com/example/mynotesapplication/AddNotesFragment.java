package com.example.mynotesapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mynotesapplication.entities.Note;
import com.example.mynotesapplication.viewmodels.NoteViewModel;

public class AddNotesFragment extends Fragment {

    private EditText noteTitle;
    private EditText noteBody;
    private Button noteSubmit;

    private NoteViewModel nvm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        nvm = new ViewModelProvider(this).get(NoteViewModel.class);
        return inflater.inflate(R.layout.add_notes_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noteTitle = view.findViewById(R.id.new_note_title);
        noteBody = view.findViewById(R.id.new_note_body);
        noteSubmit = view.findViewById(R.id.new_note_submit);

        noteSubmit.setOnClickListener(v -> {
            System.out.println(noteTitle.getText().toString());
            System.out.println(noteBody.getText().toString());
            final Note newNote = new Note(
                    noteTitle.getText().toString(),
                    noteBody.getText().toString());

            nvm.createNote(newNote);
            Navigation.findNavController(view).popBackStack();
        });

    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}
