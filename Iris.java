package turgun;

public class Iris {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private IrisType irisType;

    public Iris(double x1, double y1, double x2, double y2, IrisType irisType) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.irisType = irisType;
    }

    public double[] getAllSize() {

        return new double[] {this.x1, this.y1, this.x2, this.y2};
    }

    public IrisType getIrisType() {

        return irisType;
    }

    public void setIrisType(IrisType irisType) {

        this.irisType = irisType;
    }
    public double getX1()
    {
    	return this.x1;
    }
    public double getY1()
    {
    	return this.y1;
    }
    public double getX2()
    {
    	return this.x2;
    }
    public double getY2()
    {
    	return this.y2;
    }

    @Override
    public String toString() {
        return "The New Iris is : "+this.x1 + "," +
            this.y1 + "," +
            this.x2 + "," +
            this.y2 + " " +"  belong "+
            this.irisType;
    }

}