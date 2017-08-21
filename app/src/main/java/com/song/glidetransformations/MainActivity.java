package com.song.glidetransformations;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.load.Transformation;
import com.song.glide_40_transformations.BlurTransformation;
import com.song.glide_40_transformations.ColorFilterTransformation;
import com.song.glide_40_transformations.CropCircleTransformation;
import com.song.glide_40_transformations.CropSquareTransformation;
import com.song.glide_40_transformations.CropTransformation;
import com.song.glide_40_transformations.GrayscaleTransformation;
import com.song.glide_40_transformations.MaskTransformation;
import com.song.glide_40_transformations.RoundedCornersTransformation;
import com.song.glide_40_transformations.gpu.BrightnessFilterTransformation;
import com.song.glide_40_transformations.gpu.ContrastFilterTransformation;
import com.song.glide_40_transformations.gpu.InvertFilterTransformation;
import com.song.glide_40_transformations.gpu.KuwaharaFilterTransformation;
import com.song.glide_40_transformations.gpu.PixelationFilterTransformation;
import com.song.glide_40_transformations.gpu.SepiaFilterTransformation;
import com.song.glide_40_transformations.gpu.SketchFilterTransformation;
import com.song.glide_40_transformations.gpu.SwirlFilterTransformation;
import com.song.glide_40_transformations.gpu.ToonFilterTransformation;
import com.song.glide_40_transformations.gpu.VignetteFilterTransformation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Transformation<Bitmap>> list = new ArrayList<>();
        list.add(new BlurTransformation(this, 15));
        list.add(new ColorFilterTransformation(this, R.color.colorAccent));
        list.add(new CropCircleTransformation(this));
        list.add(new CropSquareTransformation(this));
        list.add(new CropTransformation(this, 20, 20));
        list.add(new GrayscaleTransformation(this));
        list.add(new MaskTransformation(this, R.drawable.blackhole));
        list.add(new RoundedCornersTransformation(this, 20, 20));

        list.add(new BrightnessFilterTransformation(this));
        list.add(new ContrastFilterTransformation(this));
        list.add(new InvertFilterTransformation(this));
        list.add(new KuwaharaFilterTransformation(this));
        list.add(new PixelationFilterTransformation(this));
        list.add(new SepiaFilterTransformation(this));
        list.add(new SketchFilterTransformation(this));
        list.add(new SwirlFilterTransformation(this));
        list.add(new ToonFilterTransformation(this));
        list.add(new VignetteFilterTransformation(this));

        TransAdapter transAdapter = new TransAdapter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_trans);
        mRecyclerView.setAdapter(transAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        transAdapter.setData(list);
    }
}
