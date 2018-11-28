
package com.cartelle.coleccionJavaBeansDatasource;

import com.cartelle.dao.DbConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANTONIO
 */
public class AreaFichaDAO {
   
    
    public List<AreasFicha> listarAreas(){
       
       try{ 
        DbConnection con=new DbConnection(); 
       
       List<AreasFicha> listadoAreas=new ArrayList();
       listadoAreas=con.obtenerAreasFicha();
       return listadoAreas;
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return null;
    }
}
