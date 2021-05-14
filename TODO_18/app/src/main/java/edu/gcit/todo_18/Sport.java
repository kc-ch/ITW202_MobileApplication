package edu.gcit.todo_18;

public class Sport {
    private String title, info;
    private int imageResource;

    public Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getInfo() {
        return info;
    }
}
