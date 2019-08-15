package spacecenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class LaunchControlTest {
    @Mock
    private PreFlightChecks preFlightChecks;
    @Mock
    private RocketLauncher rocketLauncher;

    private LaunchControl launchControl;

    @BeforeEach
    void setUp() {
        // Initialize all the mocks
        initMocks(this);
        launchControl = new LaunchControl(rocketLauncher, preFlightChecks);
    }

    @Test
    public void executeLaunch_whenNoFuelAndDoorIsNotClosed_doesNotLaunchRocket(){
        when(preFlightChecks.hasFuel()).thenReturn(false);
        when(preFlightChecks.isDoorClosed()).thenReturn(false);

        // check that the rocket wasn't launched
        assertEquals(LaunchControl.ROCKET_NOT_LAUNCHED, launchControl.executeLaunch());

        // verify that launchRocket was never called
        verify(rocketLauncher, never()).launchRocket();
    }

    @Test
    public void executeLaunch_whenHasFuelAndDoorIsNotClosed_doesNotLaunchRocket() {
        when(preFlightChecks.hasFuel()).thenReturn(true);
        when(preFlightChecks.isDoorClosed()).thenReturn(false);

        // check that the rocket wasn't launched
        assertEquals(LaunchControl.ROCKET_NOT_LAUNCHED, launchControl.executeLaunch());

        // verify that launchRocket was never called
        verify(rocketLauncher, never()).launchRocket();
    }

    @Test
    public void executeLaunch_whenHasFuelAndDoorIsClosed_launchesRocket() {
        when(preFlightChecks.hasFuel()).thenReturn(true);
        when(preFlightChecks.isDoorClosed()).thenReturn(true);

        // check that the rocket was launched
        assertEquals(LaunchControl.ROCKET_LAUNCHED, launchControl.executeLaunch());

        // verify that launchRocket was called
        verify(rocketLauncher, times(1)).launchRocket();
    }

    @Test
    public void executeLaunch_whenNoFuelAndDoorIsClosed_doesNotLaunchRocket() {
        when(preFlightChecks.hasFuel()).thenReturn(false);
        when(preFlightChecks.isDoorClosed()).thenReturn(true);

        // check that the rocket wasn't launched
        assertEquals(LaunchControl.ROCKET_NOT_LAUNCHED, launchControl.executeLaunch());

        // verify that launchRocket was never called
        verify(rocketLauncher, never()).launchRocket();
    }
}
