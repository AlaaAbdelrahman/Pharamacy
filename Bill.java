/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.Pharamacy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 *
 * @author alaa
 */
public class Bill {
   
    private static String pharmacyName = "Pharmacy"; // static because it fixed for all objects form that class
    private DateTimeFormatter date;
    private LocalDateTime time;
    private final LinkedList<Medicine> listOfPurchase;

    public Bill() {
        this.listOfPurchase = new LinkedList<>();
    }
    
    /*****************************************************************************************************
     * this method make a  list of medicine the will be sold each chosen medicine will be added to the list
     * @param medicine 
     * @return  void
     ******************************************************************************************************/

    public void makeListOfPurchase(Medicine medicine) {
        listOfPurchase.add(medicine);
    }
    
    /********************************************************************
     * the method get the list of purchase of medicine 
     *          check if the list is empty
     * @return  list of purchased medicine or notify and null if not found
     ********************************************************************/

    public LinkedList<Medicine> getListOfPurchase() {
        if (listOfPurchase.isEmpty()) {
            System.out.println("you didn't make a list of purchase");
            return null;
        }
        return listOfPurchase;
    }
    
    /******************************
     *  change name of the pharmacy
     * @param name 
     ******************************/

    public static void setPharmacyName(String name) {
        pharmacyName = name;
    }
    
    /*****************************************
     * get the name of pharmacy
     * @return 
     ******************************************/

    public static String getPharmacyName() {
        return pharmacyName;
    }
    
    /******************************************************
     * get the data and time the bill will issue 
     * @return 
     ******************************************************/

    public String getTime() {
        date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        time = LocalDateTime.now();
        return date.format(time);
    }

}
