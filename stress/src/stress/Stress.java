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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Hello, World!");
        System.out.println("Hello, World!");
        System.out.println("Hello, World!");
        Thread thread = new Thread(new MasterMode);
        thread.st
        // TODO code application logic here
    }
    
}
