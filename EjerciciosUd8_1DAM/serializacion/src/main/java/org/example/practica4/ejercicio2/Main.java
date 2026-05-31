package org.example.practica4.ejercicio2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main
{
    static void main()
    {
        try
        {
            String apiUrl = "https://opentdb.com/api.php?amount=1&category=18";

            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            in.close();

            Gson gson = new Gson();
            Trivial trivial = gson.fromJson(json.toString(), Trivial.class);

            System.out.println("Pregunta: "+ trivial.results.get(0).question);
            int pos = 1;
            System.out.println("\t"+ pos +". "+ trivial.results.get(0).correct_answer);
            for(String wrongAnswer : trivial.results.get(0).incorrect_answers)
                System.out.println("\t"+ (++pos) +". "+ wrongAnswer);
        }
        catch(Exception e)
        {
            System.out.println("Algo ha salido mal.");
            e.printStackTrace();
        }
    }
}
