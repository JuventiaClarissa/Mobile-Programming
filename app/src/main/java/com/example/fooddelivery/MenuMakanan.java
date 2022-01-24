package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuMakanan extends AppCompatActivity {

    int menuImg[] = {R.drawable.mie, R.drawable.nasgor, R.drawable.rujak, R.drawable.soto, R.drawable.sate};
    String menu[] = {"Mie Goreng", "Nasi Goreng", "Rujak", "Soto", "Sate Ayam"};
    String rating[] = {"4/5", "5/5", "3.5/5", "5/5", "5/5"};
    int price[] = {25000, 24000, 19000, 23000, 22000};
    ListView listView;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makanan);

        listView = findViewById(R.id.menulistView);

        menuAdapter adapter = new menuAdapter(this,menuImg,menu,rating,price);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MenuMakanan.this, detailMenu.class);
                        intent.putExtra("menuImg", menuImg[position]);
                        intent.putExtra("detailMenu", menu[position]);
                        intent.putExtra("detailRating", rating[position]);
                        intent.putExtra("detailPrice", price[position]);
                        intent.putExtra("var", value);
                        startActivity(intent);
                    case 1:
                        Intent intent2 = new Intent(MenuMakanan.this, detailMenu.class);
                        intent2.putExtra("menuImg", menuImg[position]);
                        intent2.putExtra("detailMenu", menu[position]);
                        intent2.putExtra("detailRating", rating[position]);
                        intent2.putExtra("detailPrice", price[position]);
                        intent2.putExtra("var", value);
                        startActivity(intent2);
                    case 2:
                        Intent intent3 = new Intent(MenuMakanan.this, detailMenu.class);
                        intent3.putExtra("menuImg", menuImg[position]);
                        intent3.putExtra("detailMenu", menu[position]);
                        intent3.putExtra("detailRating", rating[position]);
                        intent3.putExtra("detailPrice", price[position]);
                        intent3.putExtra("var", value);
                        startActivity(intent3);
                    case 3:
                        Intent intent4 = new Intent(MenuMakanan.this, detailMenu.class);
                        intent4.putExtra("menuImg", menuImg[position]);
                        intent4.putExtra("detailMenu", menu[position]);
                        intent4.putExtra("detailRating", rating[position]);
                        intent4.putExtra("detailPrice", price[position]);
                        intent4.putExtra("var", value);
                        startActivity(intent4);
                    case 4:
                        Intent intent5 = new Intent(MenuMakanan.this, detailMenu.class);
                        intent5.putExtra("menuImg", menuImg[position]);
                        intent5.putExtra("detailMenu", menu[position]);
                        intent5.putExtra("detailRating", rating[position]);
                        intent5.putExtra("detailPrice", price[position]);
                        intent5.putExtra("var", value);
                        startActivity(intent5);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuHome:
                Intent intent = new Intent(MenuMakanan.this, Home.class);
                startActivity(intent);
                return true;
            case R.id.MenuMakanan:
                Intent intent2 = new Intent(MenuMakanan.this, Menu.class);
                startActivity(intent2);
                return true;
            case R.id.leftover:
                Intent intent3 = new Intent(MenuMakanan.this, leftover.class);
                startActivity(intent3);
                return true;
            case R.id.logOut:
                Intent intent4 = new Intent(MenuMakanan.this, MainActivity.class);
                startActivity(intent4);
                return true;
            case R.id.getLocation:
                Intent intent5 = new Intent(MenuMakanan.this, location.class);
                startActivity(intent5);
                return true;
            default:
                return false;
        }
    }

    class menuAdapter extends ArrayAdapter<String> {
        Context context;
        int menuImg[];
        String menu[];
        String rating[];
        int price[];


        menuAdapter(Context c, int menuImg[],  String menu[], String rating[], int price[]) {
            super(c, R.layout.layout_list, R.id.menu, menu);
            this.context = c;
            this.menuImg = menuImg;
            this.menu = menu;
            this.rating = rating;
            this.price = price;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layoutList = layoutInflater.inflate(R.layout.layout_list, parent, false);
            ImageView nImages = layoutList.findViewById(R.id.menuImg);
            TextView nMenu = layoutList.findViewById(R.id.menu);
            TextView nPrice = layoutList.findViewById(R.id.price);
            TextView nRating = layoutList.findViewById(R.id.rating);


            nImages.setImageResource(menuImg[position]);
            nMenu.setText(menu[position]);
            nPrice.setText("Harga: " + price[position]);
            nRating.setText("Rating: " + rating[position]);


            return layoutList;
        }
    }
}