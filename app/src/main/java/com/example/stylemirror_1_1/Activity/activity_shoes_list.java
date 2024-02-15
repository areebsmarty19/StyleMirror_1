package com.example.stylemirror_1_1.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.databinding.ActivityShoesListBinding;

import java.util.ArrayList;

public class activity_shoes_list extends AppCompatActivity {
    ActivityShoesListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoesListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        itemlistRecyclerView();
    }
    private void itemlistRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain(4,"TRENDUTY Canvas Shoes for men","shoes1",15,4.1,852,"Allow your pair of shoes to air and de-odorize at\n"+
                "regular basis; use shoe bags to prevent any stains\n"+
                "or mildew; dust any dry dirt from the surface \n"+
                "using a clean cloth; do not use polish or shiner\n" +
                "TrenDuty represents the fashionable shoes range \n"+
                "from the Imported sneakers and canvas style of wears.\n"+
                "The fashion crowd is moving toward the wild and dramatic\n"+
                "styles rather than the simple and elegant ones.\n"+
                "TrenDuty All Sports Short Sneakers presents such a\n"+
                "fusion of classy and funky range of imported sneakers\n"+
                "for the youth who wants to look confident, with comfort\n"+
                "and style on his side, wants full control of his life."));
        items.add(new PopularDomain(5,"Air Max 270 Sneakers","shoes2",10,4,9796,"Wipe with clean cloth Nike's first lifestyle \n"+
                "Air Max brings you style, comfort and big \n"+
                "attitude in the Nike Air Max 270. The design \n"+
                "draws inspiration from Air Max icons, showcasing\n"+
                "Nike's greatest innovation with its large window\n"+
                "and fresh array of colours."));
        items.add(new PopularDomain(6,"AIR ZOOM PEGASUS 36 Running","shoes3",5,4.3,3000,"Nike Air Zoom Pegasus 36-Men's\n"+
                "Running Shoe-AN ICON GETS SLIMMER AND COOLER.\n"+
                "The iconic Nike Air Zoom Pegasus 36 returns with\n"+
                "more perforations and engineered mesh in the upper\n"+
                "that strategically target breathability across high-heat\n"+
                "areas. A slimmer heel collar and tongue reduce bulk\n"+
                "without compromising comfort, while exposed Flywire\n"+
                "cables give you a snug fit at higher speeds. Perforations\n"+
                "on upper enhance breathability in forefoot and arch.\n"+
                "Full-length Zoom Air unit provides a smooth,responsive ride.\n"+
                "Slimmer design reduces bulk for a comfortable,conforming fit."));
        items.add(new PopularDomain(7,"NIKE Men's Air Max 90 Running Shoe","shoes4",0,0,11890,"Wipe with clean cloth Nike's first lifestyle \n"+
                "Air Max brings you style, comfort and big \n"+
                "attitude in the Nike Air Max 270. The design \n"+
                "draws inspiration from Air Max icons, showcasing\n"+
                "Nike's greatest innovation with its large window\n"+
                "and fresh array of colours."));
        items.add(new PopularDomain(8,"Jordan 1 Retro High OG Bordeaux Men's Basketball 555088-611","shoes5",30,4.5,50828,"The Air Jordan 1 High OG Rebellionaire is a unique colorway of\n"+
                "the vintage basketball shoe that takes inspiration from Nike's\n"+
                "1985 Banded commercial, specifically the ad's They can't stop you\n"+
                "from wearing them slogan A March 2021 release, the “Rebel” \n"+
                "comes in the same color block as the original “Shadow” colorway\n"+
                "of the Jordan 1, featuring distressed leather panels and printed\n+" +
                "lettering throughout the design. Gray leather panels on the \n"+
                "perforated toe, collar, heel, and Swoosh on both side\n"+
                "“They Can't Stop You Wearing” print inspired by the above\n"+
                "Jordan 1 “Banned” commercial Red “X’s” are found on the heel,\n"+
                "similar in appearance to the Air Jordan 1 High OG “Band”\n" +
                "graffiti-style branding printed on black leather overlays\n"));
        items.add(new PopularDomain(9,"Nike Viale Premium Men's Running Shoes","shoes6",0,0,5695,"Nike Viale Premium Men's Running Shoes\n" +
                "NIKE men's running shoes\n"));
        binding.productList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.productList.setAdapter(new PopularAdapter(items,this));
    }
}