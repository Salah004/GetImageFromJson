package dssi.apps.getimagefromjson;

/**
 * Created by younessennadj on 5/14/16.
 */

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Utilisateur on 12/05/2016.
 */
public class HttpAsyncTask extends AsyncTask< String , Void , String > {

    @Override
    protected String doInBackground(String... strings) {
        InputStream inputStream = null;
        String result = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strings[0]);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            inputStream = conn.getInputStream();
            if (inputStream != null) result = convertToString(inputStream);
            else result = "";
        } catch (Exception ex) {
            result = ex.getMessage();
        } finally {
            conn.disconnect();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
    }
    private String convertToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String Result = "";
        while ((line = bufferedReader.readLine()) != null) {
            Result += line;
        }
        return Result;
    }
}