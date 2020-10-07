public class Example4 {
  public static void main(String [] args){
    float a[] = new float [] {3,4,5,0};
    float b[] = new float[] {3,1,0,2,1};
    Polynomial A = new Polynomial(3, a);
    Polynomial B = new Polynomial(4, b);
    OperatePoly optPoly = new OperatePoly();
    Polynomial C = optPoly.addPoly(A, B);
    System.out.print("A(x)"); A.printPoly();
    System.out.print("B(x)"); B.printPoly();
    System.out.print("C(x)"); C.printPoly();
  }
}

class OperatePoly{
  private int degreeA=0, degreeB = 0, degreeC = 0, 
      indexA = 0, indexB = 0, indexC = 0;

  private int expoA, expoB;
  private float coefA, coefB, coefC;

  public Polynomial addPoly(Polynomial A, Polynomial B){
    degreeA = A.getDegree();
    degreeB = B.getDegree();
    expoA = degreeA;
    expoB = degreeB;
    if(degreeA >= degreeB) {
      degreeC = degreeA;
    }else{
      degreeC = degreeB;
    }
    Polynomial C = new Polynomial(degreeC);
    while(indexA <= degreeA && indexB <= degreeB){
      if(expoA > expoB){
        C.setCoef(indexC++, A.getCoef(indexA++));
        expoA--;
      }else if(expoA ==expoB){
        C.setCoef(indexC++, A.getCoef(indexA++)+B.getCoef(indexB++));
        expoA--; expoB--;
      }else{
        C.setCoef(indexC++, B.getCoef(indexB++));
          expoB--;
        
      }
    }
    return C;
  }
}

class Polynomial {
  private int degree;
  private float coef[] = new float[20];

  Polynomial(int degree, float coef[]){
    this.degree = degree;
    this.coef = coef;
  }
  Polynomial(int degree){
    this.degree = degree;
    for(int i=0; i<=degree; i++){
      this.coef[i] = 0;
    }
  }
  public int getDegree(){
    return this.degree;
  }
  public float getConef(int i){
    return this.coef[i];
  }

  public float setCoef(int i, float coef){
    return this.coef[i] = coef;
  }
  public void printPoly(){
    int temp = this.degree;
    for(int i=0; i<=this.degree;i++){
      System.out.printf("%3.0fx^%d", this.coef[i], temp--);
    }
    System.out.println();
  }
}