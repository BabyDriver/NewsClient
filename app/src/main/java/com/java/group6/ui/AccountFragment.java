package com.java.group6.ui;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.java.group6.R;


public class AccountFragment extends Fragment implements MyOneLineView.OnRootClickListener
{
    private MyOneLineView settingsView;
    private Button favoriteBtn, downloadBtn;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        favoriteBtn = view.findViewById(R.id.collectionBtn);
        favoriteBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(getContext(), FavoriteActivity.class);
                    startActivity(intent);
                }
            });
        downloadBtn = view.findViewById(R.id.downloadBtn);
        downloadBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), DownloadsActivity.class);
                startActivity(intent);
            }
        });
        settingsView = view.findViewById(R.id.settingsView);
        settingsView = settingsView
                .initMine(R.drawable.ic_settings_black_24dp, getString(R.string.title_activity_settings), "", false)
                .showDivider(false, false)
                .setOnRootClickListener(this, 1);
        return view;
    }

    @Override
    public void onRootClick(View view)
    {
        switch ((int) view.getTag())
        {
            case 1:
                Intent intent = new Intent(getContext(), SettingsActivity.class);
                intent.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT,
                        SettingsActivity.GeneralPreferenceFragment.class.getName());
                intent.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true);
                startActivityForResult(intent, 2);
                break;
        }
    }

}

