interface StreamingService {

    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription is active.");
    }
}

interface GamingService {

    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription is active.");
    }
}

class SmartTV implements StreamingService, GamingService {

    public void streamMovie(String movieName) {
        System.out.println("Streaming movie: " + movieName);
    }

    public void playGame(String gameName) {
        System.out.println("Playing game: " + gameName);
    }

    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
        System.out.println("Smart TV subscription conflict resolved.");
    }
}

public class SmartTVDemo {
    public static void main(String[] args) {

        String[] movies = {"Inception", "Interstellar", "Avengers"};
        String[] games = {"FIFA", "Minecraft", "Asphalt"};

        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();

        System.out.println("\nAvailable Movies:");
        for (String movie : movies) {
            tv.streamMovie(movie);
        }

        System.out.println("\nAvailable Games:");
        for (String game : games) {
            tv.playGame(game);
        }
    }
}