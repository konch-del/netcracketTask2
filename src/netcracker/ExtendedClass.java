package netcracker;

import java.util.Objects;

public class ExtendedClass {
    private byte b;
    private int i;
    private double d;
    private String s;

    ExtendedClass(byte b, int i, double d, String s){
        this.b = b;
        this.i = i;
        this.d = d;
        this.s = s;
    }

    public byte getB() {
        return b;
    }

    public double getD() {
        return d;
    }

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }
    /*
      Переопределение toString
    */
    @Override
    public String toString(){
        return String.format("b= " + b + "\ni= "+ i + "\nd= "+ d + "\ns= " + s);
    }
    /*
      Переопределение equals
    */
    @Override
    public boolean equals(Object obj){
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        ExtendedClass ex = (ExtendedClass) obj;
        return this.hashCode() == ex.hashCode() && ex.getB() == b && ex.getI() == i && ex.getD() == d && ex.getS().equals(s);
    }
    /*
      Переопределение hashCode
    */
    @Override
    public int hashCode() {
        return Objects.hash(b, i, d, s);
    }
}
