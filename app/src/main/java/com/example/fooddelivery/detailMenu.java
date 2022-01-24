package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class detailMenu extends AppCompatActivity {

    ImageView imageView;
    TextView textView1;
    TextView textView2;
    TextView textView3;

    EditText editText;
    Button backbtn;
    Button orderbtn;

    int image;
    String menu;
    String rating;
    int price;


    int page;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        Bundle bundle = getIntent().getExtras();
//        value = getIntent().getStringExtra("usernameVar");

        imageView = (ImageView) findViewById(R.id.menuImg);
        textView1 = (TextView) findViewById(R.id.detailMenu);
        textView2 = (TextView) findViewById(R.id.detailPrice);
        textView3 = (TextView) findViewById(R.id.detailRating);

        editText = (EditText) findViewById(R.id.quantityDetail);
        backbtn = (Button) findViewById(R.id.backBtn);
        orderbtn = (Button) findViewById(R.id.orderBtn);

        image = bundle.getInt("menuImg");
        menu = bundle.getString("detailMenu");
        price = bundle.getInt("detailPrice");
        rating = bundle.getString("detailRating");

        page = bundle.getInt("page");

        imageView.setImageResource(image);
        textView1.setText(menu);
        textView2.setText("Price: " + price);
        textView3.setText(rating);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page == 1){
                    Intent intent = new Intent(detailMenu.this, Home.class);
                    startActivity(intent);
                }else{
                    Intent intent2 = new Intent(detailMenu.this, MenuMakanan.class);
                    startActivity(intent2);
                }
            }
        });

        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("0")){
                    openDiagN();
                }else if(editText.getText().toString().equals("")){
                    openDiagN();
                }else{
                    openDiag();
                }
            }
        });
    }

    public void openDiag(){
        PopUpDialog popUpDialog = new PopUpDialog();
        popUpDialog.show(getSupportFragmentManager(), "Success Dialog");
    }

    public void openDiagN(){
        PopUpDialogN popUpDialogN = new PopUpDialogN();
        popUpDialogN.show(getSupportFragmentManager(), "Retry Dialog");
    }

    public static class PopUpDialog extends AppCompatDialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Order").setMessage("Success").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            return builder.create();
        }
    }

    public static class PopUpDialogN extends AppCompatDialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Order").setMessage("Please fill the quantity").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            return builder.create();
        }
    }
}