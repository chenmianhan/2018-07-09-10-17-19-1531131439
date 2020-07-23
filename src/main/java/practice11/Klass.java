package practice11;


import java.util.LinkedList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<JoinObserver> joinObservers;

    public int getNumber() {
        return number;
    }
    public Klass(int number){
        this.number=number;
        joinObservers=new LinkedList<>();
    }
    public String getDisplayName(){
        return "Class "+number;
    }

    public void assignLeader(Student leader) {
        if(leader.getKlass()==null||!leader.getKlass().equals(this))
            System.out.print("It is not one of us.\n");
        else {
            this.leader = leader;
            for(int i=0;i<joinObservers.size();i++){
                joinObservers.get(i).notifyLeaderAssgin(leader);
            }
        }
    }
    public void appendMember(Student student){

        student.setKlass(this);
        for(int i=0;i<joinObservers.size();i++){
            joinObservers.get(i).notifyMemberAppend(student);
        }
    }

    public Student getLeader() {
        return leader;
    }
    public boolean isIn(Student student){
        if(student.getKlass()==null||!student.getKlass().equals(this))
            return false;
        else return true;
    }

    public List<JoinObserver> getJoinObservers() {
        return joinObservers;
    }
}
