package org.ucarsu.ogul.jsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView tw;
    Button rawJsonData,JsonParseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw=(TextView)findViewById(R.id.tw);
        rawJsonData = (Button)findViewById(R.id.btn_rawJsonData);
        JsonParseData=(Button)findViewById(R.id.btn_JsonParseData);

        openScreen();

        JsonParseData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jsonParseData();
            }
        });

        rawJsonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rawJsonDataFunc();
            }
        });
    }

    private void rawJsonDataFunc() {

        InputStream stream = getResources().openRawResource(R.raw.json_data);
        Scanner scanner = new Scanner(stream);
        String data = "";

        while(scanner.hasNextLine())
        {
            data= data + scanner.nextLine()+ "\n";

        }
        tw.setText(data);

    }

    private void jsonParseData() {

        StringBuilder stringBuilder = new StringBuilder();
        InputStream stream= getResources().openRawResource(R.raw.json_data);
        try
        {
            byte buffer[]=new byte[stream.available()];
            while (stream.read(buffer)!=-1);
            String jsonData= new String(buffer);
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray person=jsonObject.getJSONArray("Person");

            for (int i =0; i<person.length();i++)
            {
                JSONObject object = person.getJSONObject(i);
                String id = object.getString("id");
                String name = object.getString("name");
                String surname = object.getString("surname");

                stringBuilder.append("ID : " + id + "\n" + "Name :" + name + "\n" + "Surname :" + surname + "\n");


            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        tw.setText(stringBuilder);

    }

    private void openScreen() {

        StringBuilder stringBuilder = new StringBuilder();
        InputStream stream= getResources().openRawResource(R.raw.json_data);
        try
        {
            byte buffer[]=new byte[stream.available()];
            while (stream.read(buffer)!=-1);
            String jsonData= new String(buffer);
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray person=jsonObject.getJSONArray("Person");

            for (int i =0; i<person.length();i++)
            {
                JSONObject object = person.getJSONObject(i);
                String id = object.getString("id");
                String name = object.getString("name");
                String surname = object.getString("surname");

                stringBuilder.append("ID : " + id + "\n" + "Name :" + name + "\n" + "Surname :" + surname + "\n");


            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        tw.setText(stringBuilder);



    }
}
