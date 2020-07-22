package practice09;

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
            System.out.println("It is not one of us.");
        else this.leader = leader;
    }
    public void appendMember(Student student){
        student.setKlass(this);
    }

    public Student getLeader() {
        return leader;
    }
}
