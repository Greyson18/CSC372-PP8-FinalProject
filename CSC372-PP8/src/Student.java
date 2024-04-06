class Student {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
    	//Initializes the variables
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    //Create getters for the variables
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nGPA: " + GPA + "\n";
    }
}

