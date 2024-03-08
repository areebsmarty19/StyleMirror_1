package com.example.stylemirror_1_1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.databinding.ActivityCosmeticsListBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;

import java.util.ArrayList;

public class activity_cosmetics_list extends AppCompatActivity {

    ActivityCosmeticsListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCosmeticsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        itemlistRecyclerView();
    }

    private void itemlistRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();

        //List of Lipstick.
        items.add(new PopularDomain(21, "Maybelline Color Sensational Lipstick Pink Thrill", "lips_1_1", "lips_1_2", "lips_1_3", 4.1, 34058, 1248, "Color Sensational The Creams delivers crisp color and smooth lips - Infused with Shea Butter, Color Sensational The Creams takes on a new feeling from the first touch of the packaging to the first swipe Color Sensational The Creams lipsticks deliver pure color pigments and Shea Butter for vibrant color, smooth lips and a creamy finish that does not bleed or feather Highly pigmented lip color with a creamy smooth glide during application that leaves lips feeling hydrated, nurtured, and conditioned Available in sensational lipstick shades you know and love - nudes, pinks, reds and plums - that are rich, warm and made to flatter your skin tone Color Sensational The Creams lipsticks now include your favorite shades from the Vivids and Buffs collections.", "https://www.amazon.in/Maybelline-Sensational-Lipstick-Hydrating-Packaging/dp/B07YXG7LSR"));
        items.add(new PopularDomain(22, "Maybelline New York Color Sensational Creamy Matte Lipstick", "lips_2_1", "lips_2_2", "lips_2_3", 4.1, 34058, 3937, "The Maybelline Color Sensational Creamy Mattes Lipstick has a unique, velvety matte cream formula that offers a non-drying & un-crackable finish that stays comfortably on your lips through the day These hydrating Maybelline lipstick shades are are infused with honey nectar to keep your lips moisturized all day long. The Colour Sensation lipsticks glide on your lips smoothly for a comfortable wear.The Color Sensational Creamy Matte Lipsticks are available in 30+ pigmented shades, from subtle nudes to bold reds and everything in between.Pair the Color Sensational Creamy Matte Lipstick with a nourishing Maybelline Lip Balm for colour and care!", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B00N6MLLGG/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(23, "Maybelline Color Sensational Lipstick Coral Rise", "lips_3_1", "lips_3_2", "lips_3_3", 4.1, 34058, 1693, "Color Sensational The Creams delivers crisp color and smooth lips - Infused with Shea Butter, Color Sensational The Creams takes on a new feeling from the first touch of the packaging to the first swipe Color Sensational The Creams lipsticks deliver pure color pigments and Shea Butter for vibrant color, smooth lips and a creamy finish that does not bleed or feather Highly pigmented lip color with a creamy smooth glide during application that leaves lips feeling hydrated, nurtured, and conditioned Available in sensational lipstick shades you know and love - nudes, pinks, reds and plums - that are rich, warm and made to flatter your skin tone Color Sensational The Creams lipsticks now include your favorite shades from the Vivids and Buffs collections.", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B07YXG7LSV/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(24, "Maybelline Color Sensational Lipstick Crimson Race", "lips_4_1", "lips_4_2", "lips_4_3", 4.1, 34058, 1269, "Color Sensational The Creams delivers crisp color and smooth lips - Infused with Shea Butter, Color Sensational The Creams takes on a new feeling from the first touch of the packaging to the first swipe Color Sensational The Creams lipsticks deliver pure color pigments and Shea Butter for vibrant color, smooth lips and a creamy finish that does not bleed or feather Highly pigmented lip color with a creamy smooth glide during application that leaves lips feeling hydrated, nurtured, and conditioned Available in sensational lipstick shades you know and love - nudes, pinks, reds and plums - that are rich, warm and made to flatter your skin tone Color Sensational The Creams lipsticks now include your favorite shades from the Vivids and Buffs collections.", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B07YXG19S3/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(25, "Maybelline Color Sensational Lipstick Bare Reveal", "lips_5_1", "lips_5_2", "lips_5_3", 4.1, 34058, 1793, "Color Sensational The Creams delivers crisp color and smooth lips - Infused with Shea Butter, Color Sensational The Creams takes on a new feeling from the first touch of the packaging to the first swipe Color Sensational The Creams lipsticks deliver pure color pigments and Shea Butter for vibrant color, smooth lips and a creamy finish that does not bleed or feather Highly pigmented lip color with a creamy smooth glide during application that leaves lips feeling hydrated, nurtured, and conditioned Available in sensational lipstick shades you know and love - nudes, pinks, reds and plums - that are rich, warm and made to flatter your skin tone Color Sensational The Creams lipsticks now include your favorite shades from the Vivids and Buffs collections.", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B07YXFYM3Z/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(26, "Maybelline Color Sensational Lipstick Naked Dare", "lips_6_1", "lips_6_2", "lips_6_3", 4.1, 34058, 0, "Color Sensational The Creams delivers crisp color and smooth lips - Infused with Shea Butter, Color Sensational The Creams takes on a new feeling from the first touch of the packaging to the first swipe Color Sensational The Creams lipsticks deliver pure color pigments and Shea Butter for vibrant color, smooth lips and a creamy finish that does not bleed or feather Highly pigmented lip color with a creamy smooth glide during application that leaves lips feeling hydrated, nurtured, and conditioned Available in sensational lipstick shades you know and love - nudes, pinks, reds and plums - that are rich, warm and made to flatter your skin tone Color Sensational The Creams lipsticks now include your favorite shades from the Vivids and Buffs collections.", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B07YXGG4D1/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(27, "Maybelline Color Sensational Matte Lipstick", "lips_7_1", "lips_7_2", "lips_7_3", 4.1, 34058, 1022, "Color Sensational The Creams delivers crisp color and smooth lips - Infused with Shea Butter, Color Sensational The Creams takes on a new feeling from the first touch of the packaging to the first swipe Color Sensational The Creams lipsticks deliver pure color pigments and Shea Butter for vibrant color, smooth lips and a creamy finish that does not bleed or feather Highly pigmented lip color with a creamy smooth glide during application that leaves lips feeling hydrated, nurtured, and conditioned Available in sensational lipstick shades you know and love - nudes, pinks, reds and plums - that are rich, warm and made to flatter your skin tone Color Sensational The Creams lipsticks now include your favorite shades from the Vivids and Buffs collections.", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B01DPA81IE/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(28, "Maybelline New York Color Sensational Rebel Bloom Lipstick", "lips_8_1", "lips_8_2", "lips_8_3", 4.1, 34058, 5224, "MATTE FINISH MAYBELLINE LIPSTICK: This velvety, hydrating matte lipstick goes on in one swipe, delivering bold, intense color that lasts. Formulated with honey nectar for a sensuous finish.COLOR SENSATIONAL LIPSTICK: For hyperpigmented lip color in an ultra-hydrating formula, look no further than Color Sensational lipsticks. Available in matte, satin, & gloss & shades from nude to bold black.MAYBELLINE LIPS: Layer on intense color that lasts with Superstay 24 hr Lip color, slay a matte lip with SuperStay Matte Ink Liquid Lipstick, renew with Baby Lips Moisturizing Lip Balm, or add gloss to any color with Clear Lip Gloss Topcoat.MAYBELLINE HAS WHAT YOU NEED to create any look—foundation, bb creams, concealers, & highlighters for the perfect canvas, eyeshadows, brow pencils, & eyeliners for any eye look & lip products, from showstopping matte lipstick to au natural lip balms. REMOVE MAYBELLINE MAKEUP WITH MICELLAR WATER: Use Garnier Micellar Water as a gentle makeup remover at night, & as a facial cleanser in the morning to prep skin for Maybelline makeup.", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B00PFCS5L4/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(29, "Maybelline New York Color Sensational Creamy Matte Lipstick", "lips_9_1", "lips_9_2", "lips_9_3", 4.1, 34058, 1847, "Super-saturated pigments take fresh picked pastels to a new bright Never dull, washed out or shy Honey nectar adds a sumptuous feel This Product is Shipped from USA within 7 to 14 days of reciept of order.", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B00YJJWLLE/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));
        items.add(new PopularDomain(30, "Maybelline New York Color Sensational Rebel Bloom Lipstick -Power Peony", "lips_10_1", "lips_10_2", "lips_1_3", 4.1, 34058, 2893, "The Maybelline Color Sensational Creamy Mattes Lipstick has a unique, velvety matte cream formula that offers a non-drying & un-crackable finish that stays comfortably on your lips through the day These hydrating Maybelline lipstick shades are are infused with honey nectar to keep your lips moisturized all day long. The Colour Sensation lipsticks glide on your lips smoothly for a comfortable wear.The Color Sensational Creamy Matte Lipsticks are available in 30+ pigmented shades, from subtle nudes to bold reds and everything in between.Pair the Color Sensational Creamy Matte Lipstick with a nourishing Maybelline Lip Balm for colour and care!", "https://www.amazon.in/Maybelline-Sensational-Powder-Lipstick-Cherry/dp/B00PFCS5QY/ref=sr_1_1?crid=3IJQG46I8MI21&dib=eyJ2IjoiMSJ9.EFdP8swZrfqj1rSA6vUBbgTio0AzFqaG-afhFu2-nZGUDSrPAyWO5gORT2v_2blRhseMA4MuhZsOv4bMFt6vnUsXOKLVL4I2Z9ANvacTu5WwZPDmD3U4w_38DKFOtzGAYiauL2KBWxd9BIBpA9nyApPqV-Eh65itowxYje1f7lSuMq4xiDL0maeQhy2EICUCyOB3O2JjYmOFGojyT-05yYSW5oOMxVHosT8ZeRYZ-ao6uVADmOramKq2pdiaadyle8dreZMYP9OzCfwenJogbktEOxEkRYP_QkfRd7YnTag.BDVTqPI6NLrd7_Tg4gxj4rm55UaxnApJumK4sm8_oTY&dib_tag=se&keywords=yellow%2Bcolor%2Blipstick%2Bmaybelline&qid=1709892219&s=beauty&sprefix=yellow%2Bcolor%2Blipstick%2Bmabellin%2Cbeauty%2C336&sr=1-1&th=1"));

        //List of Eyelashes.
        items.add(new PopularDomain(31,"MARS Fabulash Eyelashes (Spice Art)","eyels_1_1","eyels_1_2","eyels_1_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.","https://www.amazon.in/dp/B0BD8CWBST?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US"));
        items.add(new PopularDomain(32,"MARS Fabulash Eyelashes (Party Ready)","eyels_2_1","eyels_2_2","eyels_2_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.They have synthetic hair.","https://www.amazon.in/dp/B0BD8DX6WQ?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US&th=1"));
        items.add(new PopularDomain(33,"MARS Fabulash Eyelashes (Glam On)","eyels_3_1","eyels_3_2","eyels_3_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.They have synthetic hair.","https://www.amazon.in/dp/B0BD8FZ4GY?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US&th=1"));
        items.add(new PopularDomain(34,"MARS Fabulash Eyelashes (Drag Queen)","eyels_4_1","eyels_4_2","eyels_4_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.They have synthetic hair.","https://www.amazon.in/dp/B0BD8FRL83?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US&th=1"));
        items.add(new PopularDomain(35,"MARS Fabulash Eyelashes (Flirty Miss)","eyels_5_1","eyels_5_2","eyels_5_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.They have synthetic hair.","https://www.amazon.in/dp/B0BD8HD2SP?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US&th=1"));
        items.add(new PopularDomain(36,"MARS Fabulash Eyelashes (OG Princess)","eyels_6_1","eyels_6_2","eyels_6_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.","https://www.amazon.in/dp/B0BD8H6957?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US&th=1"));
        items.add(new PopularDomain(37,"MARS Fabulash Eyelashes (Over The Top)","eyels_7_1","eyels_7_2","eyels_7_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.They have synthetic hair.","https://www.amazon.in/dp/B0BD8H26J5?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US&th=1"));
        items.add(new PopularDomain(38,"MARS Fabulash Eyelashes (Natural Flutter)","eyels_8_1","eyels_8_2","eyels_8_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.","https://www.amazon.in/dp/B0BD8HTQZZ?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US&th=1"));
        items.add(new PopularDomain(39,"3D Faux Mink Fake Eyelash Long Natural - 63","eyels_9_1","eyels_9_2","eyels_9_3",3.9,58,85,"The band of these false eyelashes is clear and super-fine. The lashes are lighter, more invisible, and more comfortable than lashes with a black band. Your eyes are not burdened by heavy eyelashes. It's recommended to pair it with the Bronson professional eyelash adhesive, which can last a long time and preserve the perfect impression.NATURAL LOOK- The fluffy false eyelashes that look very similar to real eyelashes and naturally enlarge your eyes. The naturally curled curvature and the right length effect give you a low-key look.","https://www.amazon.in/False-Eyelash-Makeup-Natural-Eyelashes/dp/B0BPJTRDHS/ref=sr_1_33?crid=2IWE2QRTDMTAR&dib=eyJ2IjoiMSJ9.6D-5LC5upZWHsqpODEaEPkRItwGGJpAdpQjkr3S0yBFOfXvbJkzsaBLmzOj7SLvlGM0trVD784GlHfJf9IyKxt2lA4KpWz10sX1gP0fAtG4hyhffZXmIpx9p7jCESw_mle8wQ9-o7c9mbkSde0r6MBtoJEcNcsypIM-0EsNzRDqdUVa2R3qvPtmlNX3pURGvg19XbvyaanVGS7M8UE8W5UwjkLkFjkNE_72dKa3VkqEeTOzuc4cIdNbpcP9e4qjIto-akVtXGFUVkmkFH_R9vK0XF4EViA0e16qdvUGS7Lc.BT8M4tYFCedtqNifsGwQV8vaiCrMs9t0sShYZJJeHGg&dib_tag=se&keywords=eyelashes%2Bsmall%2Bsize%2Bsingle&qid=1709916311&s=beauty&sprefix=eyelashes%2Bsmall%2Bsize%2Bsingle%2Cbeauty%2C385&sr=1-33&th=1"));
        items.add(new PopularDomain(40,"3D Faux Mink Fake Eyelash Long Natural - 53","eyels_10_1","eyels_10_2","eyels_1_3",3.9,58,85,"The band of these false eyelashes is clear and super-fine. The lashes are lighter, more invisible, and more comfortable than lashes with a black band. Your eyes are not burdened by heavy eyelashes. It's recommended to pair it with the Bronson professional eyelash adhesive, which can last a long time and preserve the perfect impression.NATURAL LOOK- The fluffy false eyelashes that look very similar to real eyelashes and naturally enlarge your eyes. The naturally curled curvature and the right length effect give you a low-key look.","https://www.amazon.in/False-Eyelash-Makeup-Natural-Eyelashes/dp/B0BPJHWN1Y/ref=acm_sr_dp?crid=2IWE2QRTDMTAR&dib=eyJ2IjoiMSJ9.6D-5LC5upZWHsqpODEaEPkRItwGGJpAdpQjkr3S0yBFOfXvbJkzsaBLmzOj7SLvlGM0trVD784GlHfJf9IyKxt2lA4KpWz10sX1gP0fAtG4hyhffZXmIpx9p7jCESw_mle8wQ9-o7c9mbkSde0r6MBtoJEcNcsypIM-0EsNzRDqdUVa2R3qvPtmlNX3pURGvg19XbvyaanVGS7M8UE8W5UwjkLkFjkNE_72dKa3VkqEeTOzuc4cIdNbpcP9e4qjIto-akVtXGFUVkmkFH_R9vK0XF4EViA0e16qdvUGS7Lc.BT8M4tYFCedtqNifsGwQV8vaiCrMs9t0sShYZJJeHGg&dib_tag=se&keywords=eyelashes%2Bsmall%2Bsize%2Bsingle&qid=1709916311&s=beauty&sprefix=eyelashes%2Bsmall%2Bsize%2Bsingle%2Cbeauty%2C385&sr=1-33&th=1"));

        //List of EyeShadow.
        items.add(new PopularDomain(41,"Miss Claire Single Eyeshadow - 0507","eyesh_1_1","eyesh_1_2","eyesh_1_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271289&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
        items.add(new PopularDomain(42,"Miss Claire Single Eyeshadow - 0753","eyesh_2_1","eyesh_2_2","eyesh_2_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271299&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
        items.add(new PopularDomain(43,"Miss Claire Single Eyeshadow - 0913","eyesh_3_1","eyesh_3_2","eyesh_3_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271312&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
//        items.add(new PopularDomain(44,"","eyesh_4_1","eyesh_4_2","eyesh_4_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.",""));
        items.add(new PopularDomain(45,"Miss Claire Single Eyeshadow - 0459","eyesh_5_1","eyesh_5_2","eyesh_5_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271283&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
        items.add(new PopularDomain(46,"Miss Claire Single Eyeshadow - 0456","eyesh_6_1","eyesh_6_2","eyesh_6_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271280&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
        items.add(new PopularDomain(47,"Miss Claire Single Eyeshadow - 0457","eyesh_7_1","eyesh_7_2","eyesh_7_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271281&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
        items.add(new PopularDomain(48,"Miss Claire Single Eyeshadow - 0250","eyesh_8_1","eyesh_8_2","eyesh_8_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271277&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
        items.add(new PopularDomain(49,"Miss Claire Single Eyeshadow - 0951","eyesh_9_1","eyesh_9_2","eyesh_9_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271313&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));
        items.add(new PopularDomain(50,"Miss Claire Single Eyeshadow - 0457","eyesh_10_1","eyesh_10_2","eyesh_10_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271281&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));

        binding.productList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.productList.setAdapter(new PopularAdapter(items,this));
    }
}