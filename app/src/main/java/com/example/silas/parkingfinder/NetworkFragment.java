package com.example.silas.parkingfinder;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.io.Reader;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class NetworkFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String URL_KEY = "UrlKey";

    private String urlString = "";
    private DownloadCallback callback;

    public NetworkFragment() {
        // Required empty public constructor
    }


    public static NetworkFragment newInstance(String url) {
        NetworkFragment fragment = new NetworkFragment();
        Bundle args = new Bundle();
        args.putString(URL_KEY, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        urlString = getArguments().getString(URL_KEY);
        getData();


    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DownloadCallback) {
            callback = (DownloadCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    public void getData(){
        HttpTask httpTask = new HttpTask();
        httpTask.execute(urlString);
    }

     class HttpTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(strings[0])
                    .build();

            Response response;


            try {
                response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

         @Override
         protected void onPostExecute(String s) {
             super.onPostExecute(s);

             callback.showResult(s);
         }
     }


}
