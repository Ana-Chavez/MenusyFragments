package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.mascotas.adapter.MascotaAdaptador;
import com.example.mascotas.adapter.PageAdapter;
import com.example.mascotas.fragment.ListaFragment;
import com.example.mascotas.fragment.PerfilFragment;
import com.example.mascotas.menu.AcercaDeActivity;
import com.example.mascotas.menu.ContactoActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabSubir;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabSubir = (FloatingActionButton) findViewById(R.id.fabSubir);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }

        fabSubir.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Subir nueva mascota", Toast.LENGTH_SHORT).show();
        });
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListaFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_lista);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.afavoritos){
            Intent intentFav = new Intent(this, FavoritosActivity.class);
            startActivity(intentFav);
            return true;
        } else if (item.getItemId() == R.id.mContacto) {
            Intent intent = new Intent(this, ContactoActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.mAcerca) {
            Intent i = new Intent(this, AcercaDeActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
