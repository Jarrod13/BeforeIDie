package com.liamgoodwin.beforeidie;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by HP on 4/4/2016.
 */

public class MainFragment extends Fragment {

    //Declare the list view for the CardView usage on the Main page
    ListView list;
    TextView LocationText;
    Button LearnMore;
    ArrayList<Recommendation> recommendation;
    TextView daysName;
    TextView daysTime;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Database db = new Database(getContext());
        Bucketlist bucketListSmallestTime = db.getSmallestTime();
        System.out.println("Error" + bucketListSmallestTime);
        db.closeDB();

        long smallestDays = bucketListSmallestTime.getTime();
        String homeBucketListItemName = bucketListSmallestTime.getName();

        long homeTime = System.currentTimeMillis();

        long homeDiffInMillis = smallestDays - homeTime;

        int homeDiffInDays = (int) (homeDiffInMillis / (1000 * 60 * 60 * 24));

        daysName = (TextView) view.findViewById(R.id.daysName);
        daysTime = (TextView) view.findViewById(R.id.daysTime);

        daysName.setText(homeBucketListItemName);
        daysTime.setText("" + homeDiffInDays);

        Recommendation recommendation1 = new Recommendation("Paris, France",
                "Paris, France's capital, is a major European city and a global center for art, fashion, gastronomy and culture. Its 19th-century cityscape is crisscrossed by wide boulevards and the River Seine. Beyond such landmarks as the Eiffel Tower and the 12th-century, Gothic Notre-Dame cathedral, the city is known for its cafe culture and designer boutiques along the Rue du Faubourg Saint-Honoré.",
                R.drawable.deleteimage);
        Recommendation recommendation2 = new Recommendation("New Zealand",
                "New Zealand is a country in the southwestern Pacific Ocean consisting of 2 main islands, both marked by volcanoes and glaciation. Capital Wellington, on the North Island, is home to Te Papa Tongarewa, the expansive national museum. Wellington’s dramatic Mt. Victoria, along with the South Island’s Fiordland and Southern Lakes, stood in for mythical Middle Earth in Peter Jackson’s \"Lord of the Rings\" films.",
                R.drawable.camerabutton);
        Recommendation recommendation3 = new Recommendation("New York City",
                "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
                R.drawable.checkmark);
        Recommendation recommendation4 = new Recommendation("Grand Canyon",
                "The Grand Canyon in Arizona is a natural formation distinguished by layered bands of red rock, revealing millions of years of geological history in cross-section. Vast in scale, the canyon averages 10 miles across and a mile deep along its 277-mile length. Much of the area is a national park, with Colorado River white-water rapids and sweeping vistas.",
                R.drawable.facebookicon);
        Recommendation recommendation5 = new Recommendation("Mauna Loa",
                "Mauna Loa is one of five volcanoes that form the Island of Hawaii in the U.S. state of Hawaiʻi in the Pacific Ocean. The largest subaerial volcano in both mass and volume, Mauna Loa has historically been considered the largest volcano on Earth.",
                R.drawable.emailicon);

        db = new Database(getContext());
        db.addRecommendation(recommendation1);
        db.addRecommendation(recommendation2);
        db.addRecommendation(recommendation3);
        db.addRecommendation(recommendation4);
        db.addRecommendation(recommendation5);
        db.closeDB();

        db = new Database(getContext());
        Recommendation rec = db.getRandomRecommendation();
        String recName = rec.getName();
        String recDescription = rec.getDescription();
        long recImage = rec.getImage();
        db.closeDB();

//        Map<String, String> recommendationsName = new HashMap<String, String>();
//
//        recommendationsName.put("0", "Paris, France");
//        recommendationsName.put("1", "New Zealand");
//        recommendationsName.put("2", "New York City");
//        recommendationsName.put("3", "Grand Canyon");
//        recommendationsName.put("4", "Mauna Loa");
//
//        Map<String, String> recommendationsDescription = new HashMap<String, String>();
//
//        recommendationsDescription.put("Paris, France", "Paris, France's capital, is a major European city and a global center for art, fashion, gastronomy and culture. Its 19th-century cityscape is crisscrossed by wide boulevards and the River Seine. Beyond such landmarks as the Eiffel Tower and the 12th-century, Gothic Notre-Dame cathedral, the city is known for its cafe culture and designer boutiques along the Rue du Faubourg Saint-Honoré.");
//        recommendationsDescription.put("New Zealand", "New Zealand is a country in the southwestern Pacific Ocean consisting of 2 main islands, both marked by volcanoes and glaciation. Capital Wellington, on the North Island, is home to Te Papa Tongarewa, the expansive national museum. Wellington’s dramatic Mt. Victoria, along with the South Island’s Fiordland and Southern Lakes, stood in for mythical Middle Earth in Peter Jackson’s \"Lord of the Rings\" films.");
//        recommendationsDescription.put("New York", "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.");
//        recommendationsDescription.put("Grand Canyon", "The Grand Canyon in Arizona is a natural formation distinguished by layered bands of red rock, revealing millions of years of geological history in cross-section. Vast in scale, the canyon averages 10 miles across and a mile deep along its 277-mile length. Much of the area is a national park, with Colorado River white-water rapids and sweeping vistas.");
//        recommendationsDescription.put("Mauna Loa", "Mauna Loa is one of five volcanoes that form the Island of Hawaii in the U.S. state of Hawaiʻi in the Pacific Ocean. The largest subaerial volcano in both mass and volume, Mauna Loa has historically been considered the largest volcano on Earth.");
//
//        Map<String, Integer> recommendationsImage = new HashMap<String, Integer>();
//
//        recommendationsImage.put("Paris, France",  R.drawable.beforeidie);
//        recommendationsImage.put("New Zealand", R.drawable.camerabutton);
//        recommendationsImage.put("New York", R.drawable.deleteimage);
//        recommendationsImage.put("Grand Canyon", R.drawable.emailicon);
//        recommendationsImage.put("Mauna Loa", R.drawable.facebookicon);
//
//        Random r = new Random();
//        int randomNum = 3;
//
//        List<String> titles = new ArrayList<String>(recommendationsName.keySet());
//        String randomName = titles.get(randomNum);
//
//        List<String> keys = new ArrayList<String>(recommendationsDescription.keySet());
//        String randomDescription = keys.get(randomNum);
//
//        List<String> images = new ArrayList<String>(recommendationsImage.keySet());
//        String randomImage = images.get(randomNum);

//        LocationText = (TextView) view.findViewById(R.id.locationText);
//        LocationText.setText(recommendationsName.get(randomName));
//
//        final String name = recommendationsName.get(randomName);
//        final String description = recommendationsDescription.get(randomDescription);
//        final Integer image = recommendationsImage.get(randomImage);

        LearnMore = (Button) view.findViewById(R.id.learnMore);
        LearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showPopup(inflater, view, name, description, image);
            }
        });

        return view;
    }

    public void showPopup(LayoutInflater inflater, View anchorView, String name, String description, Integer image) {

        View popupView = inflater.inflate(R.layout.popup_layout, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        // Example: If you have a TextView inside `popup_layout.xml`
        TextView popupName = (TextView) popupView.findViewById(R.id.popupName);
        ImageView popupImage = (ImageView) popupView.findViewById(R.id.popupImage);
        TextView popupDescription = (TextView) popupView.findViewById(R.id.popupDescription);

        popupName.setText(name);
        popupImage.setImageResource(image.intValue());
        popupDescription.setText(description);

        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        int location[] = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        anchorView.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorView, Gravity.NO_GRAVITY, location[0], location[1] + anchorView.getHeight());

        //For exit button
        //popupwindow.dismiss();
    }

}