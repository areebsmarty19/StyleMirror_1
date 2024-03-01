package com.example.stylemirror_1_1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivitySpecsListBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;

import java.util.ArrayList;

public class activity_specs_list extends AppCompatActivity {

    ActivitySpecsListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpecsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        itemlistRecyclerView();
    }

    private void itemlistRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain(11,"Toughened Glass Lens","spects_1","","",0,8,1280,"Top of Form ,Currently one of the most iconic sunglass models in the world. This style of sunglasses is credited with being one of the first popularized style of sunglasses to be developed. In its military usage, the sunglasses replaced the outmoded flight goggles used previously, as they were lighter, thinner, and more elegantly designed. Aviate Classic sunglasses are a timeless model that combines great aviator styling with exceptional quality, performance and comfort. With a classic metal frame, you can see the world through a variety of lens colors including dark, gradient, mercury and day and night that provide optimum visual clarity and 100% UV protection.","https://www.flipkart.com/r-resist-aviator-sunglasses/p/itm8714c5ba8a2f7?pid=SGLGB57VKREAZ2CD&cmpid=product.share.pp&_refId=PP.56f6a20f-8a22-4954-b8ee-72160aad14e4.SGLGB57VKREAZ2CD&_appId=WA"));
        items.add(new PopularDomain(12,"Ray-Ban Men's Square Sunglasses","spects_2","","",4.1,7903,10497,"Material Composition","https://www.amazon.in/dp/B015EJWFZE?ref_=cm_sw_r_mwn_dp_9RBZACR5SD7GZE79K9ZF&language=en-IN"));
        items.add(new PopularDomain(13,"Ray-Ban Rb3447 Round Metal Sunglasses","spects_3","","",4.1,103,0,"Timeless Ray-Ban Round sunglasses feature retro round metal frames, a look worn by legendary musicians and inspired by 1960s counter-culture Round shape, matte gold metal frame, fixed crystal green polarized lenses that make these frames look real Featuring an iconic G-15 lens engineered to give you the clearest and most natural vision absorbing 85% of visible light and blocking most blue light, it delivers remarkable color contrast and visual clarity.","https://www.amazon.in/dp/B00UO05CY0?starsLeft=1&ref_=cm_sw_r_ud_dp_8E4FN75F8CGVDD2CQ7E4"));
        items.add(new PopularDomain(14,"UV Protected Unisex Sunglasses","spects_4","","",5,1,348,"A perfect blend of highly durable modern day materials styled with pure craftsmanship and the trust of thousands of customers.","https://www.amazon.in/dp/B0C4FBCJWC?starsLeft=1&ref_=cm_sw_r_ud_dp_K4CZRY9CVC6JAWEXRZ72"));
        items.add(new PopularDomain(15,"UV Protection Over-sized Sunglasses","spects_5","","",0,0,499,"Material Composition","https://www.flipkart.com/roadies-over-sized-sunglasses/p/itm64baf95355cf8?pid=SGLGCQXV4VHFYJU6&cmpid=product.share.pp&_refId=PP.bb17b692-b946-4e7d-bfc3-b36da09e6fe9.SGLGCQXV4VHFYJU6&_appId=WA"));
        items.add(new PopularDomain(16,"John Jacobs Brown Browline Polarized and UV Protected Sunglasses","spects_6","","",4.1,6,2807,"Material Composition UV protected","https://www.amazon.in/dp/B08YNRMZG7?starsLeft=1&ref_=cm_sw_r_ud_dp_3X17N14C1KJJX775HYGW"));
        items.add(new PopularDomain(17,"UV Protection Aviator Sunglasses","spects_7","","",0,0,1274,"Material Composition","https://www.flipkart.com/speksee-aviator-sunglasses/p/itm578b54233f383?pid=SGLGUE8U4ABQVH5Y&cmpid=product.share.pp&_refId=PP.306a0ee9-796a-457d-a55a-aee80e38ff9f.SGLGUE8U4ABQVH5Y&_appId=WA"));
        items.add(new PopularDomain(18,"Fastrack Mirrored Aviator Men's Sunglasses","spects_8","","",2.3,2,2295,"Material Composition","https://www.amazon.in/dp/B072B86W8D?starsLeft=1&ref_=cm_sw_r_ud_dp_25M4E28NEQ5H7ZS5AKN8"));
        items.add(new PopularDomain(19,"UV Protection Cat-eye Sunglasses","spects_9","","",0,22,404, "Material Composition","https://www.flipkart.com/jubilant-cat-eye-sunglasses/p/itm3de4bc213dbfa?pid=SGLG4GASS8MGUYHA&cmpid=product.share.pp&_refId=PP.1e1c2780-ba16-4b2d-8028-feade848aaca.SGLG4GASS8MGUYHA&_appId=WA"));
        items.add(new PopularDomain(20,"Riding Glasses Wayfarer Sunglasses","spects_10","","",0,0,182, "The amazing accessories to enhance your style statement is Spectacles Frames. They are trendy and never really go out of style. Made of polycarbonate material our products are ergonomically designed to give you a comfortable head hugging fit. Thus providing all-day wearing comfort. Spectacles Frames have been designed keeping your comfort and care as our first priority. These Spectacles Frames are really light and have been made of high quality frame with Stunning Looks & Flashy Colors. Mehjabeen enterprise Frames give you 100% protection against harmful UVA/UVB rays and are polarized for your eye care. Stay young. What do You get? Sunglasses * 1 Sunglasses Case * 1 Cleaning Soft Cloth * 1 sunglasses for mens sunglasses for women stylish sunglasses for women sunglasses for men.","https://www.flipkart.com/mehj-wayfarer-sunglasses/p/itm2cce43ba560ac?pid=SGLGREWQMDHCP66F&cmpid=product.share.pp&_refId=PP.381b1f8c-8b1a-41ce-8dcd-24c783564627.SGLGREWQMDHCP66F&_appId=WA"));
        binding.productList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.productList.setAdapter(new PopularAdapter(items,this));
    }
}