package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.Register.RegisterModelForStudent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class StudentFragment extends Fragment {

private EditText mname,mphone,mid,memail;
private FirebaseDatabase fbdatabase;
private DatabaseReference reference;
private Button register;
    public StudentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_student, container, false);
        mname=v.findViewById(R.id.StueditName);
        mphone=v.findViewById(R.id.Stueditphone);
        memail=v.findViewById(R.id.StueditEmail);
        mid=v.findViewById(R.id.StueditSSN);
       register =v.findViewById(R.id.StuBtnRegister);
       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               checkIsEmpty();
               Intent i=new Intent(getActivity(),GoTOSolve.class);
               startActivity(i);
           }
       });

        return v;
    }

      public void checkIsEmpty(){
        String name=mname.getText().toString();
        String phone=mphone.getText().toString();
        String id=mid.getText().toString();
        String email=memail.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(getActivity(), "please enter your name", Toast.LENGTH_SHORT).show();
        }
          if(TextUtils.isEmpty(phone)){
              Toast.makeText(getActivity(), "please enter your phone", Toast.LENGTH_SHORT).show();
          }
          if(TextUtils.isEmpty(email)){
              Toast.makeText(getActivity(), "please enter your email", Toast.LENGTH_SHORT).show();
          }
          if(TextUtils.isEmpty(id)){
              Toast.makeText(getActivity(), "please enter your ID", Toast.LENGTH_SHORT).show();
          }
          else {
                         fbdatabase=FirebaseDatabase.getInstance();
           reference=fbdatabase.getReference("UsersStudent");
            RegisterModelForStudent modelForStudent=new RegisterModelForStudent(name,phone,email,id);
           reference.child("studentInfo").setValue(modelForStudent);
              Toast.makeText(getActivity(), "Successful Registertion..", Toast.LENGTH_SHORT).show();

          }



      }

}
