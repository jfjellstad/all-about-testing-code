package spacecenter;

import java.util.Scanner;

public class ScannerAdapterImpl implements ScannerAdapter {
	@Override
	public String nextLine() {
		Scanner reader = new Scanner(System.in);
		return reader.nextLine();
	}
}
