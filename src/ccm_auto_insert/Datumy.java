/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccm_auto_insert;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author oholik
 */
public class Datumy {

    public String vratAktualniDatum() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        String randomTruncatedDateFormatted = dateFormatter.format(cal.getTimeInMillis());
        //System.out.println(randomTruncatedDateFormatted);
        return randomTruncatedDateFormatted;
    }
    
    
    public String vratDatumProInstalaci()  {
        String datumProInstalaci = "27.07.2016 00:00";        
        return datumProInstalaci;
        
                
    }
    
}
