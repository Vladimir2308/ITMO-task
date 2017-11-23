package lecture16;

class Cars {
    float consumption = 8.0f;

    public Cars(float consumption) {
        this.consumption = consumption;
    }

    int drive(int distance, int fuel) {
        return (int) ((float) fuel / consumption * 100);
    }

    static Cars createCar(String s) {
        if (s.equals("Ru"))
            return (new CreatorVAZ()).factoryMethod();
        else if (s.equals("Jp"))
            return (new CreatorToyota()).factoryMethod();
        else if (s.equals("De"))
            return (new CreatorBMW()).factoryMethod();
        return null;
    }
}

interface Creator {
    Cars factoryMethod();
}

class Toyota extends Cars {
    Toyota() {
        super(8.5f);
//        consumption = 8.5f;
    }
}

class BMW extends Cars {
    BMW() {
        super(10f);
//        consumption = 10f;
    }
}

class VAZ extends Cars {
    VAZ() {
        super(8f);
//        consumption = 8f;
    }
}

class CreatorToyota implements Creator {
    @Override
    public Cars factoryMethod() {
        return new Toyota();
    }
}

class CreatorBMW implements Creator {
    @Override
    public Cars factoryMethod() {
        return new BMW();
    }
}

class CreatorVAZ implements Creator {
    @Override
    public Cars factoryMethod() {
        return new VAZ();
    }
}


public class CarFactory {
    public static void main(String[] args) {
        System.out.println(" Ru: " + Cars.createCar("Ru").drive(200, 50));
        System.out.println(" Jp: " + Cars.createCar("Jp").drive(200, 50));
        System.out.println(" De: " + Cars.createCar("De").drive(200, 50));
    }
}