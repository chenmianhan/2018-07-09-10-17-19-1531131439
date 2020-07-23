package practice11;


import java.util.LinkedList;
import java.util.List;

public class Klass {
    private final int number;
    private Student leader;
    private final List<JoinObserver> joinObservers;
    private final List<AssignObserver> assignObservers;

    public int getNumber() {
        return number;
    }
    public Klass(int number){
        this.number=number;
        joinObservers=new LinkedList<>();
        assignObservers=new LinkedList<>();
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
                assignObservers.get(i).notifyLeaderAssign(leader);
            }
        }
    }
    public void appendMember(Student student){

        student.setKlass(this);
        for (JoinObserver joinObserver : joinObservers) {
            joinObserver.notifyMemberAppend(student);
        }
    }

    public Student getLeader() {
        return leader;
    }
    public boolean isIn(Student student){
        return student.getKlass() != null && student.getKlass().equals(this);
    }

    public List<JoinObserver> getJoinObservers() {
        return joinObservers;
    }

    public List<AssignObserver> getAssignObservers() {
        return assignObservers;
    }
}
