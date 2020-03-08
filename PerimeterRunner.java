
/**
 *  PerimeterRunner : finding perimeter of shapes, FileResource can be used
 * N3a
 * @author Dimgba Martha Otisi
 * 2020, January
 * @martha_samuel_
 */

import edu.duke.*;


public class PerimeterRunner {
    //method
public double getPerimeter (Shape s){
    //start with totalperim=0
    double totalPerim=0;
    //start with PrevPoint=the last point
Point prevPt= s.getLastPoint();
//for each currPt in the shape
for(Point currPt: s.getPoints()){
    //find the distance from PrevPt to currPt,name it currDist
    double currDist=prevPt.distance(currPt);
    //update totalPerim to be totalPerim+ currDist
     totalPerim=totalPerim+currDist;
     //update prePt to be currPt
     prevPt=currPt;
    }
    //totalPerim is my answer
    return totalPerim;

}
public void testPerimeter(){
    FileResource fr=new FileResource();
    Shape s=new Shape(fr);
    double length=getPerimeter(s);
    System.out.println("Perimeter=" + length);
}
public static void main(String[]args){
    PerimeterRunner pr=new PerimeterRunner();
    pr.testPerimeter();
}   
}

