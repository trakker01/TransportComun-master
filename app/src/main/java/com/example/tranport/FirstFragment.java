package com.example.tranport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tranport.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner) ;
        final String[] LocPlecare = {null};

        List<String> list1 = new ArrayList<String>();
        list1.add("Targu Mures");
        list1.add("Bacau");
        list1.add("Brasov");
        list1.add("Bucuresti");
        list1.add("Iasi");
        list1.add("Cluj");

        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinner2) ;
        final String[] Destinatie = {null};

        List<String> list2 = new ArrayList<String>();
        list2.add("Targu Mures");
        list2.add("Bacau");
        list2.add("Brasov");
        list2.add("Bucuresti");
        list2.add("Iasi");
        list2.add("Cluj");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, list1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, list2);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                LocPlecare[0] = parent.getItemAtPosition(position).toString();                                   //Se alegea locul de plecare
                                                                                                                 //Se seta lista de orase destinatie dupa orasul plecarea unde existau trasee din acele orase
            }                                                                                                    //U
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Destinatie[0] = parent.getItemAtPosition(position).toString();                                   //Se alegea firma cu care se dorea sa se faca rezervatia dupa ora de plecare

            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(LocPlecare[0]!=Destinatie[0]) {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}