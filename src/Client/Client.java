/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Config;

/**
 *
 * @author Lachgar
 */
public class Client {

    public static void main(String[] args) {
        try {

            IDao<Salle> ss = (IDao<Salle>) Naming.lookup("rmi://localhost:1090/daosalle"); 
            IDao<Machine> ms = (IDao<Machine>) Naming.lookup("rmi://localhost:1090/daomachine");
           
            
            
            System.out.println("ss"+  ss +"ms "+ms);
            //ms.create(new Machine("RE44", "HP", 2000,ss.findById(0)));
            // IDao<Salle> ss =  (IDao<Salle>) Naming.lookup("rmi://localhost:1090/daosalle");;
            //ss.create(new Salle("Cd512"));
            Salle salleP = ss.findById(1);
            
            for (Machine m : ms.findAll()) {
                if (m.getSalle()== salleP){
              System.out.println(m);
                }
           
            }
            /*
            for (Salle s : ss.findAll()) {
            
            System.out.println(s.getMachines());
            }
            */

        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
