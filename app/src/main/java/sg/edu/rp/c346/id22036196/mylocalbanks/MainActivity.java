package sg.edu.rp.c346.id22036196.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    Button getBtnDBSc;
    Button getBtnOCBCc;
    Button getBtnUOBc;
    String wordClicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS=findViewById(R.id.buttonDBS);
        btnOCBC=findViewById(R.id.buttonOCBC);
        btnUOB=findViewById(R.id.buttonUOB);

        btnDBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                Intent intentCall=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+1800111111));
                startActivity(intent);
            }
        });

        btnOCBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                Intent intentCall=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+1800363333));
                startActivity(intent);
            }
        });

        btnUOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                Intent intentCall=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+1800222212));
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            getBtnDBSc.setText("星展银行");
            getBtnOCBCc.setText("华侨银行");
            getBtnUOBc.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Chinese");
        if (v==btnDBS) {
            wordClicked = "DBS";
        }else if(v==btnOCBC) {
            wordClicked = "OCBC";
        }else{
            wordClicked="UOB";
        }
    }
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("Website")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "Website is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Hello");
                return true;
            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Contacting the bank", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Ciao");
                return true;
            }
        }
        return super.onContextItemSelected(item);

}