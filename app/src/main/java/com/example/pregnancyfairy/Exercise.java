package com.example.pregnancyfairy;

public class Exercise {
    private int id;
    private String title;
    private String description;
    public static final Exercise[] exercises = {
            new Exercise(R.drawable.walking, "Walking", "A low-impact exercise that can be easily integrated into daily routines. It helps maintain cardiovascular fitness, improves mood, and promotes circulation without straining the body."),
            new Exercise(R.drawable.stretching, "Stretching", "Gentle stretching can help alleviate muscle tension, improve flexibility, and promote relaxation. Focus on areas that may feel tight, such as the hips, back, and shoulders."),
            new Exercise(R.drawable.yoga, "Prenatal Yoga", "This form of yoga is specifically designed for pregnant women, focusing on breathing, relaxation, and gentle stretching. It can help reduce stress, improve posture, and prepare the body for labor."),
            new Exercise(R.drawable.swimming, "Swimming", "Swimming provides a full-body workout while minimizing joint stress. It helps alleviate swelling, improves circulation, and offers relief from back pain."),
            new Exercise(R.drawable.resistance, "Resistance Band Exercises", "Using resistance bands can help maintain muscle strength. They provide resistance while allowing for safe and controlled movements.")
    };

    public Exercise(int id, String title, String description) {
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
        return  title ;
    }
}
