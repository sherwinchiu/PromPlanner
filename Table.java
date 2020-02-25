import java.awt.*;
import java.util.ArrayList;

class Table{
    private int size;
    private ArrayList<Student> students = new ArrayList<>(0);
    private int x;
    private int y;
    private boolean dragged = false;
    private final int MAX_SIZE = 10;
    private final int RADIUS = 100;
    private Rectangle boundingBox = new Rectangle(x,y,this.RADIUS*2, this.RADIUS*2);
    
    public Table(int size){
        this.size = size;
    }
    public Table(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setDragged(boolean b){
        this.dragged = b;
    }
    public boolean getDragged(){
        return this.dragged;
    }
    public void addStudent(Student s){
        this.students.add(s);
    }
    public void removeStudent(Student s){
        for(int i = 0; i < this.size; i++){
            if (s.getId() == this.students.get(i).getId())
                this.students.set(i, null);
        }
    } 
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public void setStudents(ArrayList<Student> s){
        this.students = s;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
        boundingBox.setBounds(this.x,this.y,this.RADIUS*2, this.RADIUS*2);
    }
    public int getRadius() {
    	return this.RADIUS;
    }
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
        boundingBox.setBounds(this.x,this.y,this.RADIUS*2, this.RADIUS*2);
    }
    public boolean isFull(){
        if(this.size == this.MAX_SIZE)
            return true;
        else 
            return false;
    }
    public Rectangle getBoundingBox(){
        return this.boundingBox;
    }
    public void drawTable(Graphics g){
        g.drawOval(this.x, this.y, this.RADIUS, this.RADIUS);
    }
    public void drawChair(Graphics g){
        double angleIncr = (2.0*Math.PI/(double)this.students.size());
        int x;
        int y;
        for(int i = 1; i < this.students.size()+1; i++){
            x = (int)(Math.cos((double)i*angleIncr)*(this.RADIUS/2+this.RADIUS/10));
            y = (int)(Math.sin((double)i*angleIncr)*(this.RADIUS/2+this.RADIUS/10));
            g.drawString(this.students.get(i-1).getName(), this.x+this.RADIUS/2+x-this.students.get(i-1).getName().length()*2, this.y+this.RADIUS/2+y-6);
            g.drawOval(this.x+this.RADIUS/2+x-6, this.y+this.RADIUS/2+y-6, 12, 12);
        } 
    }
}