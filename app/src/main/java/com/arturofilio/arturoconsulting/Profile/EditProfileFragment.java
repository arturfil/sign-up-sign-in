package com.arturofilio.arturoconsulting.Profile;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arturofilio.arturoconsulting.R;
import com.arturofilio.arturoconsulting.Utils.UniversalImageLoader;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_image);

        setProfileImage();
        return view;
    }


    private void setProfileImage() {
        Log.d(TAG, "setProfileImage: setting profile Image");
        String imgURL = "https://d2x5ku95bkycr3.cloudfront.net/App_Themes/Common/images/profile/0_200.png";
        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "");
    }
}
