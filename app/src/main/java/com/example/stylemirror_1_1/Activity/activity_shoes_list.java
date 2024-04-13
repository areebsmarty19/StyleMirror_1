package com.example.stylemirror_1_1.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.R;
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
        items.add(new PopularDomain(1,"Air Max 270 Sneakers For Men","shoess_1_1","shoess_1_2","shoess_1_3",5,100,8921,"Wipe with clean cloth Nike's first lifestyle Air Max brings you style, comfort and big attitude in the Nike Air Max 270. The design draws inspiration from Air Max icons, showcasing Nike's greatest innovation with its large window and fresh array of colours.","https://www.flipkart.com/nike-air-max-270-sneakers-men/p/itm1d9717048f829?pid=SHOGQZKYZYC3K2B4&cmpid=product.share.pp&_refId=PP.1f10854d-aa61-4c99-a442-686cc67a67a6.SHOGQZKYZYC3K2B4&_appId=WA"));
        items.add(new PopularDomain(2,"Nike Viale Premium Men's Running Shoes","shoess_2_1","shoess_2_2","shoess_2_3",0,0,5695,"Nike Viale Premium Men's Running Shoes NIKE men's running shoes","https://www.amazon.in/Nike-Viale-Premium-Running-Numeric_7/dp/B0BTPVLLPL/ref=sr_1_4?dib=eyJ2IjoiMSJ9.hbzFw-M-hmtF21AcdjfXK3o9SF9pZNyCP4xenMzhimteP31pc2TemY-tIry1XmxJL2_zraO-yBE_yDKaiyVGDMtdj07Eh6qsOhJDfStAqdmG8nYV4-qtKc6E3nLZ5GYVh-mpC4e7GoWs2URRvrU_62ljLJ5R5obK73257xZzvAfcPntT1jDgij1YJs-Gav-JdTC9x87r2xeiL1YkzOGpFNW_63pNX1K31hyR-UGDyHg-JVF5S9HGx2WtzouzbBex.KUQ3ow71uTlLfiTteAgKMBA9rn0SXqdXKqWevspXO0c&dib_tag=se&keywords=nike+viale&qid=1709282802&sr=8-4"));
        items.add(new PopularDomain(3,"Imba M Running Shoes For Men","shoess_3_1","shoess_3_2","shoess_3_3",4.1,55,1859,"","https://www.flipkart.com/adidas-imba-m-running-shoes-men/p/itmf3xjvamur7zha?pid=SHOE25GFNHVSVVTZ&cmpid=product.share.pp&_refId=PP.7653c4f6-d2ec-4dc0-8ce4-829d9de18f84.SHOE25GFNHVSVVTZ&_appId=WA"));
        items.add(new PopularDomain(4,"BADLAV® Air Force Black Sneakers for Men","shoess_4_1","shoess_4_2","shoess_4_3",3.3,125,418,"Design Concept: Sports Fusion Fashion, technology used in the upper and sole material. Application of skin-friendly Suede and TPR Outsole,strict machine suture. Material: Innovative use of skin-friendly Suede for a optimal breathable comfortable & lightweight feeling.Quickly absorb sweat and drying friendly,make feet cool and dry. Sole: High-quality rubber sole for lightweight cushioning. Vertical and horizontal flex grooves give you flexibility in all directions. Don’t crease and easy to clean Characteristics: Antimicrobial lining minimizes the risk of odor causing bacteria.Anti-odor technology applied to footbed to prevent the growth of odor-causing microbes.","https://www.amazon.in/dp/B0CS9NBWHS?starsLeft=1&ref_=cm_sw_r_ud_dp_086PRN0QZT8W4PWN716G"));
        items.add(new PopularDomain(5,"Blue Shades Clouded Sky Personalized Sneakers Lightweight Walking Shoes","shoess_5_1","shoess_5_2","shoess_5_3",0,0,0,"Materials: Breathable suede Upper + Non Slip Rubber Sole. Breathable suede Upper upper material make it possible that your feet to breathe freely while running or walking; Rubber sole adapts to ground stability and working strategy to optimize unique performance per bump and push. Applications: It's walking shoes, sneakers, running shoes, jogging shoes, gym sports, work out, exercise shoes, fabric sneakers, stretchy sneakers, training, flexible, fitness, mesh flats. Size: Please read the size details in the left image before purchase. The colour maybe different from the picture shown due to the different screen of display or reflecting light when shooting. Best for Gifts: The perfect gift to share with your families, girlfriend/friends on birthdays, Holiday, Halloween, Teacher's Day, Mother's Day, Thanksgiving Day, and Christmas day etc.Unique Design: A variety of colorful prints and Personalized patterns, Please click on our store to find more different styles.","https://www.amazon.com/dp/B0C6V43KZ9?language=en_US&ref_=cm_sw_r_mwn_dp_PW6RXQJ67MJRMF5122VT"));
        items.add(new PopularDomain(6,"NIKE Mens Full Force LoRunning Shoe","shoess_6_1","shoess_6_2","shoess_6_3",3.8,8,6724,"NIKE FULL FORCE LO-WHITE/MYSTIC RED-BLACK-SAIL-FB1362-102-7UK","https://www.amazon.in/dp/B0CLYVZMNZ?starsLeft=1&ref_=cm_sw_r_ud_dp_ASNF7F2D38MPMRRR4AHK"));

        binding.productList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.productList.setAdapter(new PopularAdapter(items,this));
    }
}