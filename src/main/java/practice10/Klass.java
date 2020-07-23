package practice10;

public class Klass {
    private int number;
    private Student leader;

    public int getNumber() {
        return number;
    }
    public Klass(int number){
        this.number=number;
    }
    public String getDisplayName(){
        return "Class "+number;
    }

    public void assignLeader(Student leader) {
        if(leader.getKlass()==null||!leader.getKlass().equals(this))
            System.out.print("It is not one of us.\n");
        else this.leader = leader;
    }
    public void appendMember(Student student){
        student.setKlass(this);
    }

    public Student getLeader() {
        return leader;
    }
    public boolean isIn(Student student){
        if(student.getKlass()==null||!student.getKlass().equals(this))
            return false;
        else return true;
    }
}
