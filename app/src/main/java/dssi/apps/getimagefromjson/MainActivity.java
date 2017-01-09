package dssi.apps.getimagefromjson;

import android.app.*;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.IntBuffer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView img ;
    private TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.img);
        tv = (TextView)findViewById(R.id.tv);
    }
    public void onLoad(View view) {
       try{
            Service service = new Service();
            ArrayList<Item> items = service.getItems();
            tv.setText(items.get(1).getTv());
            img.setImageBitmap(items.get(1).getIc());
        }catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}
