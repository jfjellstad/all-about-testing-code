package spacecenter;

public class PreFlightChecksImpl implements PreFlightChecks {
    private final ScannerAdapter scannerAdapter;

    public PreFlightChecksImpl(ScannerAdapter scannerAdapter) {
        this.scannerAdapter = scannerAdapter;
    }

    @Override
    public Boolean hasFuel() {
        System.out.println("Do we have fuel?");
        String answer = scannerAdapter.nextLine();
        return answer.equals("yes") || answer.equals("y");
    }

    @Override
    public Boolean isDoorClosed() {
        System.out.println("Is the door closed?");
        String answer = scannerAdapter.nextLine();
        return answer.equals("yes") || answer.equals("y");
    }
}
