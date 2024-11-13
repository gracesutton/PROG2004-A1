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

        OccupationalTherapist ot1 = new OccupationalTherapist(1004, "Paige Robinson", "F");
        OccupationalTherapist ot2 = new OccupationalTherapist(1005, "Callum Daniel", "M");
        
        // print details of each object
        System.out.println("\nThe health professional details are:\n");
        System.out.println(gp1);
        System.out.println(gp2);
        System.out.println(gp3);

        System.out.println(ot1);
        System.out.println(ot2);

        System.out.println("------------------------------\n");

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

    // new ArrayList to store all appointments (Appointment objects)
    private static ArrayList<Appointment> appointments = new ArrayList<>(); 

    /**
     * Method to create a new booking and add it to the ArrayList
     */
    public static void createAppointment(String ptName, String ptPhone, LocalTime timeSlot, HealthProfessional selectedDr) {
        Appointment apt = new Appointment(ptName, ptPhone, timeSlot, selectedDr);
        appointments.add(apt);
        System.out.println("Appointment created for " + apt.getPtName() + " (ph: " + apt.getPtPhone() + ") at " + apt.getTimeSlot() + " with " + apt.getSelectedDr());
    }

    /**
     * Method to display existing appointments in the ArrayList
     */
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("There are no existing appointments.");
        } else {
            System.out.println("\n** Existing Appointments **\n");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
    /**
     * method to cancel a booking using a patient's phone number
     */
    public static void cancelBooking(String ptPhone) {

        System.out.println("** Request to remove booking for " + ptPhone + " **\n");
        boolean found = false; // flag to check if the booking has been found

        Iterator<Appointment> iter = appointments.iterator(); // creates an Iterator (iter) to loop through the appointments ArrayList.
        while (iter.hasNext()) {

            Appointment appointment = iter.next();

            if (appointment.getPtPhone().equals(ptPhone)) { // if found, remove the booking.
                found = true;
                iter.remove();
                System.out.println("Appointment for '" + appointment.getPtName() + " ph " + ptPhone + "' has been removed.");
                break;
            } 
        }
        
        if (found == false) { // if not found, print a message.
            System.out.println("Appointment not found.\n");
        }
    }
}

/**
 * Base class to represent a Health Professional
 */
class HealthProfessional {
    // health professional properties declared as private
    private int ID;
    private String name;
    private String gender;

    /**
     * Default Constructor
     */   
    public HealthProfessional() {
        this.ID = 0;
        this.name = "Unknown";
        this.gender = "Unknown";
    }    

    /**
     * Parameterised (Second) Constructor for Health Professional objects
     */    
    public HealthProfessional(int ID, String name, String gender) {
        // initialise health professional properties
        setID(ID);
        setName(name);
        setGender(gender);
    }

    /**
     * Getter and Setter Methods with validation
     */
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
        //perform input validation for the HP ID - must be 4 or more digits, greater than 1000.
        if (ID >= 1000) {
            this.ID = ID;
        } else {
            System.out.println("Invalid ID: Must be 4 or more digits.");
        }
    }

    public void setName(String name) {
        //perform input validation for the Health Professional's name - must be btwn 3-30 characters.
        if ((name.length() > 3) && (name.length() < 30)) {
            this.name = name;
        } else {
            System.out.println("Invalid Name: Must be between 3 and 30 characters.");
        }
    }

    public void setGender(String gender) {
        //perform input validation for gender - must be a string of either M for male or F for female.
        gender = gender.toUpperCase();
        if ((gender.equals("M")) || (gender.equals("F"))) {
            this.gender = gender;
        } else {
            System.out.println("Invalid Gender: Must be either M or F.");
        }
    }

    /**
     * Method to export the health professional details as a string
     */
    @Override
    public String toString() {
        return "ID: " + ID 
            + "\nName: " + name 
            + "\nGender: " + gender;
    }
}

/**
 *  Class to represent a GP
 */
class GeneralPractitioner extends HealthProfessional {

    private final String type = "GP";

    /**
     * Default Constructor for GP
     */
    public GeneralPractitioner() {
        super(); // Call default constructor of HealthProfessional
    }

    /**
     * Constructor for objects of class GP
     */
    public GeneralPractitioner(int ID, String name, String gender) {
        super(ID, name, gender); // Call parameterised constructor of HealthProfessional
    }

    /**
     * getter and setter methods
     */    
    public String getType() {
        return type;
    }

    /**
     * method to export the GP details as a string
     */
    @Override
    public String toString() {
        return super.toString() + "\nType: " + type + "\n";
    }
    
}

/**
 * Class to represent an OT
 */
class OccupationalTherapist extends HealthProfessional {

    private final String type = "OT";

    /**
     * Default Constructor for OT
     */
    public OccupationalTherapist() {
        super(); // Call default constructor of HealthProfessional
    }

    /**
     * Constructor for objects of class OT
     */
    public OccupationalTherapist(int ID, String name, String gender) {
        super(ID, name, gender); // Call parameterised constructor of HealthProfessional
    }

    /**
     * getter and setter methods
     */    
    public String getType() {
        return type;
    }

    /**
     * method to export the OT details as a string
     */
    @Override
    public String toString() {
        return super.toString() + "\nType: " + type + "\n";
    }

}

/**
 * Class to represent an Appointment 
 */
class Appointment {
    // Appointment properties declared as private
    private String ptName;
    private String ptPhone;
    private LocalTime timeSlot;
    private HealthProfessional selectedDr;

    /**
     * Default Constructor
     */
    public Appointment() {
        this.ptName = "Unknown";
        this.ptPhone = "Unknown";
        this.timeSlot = LocalTime.of(8, 0); // default time slot at start of working day
        this.selectedDr = new HealthProfessional(); // calls default constructor of HP class to have name as "Unknown"
    }
    
    /**
     * Constructor for Appointment objects
     */
    public Appointment(String ptName, String ptPhone, LocalTime timeSlot, HealthProfessional selectedDr) {
        setPtName(ptName);
        setPtPhone(ptPhone);
        setTimeSlot(timeSlot);
        setSelectedDr(selectedDr);
    }

    /**
     * Getter and Setter Methods with validation
     */
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
        //perform input validation for ptName - must be btwn 3-30 characters
        if ((ptName.length() > 3) && (ptName.length() < 30)) {
            this.ptName = ptName;
        } else {
            System.out.println("Invalid Name: Must be between 3 and 30 characters.");
        }
    }

    public void setPtPhone(String ptPhone) {
        //perform input validation for ptPhone - must be exactly 12 characters, i.e. XXXX XXXX XXXX
        if (ptPhone.length() == 12) {
            this.ptPhone = ptPhone;
        } else {
            System.out.println("Invalid Phone Number. Please try again in the format: XXXX XXXX XXXX.");
        }
    }

    public void setTimeSlot(LocalTime timeSlot) {
        //perform input validation for timeSlot - must be between the hours of 8am-5pm.
        if (timeSlot.isBefore(LocalTime.of(8, 0)) || timeSlot.isAfter(LocalTime.of(17, 0))) {
            System.out.println("Invalid Time: Appointment must be between 8am and 5pm.");
        } else {
            this.timeSlot = timeSlot;
        }
    }

    public void setSelectedDr(HealthProfessional selectedDr) {
        this.selectedDr = selectedDr;
    }

    /**
     * Method to export appt information as a string
     */
    @Override
    public String toString() {
        return "Patient Name: " + ptName
            + "\nPatient Phone Number: " + ptPhone
            + "\nTime: " + timeSlot
            + "\nDoctor: " + selectedDr.getName() + "\n";
    }

}