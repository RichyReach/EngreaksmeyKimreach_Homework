package com.example.pt16;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pt16.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLogin.setOnClickListener(v -> {
            String username = binding.etUsername.getText() != null ? binding.etUsername.getText().toString().trim() : "";
            String password = binding.etPassword.getText() != null ? binding.etPassword.getText().toString() : "";

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });

        binding.tvForgotPassword.setOnClickListener(v ->
            Toast.makeText(requireContext(), "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        );

        binding.tvSignUp.setOnClickListener(v ->
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registerFragment)
        );

        binding.btnGoogle.setOnClickListener(v ->
            Toast.makeText(requireContext(), "Google Login clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnFacebook.setOnClickListener(v ->
            Toast.makeText(requireContext(), "Facebook Login clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnGithub.setOnClickListener(v ->
            Toast.makeText(requireContext(), "GitHub Login clicked", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}