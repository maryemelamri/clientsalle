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
            IDao<Machine> ms = (IDao<Machine>) Naming.lookup("rmi://localhost:1090/daomachine");
                        IDao<Salle> ss =  (IDao<Salle>) Naming.lookup("rmi://localhost:1090/daosalle");;

            
           
            ms.create(new Machine("RE44", "HP", 2000,ss.findById(0)));
   
             
           // IDao<Salle> ss =  (IDao<Salle>) Naming.lookup("rmi://localhost:1090/daosalle");;
            ss.create(new Salle("Cd512"));
           
            for(Machine m : ms.findAll())
                System.out.println(m);
            
            for(Salle s : ss.findAll())
                System.out.println(s);
 

        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
