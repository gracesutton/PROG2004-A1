public class AssignmentOne {
    public static void main(String[] args) throws Exception {
        
        HealthProfessional gp1 = new HealthProfessional(1001, "Dr. Grace Sutton", "F");
        gp1.printInfo(); 

        HealthProfessional gp2 = new HealthProfessional("1", "Dr. Grace Sutton", "F");

    }
}

// Base class
class HealthProfessional {
    // health professional properties declared as private
    private int ID;
    private String name;
    private String gender;

    // Default constructor
    public HealthProfessional(int ID, String name, String gender) {
        // initialise health professional properties
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }

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
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
    }
}

class GeneralPractioner extends HealthProfessional {
    public GeneralPractioner() {
        super();
    }

    public GeneralPractioner(int ID, String name, String gender) {
        super(ID, name, gender);
    }
    
}

class OccupationalTherapist {

}

class Appointment {

}