/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import entities.Machine;

public class Salle implements Serializable{

     private int id;
     private String code;
       private List<Machine> machines; 

    public Salle() {
    }

    public Salle(String code) {
        this.code = code;
   
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", code=" + code +  '}';
    }

    /**
     * @return the machines
     */
    public List<Machine> getMachines() {
        return machines;
    }

    /**
     * @param machines the machines to set
     */
    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
     
     
    
}
