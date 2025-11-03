package frc.robot;

public class DeadzoneUtils {
    public static double simpleDeadzone(double input, double deadzone){
        if(Math.abs(input) < deadzone) {
            return 0;
        }
        return input;
    }

    public static double scaledDeadzone(double input, double deadzone){
        if(Math.abs(input) < deadzone){
            return 0;
        }
        return (input - Math.signum(input) * deadzone) / (1.0-deadzone);
    }
    public static void main(String[] args){
        double[] testInputs = {0.05,0.1,0.5,-0.2,-0.05};
        double dz = 0.1;
        
        System.out.println("Simple Deadzone: ");
        for(double val : testInputs){
            System.out.println(val + " = " + simpleDeadzone(val, dz));
        }
    }
}
