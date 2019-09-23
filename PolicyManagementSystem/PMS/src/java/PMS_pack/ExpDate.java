/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS_pack;

/**
 *
 * @author Ankit
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ExpDate
{
	public String getCurrDate()
	{
            LocalDate localDate = LocalDate.now();
           return DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate);
	}
        
        /*public static void main(String args[]){
            ExpDate d = new ExpDate();
            System.out.println(d.getCurrDate());
          
        }*/
}