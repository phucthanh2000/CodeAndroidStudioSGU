package com.example.tuan8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8;
    private Button btn;
    private String ten_mon;
    private WebView web;
    private int id;
    private boolean dong_y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       setMain();
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

    }

    public void setMain(){
        img1 = (ImageView) this.findViewById(R.id.image1);
        img2 = (ImageView) this.findViewById(R.id.image2);
        img3 = (ImageView) this.findViewById(R.id.image3);
        img4 = (ImageView) this.findViewById(R.id.image4);
        img5 = (ImageView) this.findViewById(R.id.image5);
        img6 = (ImageView) this.findViewById(R.id.image6);
        img7 = (ImageView) this.findViewById(R.id.image7);
        img8 = (ImageView) this.findViewById(R.id.image8);





        img1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image1;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_ga);
                setButton();
//                if(order())
//                    sendSMS(img1.getId());
            }
        });
        img2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image2;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_suon);

                setButton();
            }
        });
        img3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image3;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_xa_xiu);

                setButton();
            }
        });
        img4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image4;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_heo_quay_gion);

                setButton();
            }
        });
        img5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image5;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_chien_hai_san);

                setButton();
            }
        });
        img6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image6;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_thit_kho_tau);

                setButton();
            }
        });
        img7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image7;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_bo_xao);

                setButton();
            }
        });
        img8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = R.id.image8;
                ten_mon = String.valueOf(findViewById(id).getTooltipText());
                setContentView(R.layout.com_ca_kho_tieu);

                setButton();
            }
        });
    }

    public boolean onSupportNavigateUp(){
        setContentView(R.layout.main);
        setMain();
        return true;
    }

    public boolean order(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác Nhận Đặt Món?");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendSMS();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dong_y = false;
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
        return dong_y;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lien_he, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.lien_he:
                lienHe();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void lienHe(){
        setContentView(R.layout.dia_chi);
        web = (WebView) findViewById(R.id.dia_chi);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl("https://www.google.com/maps/place/Tr%C6%B0%E1%BB%9Dng+%C4%90%E1%BA%A1i+h%E1%BB%8Dc+S%C3%A0i+G%C3%B2n/@10.7599171,106.6800696,17z/data=!3m1!4b1!4m5!3m4!1s0x31752f1b7c3ed289:0xa06651894598e488!8m2!3d10.7599171!4d106.6822583?hl=vi-VN");
    }

    public void setButton(){
        btn = (Button) findViewById(R.id.button_dat_hang);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order();
            }
        });
    }

    public void sendSMS(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions, 1);
            }
        }
        SmsManager sms = SmsManager.getDefault();
        PendingIntent pi = PendingIntent.getActivity(this, 0,new Intent(this, MainActivity.class), 0);
        sms.sendTextMessage("0333352896",null, ten_mon, pi, null);
        setContentView(R.layout.main);
    }
}