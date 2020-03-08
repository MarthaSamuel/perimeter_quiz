
/**
 * for this class, PerimeterAssignmentRunner ,see README.TXT
 * N3b
 * @author Dimgba Martha Otisi 
 * 2020,January
 * @martha_samuel_
 */
import edu.duke.*;
import java.io.File;
public class PerimeterAssignmentRunner{
public double getPerimeter(Shape s){
    //totalPerim=0
    double totalPerim=0;
    //start with prevPt=the LastPoint
    Point prevPt= s.getLastPoint();
    //for each point currPt in the shape
    for(Point currPt: s.getPoints()){
        //find the distance from prevPt to currPt,name it currDist
        double currDist=prevPt.distance(currPt);
        //update totalPerim to be totalPerim+currDist
        totalPerim=totalPerim+currDist;
        //update prevPt to be currPt
        prevPt=currPt;
    }
    //totalPerim is my answer
    return totalPerim;
}
public int getNumPoints(Shape s){
  int numPoints=0;
  for(Point currPt: s.getPoints()){
      numPoints +=1;
    }
    return numPoints;
}
public double getAverageLength(Shape s){
   double average=(getPerimeter(s))/(getNumPoints(s));
        return average;
    }
    public double getLargestSide(Shape s){
        double LargestSide=0;
        Point prevPt= s.getLastPoint();
    for(Point currPt: s.getPoints()){
        double currDist=prevPt.distance(currPt);
            if(currDist>LargestSide) LargestSide=currDist;
            prevPt=currPt;
        }
        return LargestSide;
    }
    public double getLargestX(Shape s){
    double LargestX=0;
     for(Point currPt:s.getPoints()){
            double currX=currPt.getX();
            if(currX>LargestX) LargestX=currX;
        }
        return LargestX;
    }
    public double getLargestPerimeterMultipleFiles(){
     DirectoryResource dr = new DirectoryResource();
     double largestPerim = 0.0;
     FileResource largestFile = null;
        
        for (File f : dr.selectedFiles()) {
        FileResource file = new FileResource(f);
        Shape shape = new Shape(file);
        double perim = getPerimeter(shape);
        if(perim > largestPerim)largestPerim=perim;
        } 
        return largestPerim;
    }
    public String getFileWithLargestPerimeter(){
        DirectoryResource dr=new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;
        
        for (File f : dr.selectedFiles()) {
        FileResource file = new FileResource(f);
        Shape shape = new Shape(file);
        double perim = getPerimeter(shape);
        if(perim > largestPerim) largestPerim=perim;
    
       largestFile = f;
    }
        return largestFile.getName();
    }
    public void testPerimeterMultipleFiles(){
    double largestPerim=getLargestPerimeterMultipleFiles();  
    System.out.println("Largest Perimeter of Multiple Files is " + largestPerim);
}
public void testFileWithLargestPerimeter(){
    String file= getFileWithLargestPerimeter();
    System.out.println("Largest Perimeter File is " + file);
}
  public void testPerimeter(){
 FileResource fr=new FileResource();
 Shape s = new Shape(fr);
 int numPoints=getNumPoints(s);
 double LargestSide=getLargestSide(s);
 double length=getPerimeter(s);
 double average=getAverageLength(s);
 double LargestX=getLargestX(s);
 System.out.println("Perimeter=" + length);
 System.out.println("Number of points = " + numPoints);
 System.out.println("Average Length=" + average);
 System.out.println("Largest Side=" + LargestSide);
 System.out.println("Longest Side=" + LargestX);
 
}
public void triangle(){
    Shape triangle=new Shape();
    Point p1=new Point(-3,4);
    Point p2=new Point(-3,-4);
    Point p3=new Point(3,-4);
    System.out.println("Perimeter of triangle:" + (p1.distance(p2)+p2.distance(p3)+p3.distance(p1)));
    /*triangle.addPoint(new Point(0,0));
    triangle.addPoint(new Point(6,0));
    triangle.addPoint(new Point(3,6));*/
}
// This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
}
}
    public static void main(String[]args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
 } 
  
  
 
    
  
    
