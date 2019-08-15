package spacecenter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Nerdschool interstellar space program");

        LaunchControl launchControl = new LaunchControl(new RocketLauncherImpl(), new PreFlightChecksImpl(new ScannerAdapterImpl()));
        launchControl.executeLaunch();
    }
}
