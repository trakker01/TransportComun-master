package com.example.tranport;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tranport.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView n = view.findViewById(R.id.etxtNume);
        n.getText().toString();

        TextView p = view.findViewById(R.id.etxtPrenume);
        p.getText().toString();


        TextView e = view.findViewById(R.id.etxtEmail);
        e.getText().toString();

        TextView numar_telefon = view.findViewById((R.id.etxtNumar));
        numar_telefon.getText().toString();

        TextView r = view.findViewById(R.id.etxtLRezervate);
        r.getText().toString();

        TextView error = (TextView) view.findViewById(R.id.Error);

        binding.MConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"-".equals(n.getText().toString()))
                {
                    if(!"-".equals(p.getText().toString()))
                    {
                        if(!"-".equals(e.getText().toString()))
                        {
                            if(!"-".equals(numar_telefon.getText().toString()))
                            {

                                if(!"-".equals(r.getText().toString()))
                                {
                                    NavHostFragment.findNavController(ThirdFragment.this)
                                            .navigate(R.id.action_ThirdFragment_to_SecondFragment2);
                                }
                                else { error.setText("Numarul de locuri rezervate depaseste numarul de locuri disponibile!"); }
                            }
                            else { error.setText("Numarul de telefon trebuie scris!"); }
                        }
                        else { error.setText("Este obligatoriu un email trebuie scris!"); }
                    }
                    else {error.setText("Nu ati scris prenumele dumneavoastra!"); }
                }
                else { error.setText("Nu ati scris numele dumneavoastra!"); }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
