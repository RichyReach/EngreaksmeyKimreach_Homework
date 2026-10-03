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

import com.example.pt16.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnRegister.setOnClickListener(v -> {
            String email = binding.etEmail.getText() != null ? binding.etEmail.getText().toString().trim() : "";
            String username = binding.etUsername.getText() != null ? binding.etUsername.getText().toString().trim() : "";
            String password = binding.etPassword.getText() != null ? binding.etPassword.getText().toString() : "";
            String confirmPassword = binding.etConfirmPassword.getText() != null ? binding.etConfirmPassword.getText().toString() : "";

            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
            } else if (!java.util.Objects.equals(password, confirmPassword)) {
                Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
                requireActivity().finish();
            }
        });

        binding.tvLogIn.setOnClickListener(v ->
            Navigation.findNavController(v).navigateUp()
        );

        binding.btnGoogle.setOnClickListener(v ->
            Toast.makeText(requireContext(), "Google Sign Up clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnFacebook.setOnClickListener(v ->
            Toast.makeText(requireContext(), "Facebook Sign Up clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnGithub.setOnClickListener(v ->
            Toast.makeText(requireContext(), "GitHub Sign Up clicked", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}