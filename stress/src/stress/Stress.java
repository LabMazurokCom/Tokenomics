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
public class Stress {
    static int quantityOfMasterNodes = 300;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // To burn remchain
        MasterNode remChain[];
        remChain = new MasterNode[quantityOfMasterNodes];
        for(int i = 0; i < quantityOfMasterNodes; ++i) {
            remChain[i] = new MasterNode(i);
        }
        // To animate remchain
        for(int i = 0; i < quantityOfMasterNodes; ++i) {
            (new Thread(remChain[i])).start();
        }
        System.out.println("Bye for now!");
    }
    
}
