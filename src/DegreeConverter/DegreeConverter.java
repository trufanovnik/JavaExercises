package DegreeConverter;

interface Converter {
    double convert(double degreeCelsius);
}

class KelvinConverter implements Converter{
    public double convert(double degreeCelsius){
        return degreeCelsius + 273.15;
    }
}

class fahrenheitConverter implements Converter{
    public double convert(double degreeCelsius){
        return 1.8*degreeCelsius + 32;
    }
}

public class DegreeConverter {
    public static void main(String[] args) {
        System.out.println(new KelvinConverter().convert(25));
        System.out.println(new fahrenheitConverter().convert(25));
    }
}
