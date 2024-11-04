public class AssignmentOne {
    public static void main(String[] args) throws Exception {

        // Part 3 – Using classes and objects
        
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Dr. Grace Sutton", "F");
        GeneralPractitioner gp2 = new GeneralPractitioner(1002, "Dr. Crawford James", "M");
        GeneralPractitioner gp3 = new GeneralPractitioner(1003, "Dr. Patrick Ward", "M");

        OccupationalTherapist ot1 = new OccupationalTherapist(100, "Paige Robinson", "A");
        OccupationalTherapist ot2 = new OccupationalTherapist(1005, "Callum Daniel", "M");
        
        gp1.printInfo(); 
        gp2.printInfo();
        gp3.printInfo();

        ot1.printInfo();
        ot2.printInfo();

        System.out.println("\n------------------------------\n");

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
    private String timeSlot;
    private HealthProfessional selectedDr;

    // Default Constructor
    public Appointment() {
        this.ptName = null;
        this.ptPhone = null;
        this.timeSlot = null;
        this.selectedDr = null;
    }
    
    // Parameterised Constructor
    public Appointment(String ptName, String ptPhone, String timeSlot, HealthProfessional selectedDr) {
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

    public String getTimeSlot() {
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
        System.out.println("\nThe appointment details are:\n");
        System.out.println("Patient Name: " + ptName);
        System.out.println("Patient Phone Number: " + ptPhone);
        System.out.println("Time: " + timeSlot);
        System.out.println("Doctor: " + selectedDr.getName());
    }
    



}