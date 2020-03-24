package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.Register.DoctorModel;
import com.example.myapp.Register.LoginAcitvity;
import com.example.myapp.Register.RegisterModelForStudent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DoctorFramgent extends Fragment {
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private EditText mname, mphone, memail, mspecialization;
    private Button login;
    private Button drRegister;
    private View v;

    public DoctorFramgent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_doctor_framgent, container, false);
        mname = v.findViewById(R.id.DeditName);
        mphone = v.findViewById(R.id.Deditphone);
        memail = v.findViewById(R.id.DeditEmail);
        mspecialization = v.findViewById(R.id.Specialization);
        drRegister = v.findViewById(R.id.DBtnRegister);
        login = v.findViewById(R.id.DBtnLogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginAcitvity.class));
            }
        });
        drRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
                Intent i = new Intent(getActivity(), UploadQuestion.class);
                startActivity(i);
            }
        });
        return v;
    }

    private void register() {
        String name = mname.getText().toString();
        String phone = mphone.getText().toString();
        String spe = mspecialization.getText().toString();
        String email = memail.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getActivity(), "please enter your name", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(getActivity(), "please enter your phone", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity(), "please enter your email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(spe)) {
            Toast.makeText(getActivity(), "please enter your Specification", Toast.LENGTH_SHORT).show();
        } else {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("Doctor");
            DoctorModel doctorModel = new DoctorModel(name, phone, email, spe);
            reference.child("studentInfo").setValue(doctorModel);
            Toast.makeText(getActivity(), "Successful Registertion..", Toast.LENGTH_SHORT).show();

        }


    }
//    public  void initView(){
//
//    }


}


