package space.sakibnm.navcomponent_demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentHome extends Fragment {

    private EditText editTextFirstInt, editTextSecondInt;
    private Button buttonAdd, buttonMultiply;
    private int firstInt, secondInt;

    public FragmentHome() {
        // Required empty public constructor
    }

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        editTextFirstInt = rootView.findViewById(R.id.editTextFirstInt);
        editTextSecondInt = rootView.findViewById(R.id.editTextSecondInt);
        buttonAdd = rootView.findViewById(R.id.buttonAdd);
        buttonMultiply = rootView.findViewById(R.id.buttonMultiply);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstInt = Integer.parseInt(String.valueOf(editTextFirstInt.getText()));
                secondInt = Integer.parseInt(String.valueOf(editTextSecondInt.getText()));

                Bundle bundle = new Bundle();
                bundle.putInt("num1", firstInt);
                bundle.putInt("num2", secondInt);
//
                Navigation.findNavController(rootView)
                        .navigate(R.id.action_fragmentHome_to_fragmentAdd,bundle);

            }
        });


        return rootView;
    }
}