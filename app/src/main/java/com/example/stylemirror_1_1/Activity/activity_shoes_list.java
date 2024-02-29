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
        items.add(new PopularDomain(1,"Air Max 270 Sneakers For Men","shoess_1",0,4,9796,"Wipe with clean cloth Nike's first lifestyle Air Max brings you style, comfort and big attitude in the Nike Air Max 270. The design draws inspiration from Air Max icons, showcasing Nike's greatest innovation with its large window and fresh array of colours."));
        items.add(new PopularDomain(2,"Nike Viale Premium Men's Running Shoes","shoess_2",0,0,5695,"Nike Viale Premium Men's Running Shoes NIKE men's running shoes"));
        items.add(new PopularDomain(3,"Imba M Running Shoes For Men","shoess_3",0,4.1,1852,""));
        items.add(new PopularDomain(4,"BADLAV® Air Force Black Sneakers for Men","shoess_4",0,3.3,491,"Design Concept: Sports Fusion Fashion, technology used in the upper and sole material. Application of skin-friendly Suede and TPR Outsole,strict machine suture. Material: Innovative use of skin-friendly Suede for a optimal breathable comfortable & lightweight feeling.Quickly absorb sweat and drying friendly,make feet cool and dry. Sole: High-quality rubber sole for lightweight cushioning. Vertical and horizontal flex grooves give you flexibility in all directions. Don’t crease and easy to clean Characteristics: Antimicrobial lining minimizes the risk of odor causing bacteria.Anti-odor technology applied to footbed to prevent the growth of odor-causing microbes."));
        items.add(new PopularDomain(5,"Blue Shades Clouded Sky Personalized Sneakers Lightweight Walking Shoes","shoess_5",0,0,0,"Materials: Breathable suede Upper + Non Slip Rubber Sole. Breathable suede Upper upper material make it possible that your feet to breathe freely while running or walking; Rubber sole adapts to ground stability and working strategy to optimize unique performance per bump and push. Applications: It's walking shoes, sneakers, running shoes, jogging shoes, gym sports, work out, exercise shoes, fabric sneakers, stretchy sneakers, training, flexible, fitness, mesh flats. Size: Please read the size details in the left image before purchase. The colour maybe different from the picture shown due to the different screen of display or reflecting light when shooting. Best for Gifts: The perfect gift to share with your families, girlfriend/friends on birthdays, Holiday, Halloween, Teacher's Day, Mother's Day, Thanksgiving Day, and Christmas day etc.Unique Design: A variety of colorful prints and Personalized patterns, Please click on our store to find more different styles."));
        items.add(new PopularDomain(6,"NIKE Mens Full Force LoRunning Shoe","shoess_6",0,2.9,5947,"•\tNIKE FULL FORCE LO-WHITE/MYSTIC RED-BLACK-SAIL-FB1362-102-7UK"));
        binding.productList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.productList.setAdapter(new PopularAdapter(items,this));
    }
}