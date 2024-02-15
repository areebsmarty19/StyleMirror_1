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
        items.add(new PopularDomain(10,"LENSKART AIR Classic","specs1",0,0,1099,"Features Blue Cut lens technology that helps\n"+
                "protect your eyes by blocking harmful blue light\n"+
                "emitted by digital devices like your smartphone and\n"+
                "computer as well as filtering UV rays from the sun.\n"+
                "Does it. These lenses are anti glare and crack resistant,\n"+
                "offer UV400 protection and are hydrophobic and dust repellent.\n" +
                "Frame Material: Featuring premium spectacles in Green\n"+
                "Half Rim Round from Lenskart. Made from stainless steel\n"+
                "which is lightweight and offers high strength making it an\n"+
                "ideal choice for men and women making them a perfect\n"+
                "pair for everyday use.\n"));
        items.add(new PopularDomain(11,"ARZONAI Men's Round Sunglasse","specs2",0,1,299,"Junior Round Uv Protected Sunglasses\\n\" +\n" +
                "Rayban is the global leader in premium eyeglasses\n" +
                "and by far the best selling eyeglasses brand in the world.\n" +
                "Each pair of sunglasses comes with a case and lens\n" +
                "cloth to clean and protect them from scratches and damage."));
        items.add(new PopularDomain(12,"Smith Caper Chromapop Polarized Sunglasses","specs3",5,4.3,26500,"Chromepop polarized. Our ChromaPop polarized lenses are\n"+
                "optically tuned to give you visual comfort and impact\n"+
                "protection while offering anti-reflective, water and \n"+
                "oil resistant coatings with 100% UV protection.\n" +
                "Anti-reflective coating. Vacuum applied, anti-reflective\n"+
                "coatings on the back side of the lenses will\n"+
                "eliminate annoying sidelight reflections. Hydrolyophobic\n"+
                "Water and oil proof coating repels moisture, oil and grime.\n"+
                "A barrier between your lens and the world. The water will\n"+
                "bead and spread without streaks. Smudges from fingerprints\n"+
                "are easily cleaned. Develop eco-material construction.\n"+
                "Our proprietary developed materials comprise 53% \n"+
                "bio-based materials in our injection-polymer sunglasses.\n"+
                "Smith Sunglasses is the world's largest sunglasses collection.\n"));
        items.add(new PopularDomain(13,"Optify Eye Protection Oval Blue Cut Computer Glasses","specs4",0,0,399,"Our round anti-glare blue cut glasses are\n" +
                "made of high quality alloy metal material, and the full \n" +
                "frame glasses are medium in size and made to fit comfortably.\n" +
                "Blue Light Blocking Glasses - Reduces blue light up to 98%.\n" +
                " Eye fatigue, dryness and vision loss can all be reduced\n" +
                "with this treatment. Why is there blue cut glass?\n" +
                " We live in a world dominated by screens, spending \n" +
                "an average of nine hours a day in front of them.\n" +
                " All of these devices emit blue light, which can be \n" +
                "harmful to our eyes because they are not shielded from\n" +
                " overexposure. > Headaches and migraines are possible\n " +
                "side effects, as are mental and physical fatigue,\n" +
                " eye strain and dry eyes, and sleep disturbances.\n"));
        items.add(new PopularDomain(14,"Rmerom Y2K Sunglasses","specs5",30,4.5,4498,"Y2k sunglasses are very light and comfortable,\n" +
                "wrap-around shield design, more fit for the eyes,\n" +
                "fixed nose bridge design, will not fall off, you can use\n" +
                " them for driving. Very nice looking, these y2k glasses\n" +
                " are very suitable for women Y2K Sunglasses:\n" +
                " This is a stylish pair of y2k glasses with a huge \n" +
                "one piece lens that wraps around the eye, the rimless \n" +
                "shield wrap around sunglasses are classic y2k accessories\n" +
                "from the 2000s. Comfortable to wear all day, indoors,\n" +
                "outdoors and all year round. A stylish gift for women!\n" +
                "y2k Accessories: These sunglasses are so swag. They make\n" +
                "you feel so swag as you walk down the street every day.\n" +
                " Bring 2000s sunglasses to parties, shopping, traveling,\n" +
                " you must be the brightest existence. It is also a\n" +
                " must-have fashion item for street photographers."));
        items.add(new PopularDomain(15,"ARZONAI Classic Aviator Metal Unisex Sunglasses","specs6",0,0,249,"This fashionable retro vintage sunglasses design is the\n" +
                " most popular style of sunglasses selling on Amazon.\n" +
                "The most suitable glasses for driving, sports, sailing,\n" +
                "skiing, traveling, styling, hunting outdoor tourism and\n" +
                "other occasions. Our Wayfarer sunglasses come in different \n" +
                "styles and different combinations. You can bring a different \n" +
                "sense of fashion. It is a good choice to collect or send to friends.\n"));
        items.add(new PopularDomain(16,"ARZONAI Round Men's and Women's Sunglasses","specs7",0,0,299,"Suitable for any face and suitable for men and women\n" +
                "CLASSIC ROUND SUNGLASSES: ARZONAI Metal Round Sunglasses are both luxurious and functional.\n" +
                "Made with a durable metal frame, these round \n" +
                "sunglasses are comfortable and protective.\n"+
                "Material:- Composite Frame,Composite Lens,\n" +
                "Frame Shape:- Oval Shape"));
        items.add(new PopularDomain(17,"SHAPES & SHADES Vintage Sunglasses","specs8",30,5,399,"Polarized & 100% UV Protection - 100% protection against\n" +
                "harmful UVA/UVB rays. UVA and UVB ultra violetn\n" +
                "locking lenses with additional polarization to \n" +
                "eliminate glare while maintaining color integrity.\n" +
                "6 months warranty and after sales services\n" +
                "Free fit for all with spring hinge arms.\n" +
                "Care Instructions: It is important to clean and \n" +
                "maintain them regularly. Simply spray some Aqualens\n" +
                "solution on your lenses and wipe them with a\n" +
                "microfiber cloth to keep your lenses smudge free.\n"));
        items.add(new PopularDomain(18,"Ray-Ban Men's Round Sunglasses","specs9",25,3.9,4690, "Junior Round Uv Protected Sunglasses\n" +
                "Rayban is the global leader in premium eyeglasses\n" +
                "and by far the best selling eyeglasses brand in the world.\n" +
                "Each pair of sunglasses comes with a case and lens\n" +
                "cloth to clean and protect them from scratches and damage."));
        binding.productList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.productList.setAdapter(new PopularAdapter(items,this));
    }
}