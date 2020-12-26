/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.Pharamacy;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author alaa
 */
public class Inventory {

    private final LinkedList<Medicine> storedMedicine;
    private MedicineSpec searchMedicine;

    public Inventory() {

        this.storedMedicine = new LinkedList<>();
        this.searchMedicine = new MedicineSpec();
    }

    /**
     * *************************************************
     * @descriotion add new medicine to the inventory
     * @param medicine
     * @return return the status of storing
     */
    public boolean addMedicine(Medicine medicine) {
        boolean status = storedMedicine.add(medicine);
        if (status) {
            medicine.increaeQuantity();
        }
        return status;

    }

    /**
     * ***********************************************************************
     * @descrption get the medicine from Inventory and decrease the quantity
     * check if the quantity is avaliable first
     *
     * @param medicine that you want to get
     * @return medicine and the status of the quantity if it will be sold out
     * soon and null of the medicine sold out 
     ***********************************************************************
     */

    public Medicine getMedicine(Medicine medicine) {
        if (medicine.decreaseQuantity()) {
            int quantityOfMedicine = medicine.getQuantity();
            if (quantityOfMedicine > 10) {
                return medicine;
            } else if (quantityOfMedicine > 0) {
                System.out.println("Notification");
                System.out.println("MEDICINE will be sold out soon ");
                System.out.println("the remaning quantity " + quantityOfMedicine);
                return medicine;
            }
        }
        System.out.println("MEDICINE IS SOLD OUT ");
        return null;
    }
    /*****
     *  search for medicine by name 
     * @param nameOfMedicine
     * @return  
     */

    public MedicineSpec SearchMedicine(String nameOfMedicine) {
        MedicineSpec item = null;

        for (Medicine searchedMedicine : storedMedicine) {
            if (searchedMedicine.getName() == nameOfMedicine) {
               item = searchedMedicine;
                

            }
        
        }
        if(!item.equals(null)){
            return item;
        }
        

        System.out.println("THE MEDICINE NOT FOUND ");
        return null;

    }

    public LinkedList<MedicineSpec> SearchMedicine(String symptoms, boolean flag) {
        LinkedList<MedicineSpec> searchlist = new LinkedList<>();

        for (Medicine searchedMedicine : storedMedicine) {
            if (searchedMedicine.getSymptoms() == symptoms) {
                searchlist.add(searchedMedicine);

            }
        }
        if (!searchlist.isEmpty()) {
            return searchlist;
        }
        System.out.println("THE MEDICINE NOT FOUND ");
        return null;

    }

    public LinkedList<MedicineSpec> SearchMedicine(boolean flag, String Manufacturer) {
        LinkedList<MedicineSpec> searchlist = new LinkedList<>();

        for (Medicine searchedMedicine : storedMedicine) {
            if (searchedMedicine.getManufacturer() == Manufacturer) {
                searchlist.add(searchedMedicine);

            }
        }
        if (!searchlist.isEmpty()) {
            return searchlist;
        }
        System.out.println("THE MEDICINE NOT FOUND ");
        return null;

    }

}
