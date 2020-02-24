package rofik.sman3.tugas4;

import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailHero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);

        ImageView ivFoto;
        TextView namaHero,detailHero;
        Hero hero;

        namaHero = findViewById(R.id.nama_hero);
        detailHero = findViewById(R.id.detail_hero);
        ivFoto = findViewById(R.id.image_view);

        hero = getIntent().getParcelableExtra("Hero");
        assert hero != null;
        namaHero.setText(hero.getName());
        detailHero.setText(hero.getDes());
        Glide.with(getApplicationContext()).load(hero.getPicture())
                .apply(new RequestOptions().override(400,300))
                .into(ivFoto);






    }
}
