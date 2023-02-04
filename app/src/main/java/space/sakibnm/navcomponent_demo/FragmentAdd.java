package space.sakibnm.navcomponent_demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentAdd extends Fragment {
    private TextView textViewAddResult;
    private Button buttonBackToHome;
    private int firstInt, secondInt;

    public FragmentAdd() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            firstInt = getArguments().getInt("num1");
            secondInt = getArguments().getInt("num2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add, container, false);
        textViewAddResult = rootView.findViewById(R.id.textViewAddResult);
        buttonBackToHome = rootView.findViewById(R.id.buttonBackToHomeFromAdd);
        int resultAdd = firstInt+secondInt;
        textViewAddResult.setText(resultAdd+"");
//
        buttonBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("num1", firstInt);
                bundle.putInt("num2", secondInt);

                Navigation.findNavController(rootView)
                        .navigate(R.id.action_fragmentAdd_to_fragmentHome, bundle);
            }
        });

        return rootView;
    }
}