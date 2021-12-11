package uz.eskishahar.app.lightchat;

import java.util.Map;

public class FriendlyMessage {

    private String text;
    private String name;
    private String photoUrl;
//    private String date;
    private Map<String, Long> timestamp;


    public FriendlyMessage() {
    }

    public FriendlyMessage(String text, String name, Map<String, Long> timestamp, String photoUrl) {
        this.text = text;
        this.name = name;
//        this.date = date;
        this.photoUrl = photoUrl;
        this.timestamp = timestamp;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    public Map<String, Long> getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Map<String, Long> timestamp) {
        this.timestamp = timestamp;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


}
