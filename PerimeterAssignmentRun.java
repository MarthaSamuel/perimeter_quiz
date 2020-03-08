import edu.duke.*;
import java.io.File;

//public class PerimeterAssignmentRun {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        for(Point currpt:s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double average=(getPerimeter(s))/(getNumPoints(s));
        return average;
    }

    public double getLargestSide(Shape s) {
        double largest=0;
        Point prevpt=s.getLastPoint();
        for(Point currpt:s.getPoints()){
            double currdist=prevpt.distance(currpt);
            if(currdist>largest) largest=currdist;
            prevpt=currpt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        double largestX=0;
        for(Point currpt:s.getPoints()){
            double currX=currpt.getX();
            if(currX>largestX) largestX=currX;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        FileResource largestFile = null;
        
        for (File f : dr.selectedFiles()) {
        FileResource file = new FileResource(f);
        Shape shape = new Shape(file);
        double perim = getPerimeter(shape);
        if(perim > largestPerim){
        }
    }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;
        
        for (File f : dr.selectedFiles()) {
        FileResource file = new FileResource(f);
        Shape shape = new Shape(file);
        double perim = getPerimeter(shape);
        if(perim > largestPerim){
        largestPerim = perim;
        largestFile = f;
    }
}
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double average = getAverageLength(s);
        double longestSide = getLargestSide(s);
        double largeX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + numPoints);
        System.out.println("Average of sides = " + average);
        System.out.println("Longest side = " + longestSide);
        System.out.println("Largest x = " + largeX);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
       double largest = getLargestPerimeterMultipleFiles();
       System.out.println("Largest perimeter is:" + largest);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is:" + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
