package spacecenter;

public class LaunchControl {
    public static final int ROCKET_LAUNCHED = 1;
    public static final int ROCKET_NOT_LAUNCHED = -1;

    private RocketLauncher rocketLauncher;
    private PreFlightChecks preFlightChecks;

    public LaunchControl(RocketLauncher rocketLauncher, PreFlightChecks preFlightChecks) {
        this.rocketLauncher = rocketLauncher;
        this.preFlightChecks = preFlightChecks;
    }

    public int executeLaunch() {
        if (this.preFlightChecks.hasFuel() && this.preFlightChecks.isDoorClosed()) {
            this.rocketLauncher.launchRocket();
            return ROCKET_LAUNCHED;
        } else {
            return ROCKET_NOT_LAUNCHED;
        }
    }
}
