package lambda;

import java.util.UUID;

public class User {
    private UUID key;
    private String name;
    private double lastLambda;
    private int consensusQuantity;

    public User(String name) {
        this.key = UUID.randomUUID();
        this.name = name;
        this.lastLambda = 0;
        this.consensusQuantity = 0;
    }

    public User(){}

    public UUID getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getLastLambda() {
        return lastLambda;
    }

    public int getConsensusQuantity() {
        return consensusQuantity;
    }

    public void setKey(UUID key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastLambda(double lastLambda) {
        this.lastLambda = lastLambda;
    }

    public void setConsensusQuantity(int consensusQuantity) {
        this.consensusQuantity = consensusQuantity;
    }
}
