package com.example.temadam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonRead {
    public void readJson(String paramUrl, IResponse response){
        try {
            URL url=new URL(paramUrl);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

            InputStream inputStream=httpURLConnection.getInputStream();
            InputStreamReader streamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(streamReader);

            StringBuilder builder=new StringBuilder();
            String line="";

            while((line=bufferedReader.readLine())!=null){
                builder.append(line);
            }

            List<Antrenament> antrenamentList=jsonParsing(builder.toString());

            response.onSuccess(antrenamentList);

            bufferedReader.close();
            streamReader.close();
            inputStream.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
    }

    private List<Antrenament> jsonParsing(String jsonString){

        List<Antrenament> jsonList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(jsonString);
            JSONArray jsonArray=jsonObject.getJSONArray("antrenamente");

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject object=jsonArray.getJSONObject(i);
                String denumire=object.getString("denumire");
                Integer durata=object.getInt("durata");
                String echipament=object.getString("echipament");

                Antrenament antrenament=new Antrenament(denumire, durata, echipament);
                jsonList.add(antrenament);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonList;
    }
}
