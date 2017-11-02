package lecture10.task1Enum;

public enum Planets {
    MERCURY(33 * Math.pow(10, 22), 2440, 57900000L),
    VENUS(487 * Math.pow(10, 22), 4878, 108000000L),
    EARTH(597 * Math.pow(10, 22), 6357, 149000000L),
    MARS(642 * Math.pow(10, 21), 3390, 228000000L),
    JUPITER(19 * Math.pow(10, 26), 69911, 778000000L),
    SATURN(568 * Math.pow(10, 24), 58232, 1426000000L),
    URANUS(868 * Math.pow(10, 23), 26363, 2871000000L),
    NEPTUNE(102 * Math.pow(10, 24), 24622, 4503000000L);

    private final double weight;
    private final int radius;
    private final long radiusOrbit;


    Planets(double v, int i, long i1) {
        weight = v;
        radius = i;
        radiusOrbit = i1;
    }

    public double getVeight() {
        return weight;
    }

    public int getRadius() {
        return radius;
    }

    public long getRadiusOrbit() {
        return radiusOrbit;
    }

    public static void main(String[] args) {

        for (Planets p : Planets.values()) {
            System.out.printf( p.name() + " weight is %.2ekg, radius is %dkm , distance to sun is %dkm%n",
                    p.getVeight(), p.getRadius(), p.radiusOrbit);
        }
    }
}


