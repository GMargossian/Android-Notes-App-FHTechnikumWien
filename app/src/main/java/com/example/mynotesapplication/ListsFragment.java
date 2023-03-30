package com.example.mynotesapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapplication.adapter.NoteListAdapter;
import com.example.mynotesapplication.entities.Note;
import com.example.mynotesapplication.viewmodels.NoteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListsFragment extends Fragment {

    NoteViewModel nvm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        nvm = new ViewModelProvider(this).get(NoteViewModel.class);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.fragment_toolbar_title);
        return inflater.inflate(R.layout.notes_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton b = view.findViewById(R.id.new_note_button);
        b.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_listsFragment_to_addNotesFragment);
        });

        RecyclerView recyclerView = view.findViewById(R.id.notes_list);
        final NoteListAdapter adapter = new NoteListAdapter(new NoteListAdapter.NoteDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        nvm.getAll().observe(getActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.submitList(new LinkedList<>(notes));
            }
        });
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}
