package practice08;

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
        this.leader = leader;
    }

    public Student getLeader() {
        return leader;
    }
}
