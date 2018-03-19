/**
 * @author Evan
 * @version 2018.01.26
 */

public class Computer {
    private String processor;
    private int numCores;
    private double processorSpeed;

    /**
     * @param processor 
     * String which contains processor name
     * @param numCore 
     * Int which is number of cores on the CPU
     * @param processorSpeed 
     * Double which is the speed in GHz
     */
    public Computer(String processor, int numCore, double processorSpeed) {
        this.setProcessor(processor);
        this.setNumCores(numCore);
        this.setProcessorSpeed(processorSpeed);
    }

    /**
     * @return the processor
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * @param processor the processor to set
     */
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    /**
     * @return the numCores
     */
    public int getNumCores() {
        return numCores;
    }

    /**
     * @param numCores the numCores to set
     */
    public void setNumCores(int numCores) {
        this.numCores = numCores;
    }

    /**
     * @return the processorSpeed
     */
    public double getProcessorSpeed() {
        return processorSpeed;
    }

    /**
     * @param processorSpeed the processorSpeed to set
     */
    public void setProcessorSpeed(double processorSpeed) {
        this.processorSpeed = processorSpeed;
    }
    
    /**
     * The calculated power of the computer
     * @return the power of the computer
     */
    public double computePower() {
        return numCores * processorSpeed;
    }
    
    /** 
     * This creates a string, processes it to match the format
     * and then returns it.
     * @return The processed string
     */
    public String toString() {
        String res = "";
        res = processor + ", " + numCores + " cores at " 
                + processorSpeed + "GHz";
        return res;
    }
    
    
}
