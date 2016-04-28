package hr.mc2.foodhub;

import android.os.Bundle;

/**
 * Created by Matija on 24.4.2016..
 */

//Pomoću ovog interfacea fragment dohvaća podatke iz aktivnosti
public interface FragmentCommunicationMenu {

    public Bundle transferAboutData();

    public Bundle transferFoodData();

    public Bundle transferReviewData();

    /*Nepotrebno
    public Bundle passNewReview();*/

}
