import java.sql.*;
import conexion.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;


    public class Empresa extends EmpresaApp.EmpresaPOA {
        
        private ORB orb;
        Conexion conex = new Conexion();

    @Override
    public boolean insertarEmpresa(int nit, String razon_social, String direccion, String telefono) {
        boolean resultado = false;
        try {
            String query = "insert into Empresa(nit,razon_social,direccion,telefono)"
                    + "values ('"+nit+"','"+razon_social+"','"+direccion+"','"+telefono+"')";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0){
                resultado = true;
            }
            //Cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarEmpresa(int nit) {
        String resultado = "";
        try {
            String query = "Select * from Empresa where nit = "+nit;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(2)+ " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4) + " - "
                        + rs.getString(5) + "\n";
            }
            st.close();
            rs.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarEmpresa(int nit) {
        boolean resultado=false;
        try {
            String query = "Delete from Empresa WHERE id ="+ nit;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0) {
                resultado = true;
            }
            //cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ocurrió un error" +e.getMessage());
        }
        return resultado;   
    }

    @Override
    public boolean actualizarEmpresa(int nit, String razon_social, String direccion, String telefono) {
        boolean resultado = false; 
        try {
            String query = "update Empresa set razon_social = '"+razon_social+"', direccion = '"+direccion+"', telefono = '"+telefono+"' "
                    + "where nit = '"+nit+"'";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0){
                resultado = true;
            }
            //Cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarEmpresa() {
        String resultado = "";
        try {
            String query = "Select * from Empresa";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(2)+ " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4) + " - "
                        + rs.getString(5) + "\n";
            }
            st.close();
            rs.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
