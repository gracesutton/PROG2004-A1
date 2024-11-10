import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Iterator;

public class AssignmentOne {
    public static void main(String[] args) throws Exception {

        // Part 3 – Using classes and objects
        
        // create some instance objects for GP and OT classes
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Dr. Grace Sutton", "F");
        GeneralPractitioner gp2 = new GeneralPractitioner(1002, "Dr. Crawford James", "M");
        GeneralPractitioner gp3 = new GeneralPractitioner(1003, "Dr. Patrick Ward", "M");

        OccupationalTherapist ot1 = new OccupationalTherapist(100, "Paige Robinson", "A");
        OccupationalTherapist ot2 = new OccupationalTherapist(1005, "Callum Daniel", "M");
        
        // print details of each object
        gp1.printInfo(); 
        gp2.printInfo();
        gp3.printInfo();

        ot1.printInfo();
        ot2.printInfo();

        System.out.println("\n------------------------------\n");

        // Part 5 – Collection of appointments

        // create some appointments
        createAppointment("Elsie McLaughlin", "0413 999 838", LocalTime.of(8, 0), gp1);
        createAppointment("John Paddy", "0422 989 727", LocalTime.of(14,30), gp3);
        createAppointment("Jade Clarke", "0413 369 248", LocalTime.of(12, 15), ot1);
        createAppointment("Ben Michaels", "0408 764 818", LocalTime.of(11, 45), ot2);

        // print existing appointments
        printExistingAppointments();

        // cancel an appointment
        cancelBooking("0408 764 816");
        cancelBooking("0408 764 818");

        // print again
        printExistingAppointments();

        System.out.println("------------------------------");
    }

    private static ArrayList<Appointment> appointments = new ArrayList<>(); // new ArrayList to store all appointments (Appointment objects)

    // method to create a new booking and add it to the ArrayList
    public static void createAppointment(String ptName, String ptPhone, LocalTime timeSlot, HealthProfessional selectedDr) {
        Appointment apt1 = new Appointment(ptName, ptPhone, timeSlot, selectedDr);
        appointments.add(apt1);
        System.out.println("Appointment created for " + ptName + " (ph: " + ptPhone + ") at " + timeSlot + " with " + selectedDr.getName());
    }

    // method to display existing appointments in the ArrayList
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("There are no existing appointments.");
        } else {
            System.out.println("\n** Existing Appointments **\n");
            for (Appointment appointment : appointments) {
                appointment.printApptInfo();
            }
        }
    }

    // method to cancel a booking using a patient's phone number
    public static void cancelBooking(String ptPhone) {

        System.out.println("** Request to remove booking for " + ptPhone + " **\n");
        boolean found = false;

        Iterator<Appointment> iter = appointments.iterator();
        while (iter.hasNext()) {

            Appointment appointment = iter.next();

            if (appointment.getPtPhone().equals(ptPhone)) {
                found = true;
                appointments.remove(appointment);
                System.out.println("Appointment for '" + appointment.getPtName() + " ph " + ptPhone + "' has been removed.");
                break;
            } 
        }
        
        if (found == false) {
            System.out.println("Appointment not found.\n");
        }
    }
        
}

// Base class
class HealthProfessional {
    // health professional properties declared as private
    private int ID;
    private String name;
    private String gender;

    // Default constructor
    public HealthProfessional() {
        this.ID = 0;
        this.name = "Unknown";
        this.gender = "Unknown";
    }    

    // Parameterised (Second) Constructor
    public HealthProfessional(int ID, String name, String gender) {
        // initialise health professional properties
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }

    // Getter and Setter Methods

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setID(int ID) {
        if (ID >= 1000) {
            this.ID = ID;
        } else {
            System.out.println("Invalid ID: Must be 4 or more digits.");
        }
    }

    public void setName(String name) {
        //perform input validation
        if ((name.length() > 3) && (name.length() < 30)) {
            this.name = name;
        } else {
            System.out.println("Invalid Name: Must be between 3 and 30 characters.");
        }
    }

    public void setGender(String gender) {
        this.gender.toUpperCase();
        if ((gender.equals("M")) || (gender.equals("F"))) {
            this.gender = gender;
        } else {
            System.out.println("Invalid Gender: Must be either M or F.");
        }
    }

    // public void setName

    public void printInfo() {
        System.out.println("\nThe health professional details are:\n");
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);

    }
}

class GeneralPractitioner extends HealthProfessional {

    private String type = "GP";

    // Constructor
    public GeneralPractitioner(int ID, String name, String gender) {
        super(ID, name, gender);
    }

    public String getType() {
        return type;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Type: " + type);
    }
    
}

class OccupationalTherapist extends HealthProfessional {

    private String type = "OT";

    // Constructor
    public OccupationalTherapist(int ID, String name, String gender) {
        super(ID, name, gender);
    }

    public String getType() {
        return type;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Type: " + type);
    }

}

class Appointment {

    private String ptName;
    private String ptPhone;
    private LocalTime timeSlot;
    private HealthProfessional selectedDr;

    // Default Constructor
    public Appointment() {
        this.ptName = null;
        this.ptPhone = null;
        this.timeSlot = null;
        this.selectedDr = null;
    }
    
    // Parameterised Constructor
    public Appointment(String ptName, String ptPhone, LocalTime timeSlot, HealthProfessional selectedDr) {
        this.ptName = ptName;
        this.ptPhone = ptPhone;
        this.timeSlot = timeSlot;
        this.selectedDr = selectedDr;
    }

    public String getPtName() {
        return ptName;
    }

    public String getPtPhone() {
        return ptPhone;
    }

    public LocalTime getTimeSlot() {
        return timeSlot;
    }

    public String getSelectedDr() {
        return selectedDr.getName();
    }

    public void setPtName(String ptName) {
        //perform input validation
        if ((ptName.length() > 3) && (ptName.length() < 30)) {
            this.ptName = ptName;
        } else {
            System.out.println("Invalid Name: Must be between 3 and 30 characters.");
        }
    }

    public void setPtPhone(String ptPhone) {
        if (ptPhone.length() == 10) {
            this.ptPhone = ptPhone;
        } else {
            System.out.println("Invalid Phone Number. Please try again.");
        }
    }

    public void setTimeSlot(String timeSlot) {
        //perform input validation
        if ((timeSlot.length() == 4) && (timeSlot.length() < 30)) {
            this.timeSlot = timeSlot;
        } else {
            System.out.println("Invalid Timeslot. Please enter a valid time in the format 00:00.");
        }
    }


    // Method to print all information
    public void printApptInfo() {
        System.out.println("Patient Name: " + ptName);
        System.out.println("Patient Phone Number: " + ptPhone);
        System.out.println("Time: " + timeSlot);
        System.out.println("Doctor: " + selectedDr.getName() + "\n");
    }
    



}