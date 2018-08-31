package lambda;

public class Tester {
    private static Tester tester = new Tester();
    public static Tester getTester(){
        return tester;
    }
    private Tester(){}
    public boolean test(User user, double time, double lambda){
        user.setLastLambda(time + lambda);
        if(lambdaFunction(time) <= lambda){
            user.setConsensusQuantity(user.getConsensusQuantity() + 1);
            return true;
        }
        else{
            return false;
        }
    }
    private double lambdaFunction(double time){
        return 150;
    }
}
