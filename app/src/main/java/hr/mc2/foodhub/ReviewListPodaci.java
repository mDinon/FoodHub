package hr.mc2.foodhub;

/**
 * Created by Matija on 26.4.2016..
 */
public class ReviewListPodaci {
    private String username;
    private String review;
    private int rating;
    private int imageResource;

    public ReviewListPodaci(String username, String review, int rating, int imageResource){
        this.username = username;
        this.review = review;
        this.rating = rating;
        this.imageResource = imageResource;
    }

    public String getUsername() {
        return this.username;
    }

    public String getReview() {
        return this.review;
    }

    public String getRating(){
        String convertRating = Integer.toString(this.rating);
        return convertRating;
    }
    public int getRatingInt(){
        return this.rating;
    }

    public int getImageResource(){
        return this.imageResource;
    }
}
