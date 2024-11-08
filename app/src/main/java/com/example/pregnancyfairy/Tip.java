package com.example.pregnancyfairy;

import java.util.ArrayList;

public class Tip {
    private int id;
    private String title;
    private String description;
    public static final Tip[] tips = {
            new Tip(R.drawable.balanced_diet, "Balanced Nutrition", "Eating a balanced diet rich in fruits, vegetables, whole grains, lean proteins, and healthy fats is vital for the health of both the mother and the developing baby. Key nutrients include folic acid, iron, calcium, and omega-3 fatty acids."),
            new Tip(R.drawable.stay_hydrated, "Stay Hydrated", "Drinking plenty of water helps maintain hydration, supports increased blood volume, and aids digestion. Aim for at least 8-10 cups of water a day, and more if exercising or in hot weather."),
            new Tip(R.drawable.manage_stress, "Manage Stress", "Pregnancy can be a stressful time, so it's important to find ways to relax. Techniques such as prenatal yoga, meditation, and deep-breathing exercises can help manage stress levels."),
            new Tip(R.drawable.prenatal_vitamins, "Prenatal Vitamins", "Taking prenatal vitamins ensures that you get essential nutrients that may be hard to obtain through diet alone. Folic acid is particularly important to prevent neural tube defects."),
            new Tip(R.drawable.get_rest, "Get Adequate Rest", "Adequate sleep is crucial for physical and emotional health during pregnancy. Aim for 7-9 hours of sleep each night, and consider short naps during the day if needed.")
    };

    public Tip(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title ;
    }
}
