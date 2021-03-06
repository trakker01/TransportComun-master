package com.example.tranport;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tranport.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
                                                                                                        //Ce planuri am avut la proiect daca puteam sa fac conecxiunea dintre Client-Server
        TextView f = (TextView) view.findViewById(R.id.txtfirma);
        TextView l = (TextView) view.findViewById(R.id.txtlocuri);
        TextView d = (TextView) view.findViewById(R.id.txtdurata);
        TextView p = (TextView) view.findViewById(R.id.txtplecare);
        TextView dest = (TextView) view.findViewById(R.id.txtdestinatie);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner3) ;
                                                                                                        //Aici luam informatile din baza de date de la server unde Locul de plecare  sub forma de string si erau bagate in lista String
        List<String> list = new ArrayList<String>();                                                    //list.add(String/int cu ora de plecare)
        list.add("8:30");
        list.add("12:00");
        list.add("18:00");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, list);          //Se baga list de mai sus in Spinner
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String firma = parent.getItemAtPosition(position).toString();                                   //Se alegea firma cu care se dorea sa se faca rezervatia dupa ora de plecare
                for(int i=0;i<list.size();++i){                                                                 //Se parcurgea
                    if(firma == "8:30")
                    {
                        f.setText("Balant Transport");
                        l.setText("10");
                        d.setText("8 ore");
                        p.setText("Targu Mures");
                        dest.setText("Bacau");
                    }
                    else if(firma == "12:00")
                    {
                        f.setText("Geneese");
                        l.setText("24");
                        d.setText("8 ore");
                        p.setText("Targu Mures");
                        dest.setText("Bacau");
                    }
                    else if(firma == "18:00")
                    {
                        f.setText("Vetro");
                        l.setText("18");
                        d.setText("8 ore");
                        p.setText("Targu Mures");
                        dest.setText("Bacau");
                    }
                    else
                    {
                        f.setText("Nu este firma disponibila");
                    }
                }

            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}