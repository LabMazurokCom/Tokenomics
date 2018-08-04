/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stress;

/**
 *
 * @author igor
 */
public class MasterNode implements Runnable {

    private final int n;

    /**
     *
     * @param n - node's index
     */
    public MasterNode(int n) {
        this.n = n;
    }
    /**
     * <p>The Whole Sad Story of the Node</p>
     */
    @Override
    public void run() {
        System.out.println("I'm liive! I'm " + n + "th!");
    }
    
}
