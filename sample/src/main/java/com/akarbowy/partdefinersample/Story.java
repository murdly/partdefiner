package com.akarbowy.partdefinersample;


import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Story {

    //header
    public String title;
    public String date;
    public int avatarColor;

    //content
    public String content;

    //embed
    public int imagePreviewId;
    public String fileName;

    public Story(String title, String date, int avatarColor, String content, int imagePreviewId, String fileName) {
        this.title = title;
        this.date = date;
        this.avatarColor = avatarColor;
        this.content = content;
        this.imagePreviewId = imagePreviewId;
        this.fileName = fileName;
    }

    public static List<Story> createStories() {
        List<Story> mockedStories = new ArrayList<>();
        mockedStories.add(new Story("John Rock", "2 minutes ago", Color.BLUE, generateContent(), R.mipmap.ic_launcher, null));
        mockedStories.add(new Story("Quinn Emmett", "13 minutes ago", Color.DKGRAY, generateContent(), -1, "screen shot 1.jpg"));
        mockedStories.add(new Story("Charley Inigo", "42 minutes ago", Color.GREEN, generateContent(), -1, null));
        mockedStories.add(new Story("Lacey Holden", "1 hour ago", Color.BLACK, generateContent(), R.mipmap.ic_launcher, "holden.png"));
        mockedStories.add(new Story("Jarrod Bobbie", "1 hour ago", Color.RED, generateContent(), R.mipmap.ic_launcher, "bobbie.jpg"));
        mockedStories.add(new Story("Owen Brendon", "2 hours ago", Color.YELLOW, generateContent(), -1, null));
        mockedStories.add(new Story("Brook Gideon", "12 hours ago", Color.CYAN, generateContent(), -1, null));
        mockedStories.add(new Story("Tyrone Rodolph", "18 hours ago", Color.GRAY, generateContent(),-1,null));
        mockedStories.add(new Story("Pip Huey", "yesterday", Color.WHITE, generateContent(), R.mipmap.ic_launcher, null));
        mockedStories.add(new Story("Braxton Erskine", "yesterday", Color.MAGENTA, generateContent(), -1, null));
        mockedStories.add(new Story("Happy Evelyn", "2 days ago", Color.BLACK, generateContent(), -1, null));
        mockedStories.add(new Story("Andre Palmer", "3 days ago", Color.GRAY, generateContent(), -1, "palmer.jpg"));
        mockedStories.add(new Story("Cullen Alan", "5 days ago", Color.BLUE, generateContent(), R.mipmap.ic_launcher, null));

        return mockedStories;
    }

    private static String generateContent() {
        ArrayList<String> content = new ArrayList<>();
        content.add("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos");
        content.add("Decisively advantages nor expression unpleasing she led met. Estate was tended ten boy nearer seemed. As so seeing latter he should thirty whence. Steepest speaking up attended it as. Made neat an on be gave show snug tore. ");
        content.add("Sportsman do offending supported extremity breakfast by listening. ");
        content.add("Sigh view am high neat half to what");
        content.add("These spoke house of we. Ask put yet excuse person see change.");
        return content.get(new Random().nextInt(content.size()));
    }
}
