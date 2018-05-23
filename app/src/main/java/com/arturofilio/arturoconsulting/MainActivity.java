package com.arturofilio.arturoconsulting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.arturofilio.arturoconsulting.Model.ListExercises;
import com.arturofilio.arturoconsulting.Model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegister;
    RelativeLayout rootLayout;

    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Berfore setContentView
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Arkhip_font.ttf").setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_main);

        //Init Firebase
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        //Init View
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        rootLayout = (RelativeLayout)findViewById(R.id.rootLayout);

        //Event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterDialog();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginDialog();
            }
        });

    }

    private void showLoginDialog() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("SIGN IN");
        dialog.setMessage("Please use email to sign in");

        LayoutInflater inflater = LayoutInflater.from(this);
        View login_layout = inflater.inflate(R.layout.layout_login, null);

        final MaterialEditText userEmail = login_layout.findViewById(R.id.userEmail);
        final MaterialEditText userPassword = login_layout.findViewById(R.id.userPassword);

        dialog.setView(login_layout);

        //Set button
        dialog.setPositiveButton("SIGN IN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();

                        //Check validation
                        if (TextUtils.isEmpty(userEmail.getText().toString())) {
                            Snackbar.make(rootLayout, "Please enter email address", Snackbar.LENGTH_SHORT)
                                    .show();
                            return;
                        }

                        if (TextUtils.isEmpty(userPassword.getText().toString())) {
                            Snackbar.make(rootLayout, "Please enter a password", Snackbar.LENGTH_SHORT)
                                    .show();
                            return;
                        }

                        if (userPassword.getText().toString().length() < 6) {
                            Snackbar.make(rootLayout, "Please enter a password that is longer than 6 characters", Snackbar.LENGTH_SHORT)
                                    .show();
                            return;
                        }

                        //Login
                        auth.signInWithEmailAndPassword(userEmail.getText().toString(), userPassword.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        startActivity(new Intent(MainActivity.this, ListExercises.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(rootLayout, "Failed " + e.getMessage(), Snackbar.LENGTH_SHORT)
                                        .show();
                            }
                        });

                    }

                });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void showRegisterDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("REGISTER");
        dialog.setMessage("Please use email to register");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_layout = inflater.inflate(R.layout.layout_register, null);

        final MaterialEditText userEmail = register_layout.findViewById(R.id.userEmail);
        final MaterialEditText userPassword = register_layout.findViewById(R.id.userPassword);
        final MaterialEditText userName = register_layout.findViewById(R.id.userName);
        final MaterialEditText userPhone = register_layout.findViewById(R.id.userPhone);

        dialog.setView(register_layout);

        //Set button
        dialog.setPositiveButton("REGISTER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();

                //Check validation
                if(TextUtils.isEmpty(userEmail.getText().toString()))
                {
                    Snackbar.make(rootLayout, "Please enter email address", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if(TextUtils.isEmpty(userPhone.getText().toString()))
                {
                    Snackbar.make(rootLayout, "Please enter phone number", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if(TextUtils.isEmpty(userPassword.getText().toString()))
                {
                    Snackbar.make(rootLayout, "Please enter a password", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if(userPassword.getText().toString().length() < 6)
                {
                    Snackbar.make(rootLayout, "Please enter a password that is longer than 6 characters", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                if(TextUtils.isEmpty(userName.getText().toString()))
                {
                    Snackbar.make(rootLayout, "Please enter a username", Snackbar.LENGTH_SHORT)
                            .show();
                    return;
                }

                //Register new user
                auth.createUserWithEmailAndPassword(userEmail.getText().toString(), userPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                //Save user to the database;
                                User user = new User();
                                user.setEmail(userEmail.getText().toString());
                                user.setName(userName.getText().toString());
                                user.setPassword(userPassword.getText().toString());
                                user.setPhone(userPhone.getText().toString());

                                //Use email to key
                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(rootLayout, "Registered account suscessfully", Snackbar.LENGTH_SHORT)
                                                        .show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Snackbar.make(rootLayout, "Failed " + e.getMessage(), Snackbar.LENGTH_SHORT)
                                                        .show();
                                            }
                                        });
                            }
                        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(rootLayout, "Failed " + e.getMessage(), Snackbar.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });

        dialog.show();
    }
}
