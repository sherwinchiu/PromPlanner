class Table{
    private int size;
    private Student[] students;
    private int x;
    private int y;
    
    public Table(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void setSize(int size){
        this.size = size;
        students = new Student[size];
    }
    
    public void addStudent(Student s){
        for (int i = 0; i < this.size; i++){
            if (students[i] == null);
            students[i] = s;
            i = this.size //lol idk if he lets us do this
        }
    }
    public int getX(){
        return this.x;
    }
    public Students[] getStudents(){
        return this.students;
    }
    public int getY(){
        return this.y;
    }
    public Boolean isFull(){
        if (students[size-1] != null){
            return true;
        } else{
            return false;
        }
    }
}
    
