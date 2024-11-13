package RootFindingMethod;

public class Main {
    public static void main(String[] args) {
        double eps = 0.001;
        double leftPoint = 0;
        double rightPoint = 10;
        System.out.println(findRoot(leftPoint, rightPoint, eps));
    }

    public static double func (double x){
        return (Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23);
    }

    public static double findRoot(double leftPoint, double rightPoint, double eps){
        if (rightPoint - leftPoint <= eps)
            return leftPoint;

        if ((func(leftPoint) - eps == 0) || (func(leftPoint) + eps == 0)) {
            return leftPoint;
        } else if ((func(rightPoint) - eps == 0) || (func(rightPoint) + eps == 0)) {
            return rightPoint;
        }
        while (rightPoint - leftPoint > eps){
            double midPoint = leftPoint + (rightPoint - leftPoint)/2;
            if(func(leftPoint) * func(midPoint) > 0) {
                leftPoint = midPoint;
            } else {
                rightPoint = midPoint;
            }
        }
        findRoot(leftPoint, rightPoint, eps);
        return leftPoint;
    }
}
