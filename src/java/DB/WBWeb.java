/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author HP
 */
@WebService(serviceName = "WBWeb")
public class WBWeb {
ConnectionClass obj=new ConnectionClass();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
     @WebMethod(operationName = "CallLg")
    public boolean CallLg(@WebParam(name = "PhNo") String call_number, @WebParam(name = "Type") String call_type, @WebParam(name = "CallDate") String call_date, @WebParam(name = "Duration") String call_duration) {
        //TODO write your implementation code here:
        boolean bc=false;
        String selc="select * from tbl_calllog where PhNo='"+call_number+"' and Type='"+call_type+"' and CallDate='"+call_date+"' and Duration='"+call_duration+"'";
        ResultSet resc=obj.selectCommand(selc);
        try
        {
           if(resc.next())
           {
               System.out.println("already exist");
           }
           else
           {
               String insc="insert into tbl_calllog(PhNo,Type,CallDate,Duration)values('"+call_number+"','"+call_type+"','"+call_date+"','"+call_duration+"')";
                System.out.println("inside call log**********"+insc);
                bc=obj.executeCommand(insc);
                if(bc==true)
                {
                     System.out.println(bc);
                }
                else{}
                
           }
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    return bc;
    }
}
