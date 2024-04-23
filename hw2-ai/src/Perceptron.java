import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Perceptron {
     static double[][] trainedWeights =  new double[4][2];
    private static int i=0;
    private double[] weights;

    public double[] getWeights() {
        return weights;
    }
    public double testedValue;
    private double learningRate;
    private double threshold ;

    private double correctResults =0;
    private double totalResults = 0;
    double performance=0;
    public Perceptron(int numInputs, double learningRate) {
        this.weights = new double[numInputs];
        this.learningRate = learningRate;
        initializeWeights();
    }

    private void initializeWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random() - 0.5 ;
        }
        threshold = Math.random() - 0.5 ;
    }


    public double activation(double bigX){
        // sigmoid activation function
       return  (1 / (1 + Math.exp(-bigX)));
    }
    public double calculateBigX(mainFrame.shapePoint shapePoint){
        return weights[0] * shapePoint.getX() + weights[1] * shapePoint.getY() - threshold;
    }
    public void updateWeights(double error, mainFrame.shapePoint shapePoint){
        weights[0] += error * learningRate * shapePoint.getX();
        weights[1] += error * learningRate * shapePoint.getY();
    }
    public double trainPerceptron(ArrayList<mainFrame.shapePoint> shapePoints, int numOfIterations,String shape , Graphics g){

        double errorSummation = 0;
        for(int i=0; i < numOfIterations; i++) {
            // train each shape
            for (mainFrame.shapePoint shapePoint : shapePoints) {
                System.out.println(Arrays.toString(weights)+" : "+threshold);


                double bigX = calculateBigX(shapePoint);

                double yActual =  activation(bigX);

                // if shape is square the desired output = 1, other shapes is 0
                int yDesired = String.valueOf(shapePoint.getType()).equals(shape) ? 1 : 0;
                // calculate error value
                double error = yDesired - yActual;
                if(error == 0) correctResults++;
                totalResults++;
                errorSummation += Math.pow(error,2);
                // update the weights
                updateWeights(error, shapePoint);

                // update threshold value
                double delta = error * 0.1 * learningRate;
                threshold += delta;

            }
//            System.out.println("MSE: "+(errorSummation / numOfIterations));
        }
        performance = correctResults / totalResults;
//        System.out.println("Correct: "+correctResults+" total: "+totalResults+" "+correctResults/totalResults+" %" );
        drawLine(g);
        return performance;

    }
    public void drawLine(Graphics g){
        double w1 = weights[0]; // Assuming weights[0] is w1
        double w2 = weights[1]; // Assuming weights[1] is w2
        double yIntercept = threshold / w2;
        int startX = 0; // Starting x-coordinate
        int startY = (int) yIntercept; // Convert y-intercept to integer for drawing
        int endX = 600; // Ending x-coordinate
        int endY = (int) ((-1 * endX * w1 - threshold) / w2);


        g.drawLine(startX, startY, endX, endY);
    }

    public void predict(mainFrame.shapePoint point, Graphics g) {
        double bigX = calculateBigX(point);
        System.out.println(weights[0]+" , "+weights[1]+" , "+ threshold + " : "+bigX);
        testedValue = activation(bigX);
        // draw Test shape
        g.setColor(Color.BLACK);
        g.fillOval(point.getX(), point.getY(), 12, 12);

    }
}
