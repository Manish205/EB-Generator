import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EBConnectionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the eBill Generator!");

        // Customer Registration
        System.out.println("Please provide the following details for registration:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        // Additional fields and validations can be added as per your project requirements

        // Save the customer details to a database or file
        // You can add code here to store the customer details in your preferred way

        System.out.println("Registration successful!");
        System.out.println("Thank you for registering with eBill Generator.");

        // EB Connection Registration
        System.out.println("\nWelcome to the EB Connection Registration!");
        System.out.println("Please provide the following details for registration:");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter address: ");
        address = scanner.nextLine();

        System.out.print("Enter contact number: ");
        contactNumber = scanner.nextLine();

        System.out.print("Enter connection type (domestic or commercial): ");
        String connectionType = scanner.nextLine();

        // Additional fields and validations can be added as per your project requirements

        // Calculate the connection charges based on the connection type
        double connectionCharges = 0.0;
        if (connectionType.equalsIgnoreCase("domestic")) {
            connectionCharges = 1000.0;
        } else if (connectionType.equalsIgnoreCase("commercial")) {
            connectionCharges = 2000.0;
        } else {
            System.out.println("Invalid connection type!");
            return;
        }

        // Save the connection details to a database or file
        // You can add code here to store the connection details in your preferred way

        System.out.println("Registration successful!");
        System.out.println("Thank you for registering your new EB connection.");
        System.out.println("Connection Charges: $" + connectionCharges);

        // Monthly Meter Reader
        System.out.println("\nWelcome to the Monthly Meter Reader!");
        System.out.println("Please provide the following details:");
        System.out.print("Enter meter reading for the current month: ");
        int meterReading = scanner.nextInt();

        // Calculate the electricity bill based on the meter reading
        double billAmount = calculateElectricityBill(meterReading);

        // Generate the bill for the current month
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        String currentMonth = dateFormat.format(currentDate);

        // Display the bill details
        System.out.println("\nElectricity Bill for " + currentMonth);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Meter Reading: " + meterReading);
        System.out.println("Bill Amount: $" + billAmount);

        // Payment Integration
        System.out.println("\nWelcome to the Payment Integration!");

        // Prompt the user for payment details
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Enter expiration date (MM/YY): ");
        String expirationDate = scanner.nextLine();

        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();

        System.out.print("Enter payment amount: ");
        double paymentAmount = scanner.nextDouble();

        // Process the payment
        boolean paymentSuccessful = processPayment(customerName, cardNumber, expirationDate, cvv, paymentAmount);

        // Check if payment was successful
        if (paymentSuccessful) {
            System.out.println("Payment successful! Thank you for your payment.");
        } else {
            System.out.println("Payment failed. Please try again or contact customer support.");
        }

        scanner.close();
    }

    // Helper method to calculate the electricity bill based on the meter reading
    private static double calculateElectricityBill(int meterReading) {
        double billAmount = 0.0;

        if (meterReading <= 50) {
            // First 50 units are free
            billAmount = 0.0;
        } else if (meterReading <= 100) {
            // Next 51-100 units cost Rs. 2 per unit
            int unitsConsumed = meterReading - 50;
            billAmount = unitsConsumed * 2.0;
        } else if (meterReading <= 300) {
            // Next 101-300 units cost Rs. 4 per unit
            int unitsConsumed = meterReading - 100;
            billAmount = (50 * 2.0) + (unitsConsumed * 4.0);
        } else {
            // Above 300 units cost Rs. 6 per unit
            int unitsConsumed = meterReading - 300;
            billAmount = (50 * 2.0) + (200 * 4.0) + (unitsConsumed * 6.0);
        }

        return billAmount;
    }

    // Helper method to process the payment
    private static boolean processPayment(String customerName, String cardNumber, String expirationDate, String cvv, double paymentAmount) {
        // Add your payment integration code here
        // This is a placeholder method that simulates a payment by checking if the payment amount is positive
        return paymentAmount > 0;
    }
}
