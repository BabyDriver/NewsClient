package babydriver.newsclient.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import babydriver.newsclient.controller.MyApplication;
import babydriver.newsclient.model.NewsBrief;

public class DownloadsNewsShowFragment extends NewsShowFragment
{
    private ArrayList<String> news_list = new ArrayList<>();
    private int current;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        swipe_refresh_layout.setEnabled(false);
        return view;
    }

    @Override
    void listInitialize()
    {
        ArrayList<NewsBrief> list = new ArrayList<>();
        news_list.addAll(MyApplication.downloaded_list);
        Collections.sort(news_list);
        int n = news_list.size();
        current = n - 1;
        int s = 0;
        while (current >= 0 && s < 25)
        {
            s++;
            list.add(MyApplication.downloaded.get(news_list.get(current)));
            current--;
        }
        Log.e("size", list.size() + "");
        addAll(list);
        recycler_view.getAdapter().notifyDataSetChanged();
    }

    @Override
    void listAdd()
    {
        ((MyNewsRecyclerViewAdapter)recycler_view.getAdapter()).removeProgressBar();
        ArrayList<NewsBrief> list = new ArrayList<>();
        int s = 0;
        while (current >= 0 && s < 25)
        {
            s++;
            list.add(MyApplication.downloaded.get(news_list.get(current)));
            current--;
        }
        addAll(list);
    }

    @Override
    void listRefresh()
    {

    }
}
