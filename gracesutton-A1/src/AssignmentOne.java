public class AssignmentOne {
    public static void main(String[] args) throws Exception {
        
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Dr. Grace Sutton", "F");
        OccupationalTherapist ot1 = new OccupationalTherapist(1002, "Paige Robinson", "F");
        
        gp1.printInfo(); 
        ot1.printInfo();

        // HealthProfessional gp2 = new HealthProfessional("1", "Dr. Grace Sutton", "F");

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
            System.out.println("Invalid ID: ID must be 4 or more digits.");
        }
    }

    // public void setName

    public void printInfo() {
        System.out.println("The health professional details are:");
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
        return getType();
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
        return getType();
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Type: " + type);
    }

}

class Appointment {

}