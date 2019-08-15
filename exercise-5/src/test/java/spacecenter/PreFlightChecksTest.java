package spacecenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PreFlightChecksTest {
	@Mock
	private ScannerAdapter scannerAdapter;

	private PreFlightChecks preFlightChecks;

	@BeforeEach
	void setUp() {
		initMocks(this);
		preFlightChecks = new PreFlightChecksImpl(scannerAdapter);
	}

	@Test
	public void hasFuel_answerYes_returnsTrue() {
		when(scannerAdapter.nextLine()).thenReturn("yes");

		assertTrue(preFlightChecks.hasFuel());
	}

	@Test
	public void hasFuel_answerNo_returnsFalse() {
		when(scannerAdapter.nextLine()).thenReturn("no");

		assertFalse(preFlightChecks.hasFuel());
	}

	@Test
	public void isDoorClosed_answerYes_returnsTrue() {
		when(scannerAdapter.nextLine()).thenReturn("yes");
		assertTrue(preFlightChecks.isDoorClosed());
	}

	@Test
	public void isDoorClosed_answerNo_returnsFalse() {
		when(scannerAdapter.nextLine()).thenReturn("no");
		assertFalse(preFlightChecks.isDoorClosed());
	}
}