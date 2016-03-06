package com.demo.jason.fragmenttablehostdemo.customView;

/**
 * Created by Jason on 2016/1/30.
 */
public class ModelText {
    private int a;
    private int  b;
    public ModelText(){}
    public ModelText(int a,int b){
        this.a=a;
        this.b=b;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    class innerModel{
        private int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
        public void readData(){
            System.out.println(this.a+","+ModelText.this.a);
        }
    }
}
