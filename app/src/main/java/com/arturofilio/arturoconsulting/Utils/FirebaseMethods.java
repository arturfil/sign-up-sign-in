package com.arturofilio.arturoconsulting.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.arturofilio.arturoconsulting.Model.User;
import com.arturofilio.arturoconsulting.Model.UserAccountSettings;
import com.arturofilio.arturoconsulting.Model.UserSettings;
import com.arturofilio.arturoconsulting.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseMethods {

    private static final String TAG = "FirebaseMethods";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListerner;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String userID;

    private Context mContext;

    public FirebaseMethods(Context context) {
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        mContext = context;

        if(mAuth.getCurrentUser() != null) {
            userID = mAuth.getCurrentUser().getUid();
        }
    }

    public boolean checkIfUsernameExists(String username, DataSnapshot dataSnapshot) {
        Log.d(TAG, "chekcIfUsernameExists: checking if " + username + " already exists");

        User user = new User();

        for (DataSnapshot ds: dataSnapshot.child(userID).getChildren()) {
            Log.d(TAG, "checkIfUsernameExists: datasnapshot" + ds);

            user.setName(ds.getValue(User.class).getName());
            Log.d(TAG, "chekcIfUsernameExists: name" + user.getName());

            if(StringManipulation.expandUsername(user.getName()).equals(username)){
                Log.d(TAG, "chekcIfUsernameExists: FOUND A MATCH" + user.getName());
                return true;
            }
        }

        return false;
    }

    /**
     * Register a new email, password and username to Firebase Auth.
     * @param email
     * @param password
     * @param username
     */
    public void registerNewEmail(final String email, String password, final String username){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        //If sign in fails, display a message to the user. If sign in succeeds
                        //the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(mContext, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else if (task.isSuccessful()) {
                            //send verification email
                            sendVerificationEmail();

                            userID = mAuth.getCurrentUser().getUid();
                            Log.d(TAG, "onComplete: Authstate changed: " + userID);
                        }

                    }
                });
    }

    //Add information to the users node
    // information to the user_account_settings

    public void sendVerificationEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                            } else {
                                Toast.makeText(mContext, "couldn't send verification email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void addNewUser(String email, String name, String description, String phone, String fat, String bmi,
                           String muscle_mass, String daily_activity, String height, String weight,
                           String prophile_photo) {
        User user = new User(userID, email, StringManipulation.condenseUsername(name), phone);

        myRef.child( mContext.getString(R.string.dbname_users))
                .child(userID)
                .setValue(user);

        UserAccountSettings settings = new UserAccountSettings(
                description,
                0,
                0,
                StringManipulation.condenseUsername(name),
                0,
                0,
                0,
                0,
                0,
                0,
                prophile_photo
        );

        myRef.child(mContext.getString(R.string.dbname_user_account_settings))
                .child(userID)
                .setValue(settings);

    }

    /**
     * retrieves the account settings for the user currently logged in
     * Database: user_account_settings node
     * @param dataSnapshot
     * @return
     */
    public UserSettings getUserSettings(DataSnapshot dataSnapshot) {
        Log.d(TAG, "getUserAccountSettings: retrieving user account settings form firebase");

        UserAccountSettings settings = new UserAccountSettings();
        User user = new User();

        for(DataSnapshot ds: dataSnapshot.getChildren()) {

            // user_account_settings node
            if(ds.getKey().equals(mContext.getString(R.string.dbname_user_account_settings))) {

                Log.d(TAG, "getUserAccountSettings: getUserAccountSettings: datasnapshot: " + ds);

                try {

                    settings.setName(
                            ds.child(userID)
                            .getValue(UserAccountSettings.class)
                            .getName()
                    );

                    settings.setDescription(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getDescription()
                    );

                    settings.setFriends(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getFriends()
                    );

                    settings.setPhotos(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getPhotos()
                    );

                    settings.setFat(
                            ds.child(userID)
                            .getValue(UserAccountSettings.class)
                            .getFat()
                    );

                    settings.setBmi(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getBmi()
                    );

                    settings.setMuscle_mass(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getMuscle_mass()
                    );

                    settings.setDaily_activity(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getDaily_activity()
                    );

                    settings.setHeight(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getHeight()
                    );

                    settings.setWeight(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getWeight()
                    );

                    settings.setProfile_photo(
                            ds.child(userID)
                                    .getValue(UserAccountSettings.class)
                                    .getProfile_photo()
                    );

                    Log.d(TAG, "getUserAccountSettings: retrieved user_account_settings information: " + settings.toString());

                } catch (NullPointerException e) {
                    Log.e(TAG, "getUserAccountSettings: NullPointerException: " + e.getMessage() );
                }
            }

            // users node
            if(ds.getKey().equals(mContext.getString(R.string.dbname_users))) {

                Log.d(TAG, "getUserAccountSettings: getUserAccountSettings: datasnapshot: " + ds);

                user.setName(
                        ds.child(userID)
                                .getValue(User.class)
                                .getName()
                );

                user.setEmail(
                        ds.child(userID)
                                .getValue(User.class)
                                .getEmail()
                );

                user.setPhone(
                        ds.child(userID)
                                .getValue(User.class)
                                .getPhone()
                );

                user.setUser_id(
                        ds.child(userID)
                                .getValue(User.class)
                                .getUser_id()
                );

                Log.d(TAG, "getUserAccountSettings: retrieved users information: " + user.toString());

            }
        }

        return new UserSettings(user, settings);
    }

}
