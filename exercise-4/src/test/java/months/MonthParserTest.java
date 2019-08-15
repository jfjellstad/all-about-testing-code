package months;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MonthParserTest {
	private MonthParser parser;

	@BeforeEach
	void setUp() {
		parser = new MonthParser();
	}

	@Test
	void parseMonth_1_returnsJanuary31() {
		Month month = parser.parseMonth(1);
		assertAll("Month 1 is",
		          () -> assertEquals("January", month.name),
		          () -> assertEquals(31, month.days));
	}

	@Test
	void parseMonth_2_returnsFebruary28() {
		Month month = parser.parseMonth(2);
		assertAll("Month 2 is",
		          () -> assertEquals("February", month.name),
		          () -> assertEquals(28, month.days));
	}

	@Test
	void parseMonth_3_returnsMarch31() {
		Month month = parser.parseMonth(2);
		assertAll("Month 3 is",
		          () -> assertEquals("February", month.name),
		          () -> assertEquals(28, month.days));
	}

	@Test
	void parseMonth_4_returnApril30() {
		Month month = parser.parseMonth(4);
		assertAll("Month 4 is",
		          () -> assertEquals("April", month.name),
		          () -> assertEquals(30, month.days));
	}

	@Test
	void parseMonth_5_returnMay31() {
		Month month = parser.parseMonth(5);
		assertAll("Month 5 is",
		          () -> assertEquals("May", month.name),
		          () -> assertEquals(31, month.days));
	}

	@Test
	void parseMonth_6_returnsJune30() {
		Month month = parser.parseMonth(6);
		assertAll("Month 6 is",
		          () -> assertEquals("June", month.name),
		          () -> assertEquals(30, month.days));
	}

	@Test
	void parseMonth_7_returnJuly31() {
		Month month = parser.parseMonth(7);
		assertAll("Month 7 is",
		          () -> assertEquals("July", month.name),
		          () -> assertEquals(31, month.days));
	}

	@Test
	void parseMonth_8_returnsAugust31() {
		Month month = parser.parseMonth(8);
		assertAll("Month 8 is",
		          () -> assertEquals("August", month.name),
		          () -> assertEquals(31, month.days));
	}

	@Test
	void parseMonth_9_returnsSeptember30() {
		Month month = parser.parseMonth(9);
		assertAll("Month 9 is",
		          () -> assertEquals("September", month.name),
		          () -> assertEquals(30, month.days));
	}

	@Test
	void parseMonth_10_returnsOctober31() {
		Month month = parser.parseMonth(10);
		assertAll("Month 10 is",
		          () -> assertEquals("October", month.name),
		          () -> assertEquals(31, month.days));
	}

	@Test
	void parseMonth_11_returnsNovember30() {
		Month month = parser.parseMonth(11);
		assertAll("Month 11 is",
		          () -> assertEquals("November", month.name),
		          () -> assertEquals(30, month.days));
	}

	@Test
	void parseMonth_12_returnsDecember31() {
		Month month = parser.parseMonth(12);
		assertAll("Month 12 is",
		          () -> assertEquals("December", month.name),
		          () -> assertEquals(31, month.days));
	}

	@Test
	void parseMonth_neg1_throwsInvalidParameterException() {
		assertThrows(InvalidParameterException.class, () -> parser.parseMonth(-1));
	}

	@Test
	@DisplayName("parseMonth input:13 throws InvalidParameterException")
	void parseMonth13() {
		assertThrows(InvalidParameterException.class, () -> parser.parseMonth(13));
	}

	@ParameterizedTest(name = "[{index}] {0} is {1} with {2} days")
	@MethodSource("provideMonthAndDays")
	void parseMonths(int input, String expectedName, int expectedDays) {
		Month month = parser.parseMonth(input);
		assertAll("Month " + input + " is",
		          () -> assertEquals(expectedName, month.name),
		          () -> assertEquals(expectedDays, month.days));
	}

	private static Stream<Arguments> provideMonthAndDays() {
		return Stream.of(
				Arguments.of(1, "January", 31),
				Arguments.of(2, "February", 28),
				Arguments.of(3, "March", 31),
				Arguments.of(4, "April", 30),
				Arguments.of(5, "May", 31),
				Arguments.of(6, "June", 30),
				Arguments.of(7, "July", 31),
				Arguments.of(8, "August", 31),
				Arguments.of(9, "September", 30),
				Arguments.of(10, "October", 31),
				Arguments.of(11, "November", 30),
				Arguments.of(12, "December", 31));
	}
}
