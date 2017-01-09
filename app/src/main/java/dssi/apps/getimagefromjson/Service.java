package dssi.apps.getimagefromjson;

/**
 * Created by younessennadj on 5/14/16.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.IntBuffer;
import java.util.ArrayList;
public class Service {
    public ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>() ;
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .encodedAuthority("192.168.1.5:3000")
                .appendPath("users");
        String url = builder.build().toString();
        try{
            String response = new HttpAsyncTask().execute(url).get();
            JSONArray array = new JSONArray(response);
            System.out.println("size : "+array.length());
            for( int i=0 ; i<array.length() ; i++ ){
                JSONObject obj = array.getJSONObject(i);
                String tv = obj.getString("ART_LIB");

                JSONObject art_image = obj.getJSONObject("ART_IMAGE");


                JSONArray entries = null;
                entries = new JSONArray(art_image.getString("data"));
                byte[] bArr = new byte[entries.length()];
                for (int j = 0; j < entries.length(); j++) {
                    bArr[j] = (byte) entries.getInt(j);
                }

                Bitmap bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                Item item = new Item(tv,bitmap);
                items.add(item);
            }
        }catch (Exception e){}
        return items;
    }
}