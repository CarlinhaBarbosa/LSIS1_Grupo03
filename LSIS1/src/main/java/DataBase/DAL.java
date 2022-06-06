/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaoferreira
 */
public class DAL {
    
     /*Inserir*/
    public static void inserirCliente(Cliente c) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO cliente (nome, password, dataNas, email, nrFiscal, telefone, morada) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getPassword());
            Date sqlDataNasc = new Date(c.obterDataConvertidaParaJavaDateComParametroString(c.getDataNas()).getTime());
            stmt.setDate(3, sqlDataNasc);
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getNrFiscal());
            stmt.setString(6, c.getTelefone());
            stmt.setString(7, c.getMorada());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirViatura(Viatura v) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO viatura (matrícula, idCliente) VALUES (?,?)");
            stmt.setString(1, v.getMatricula());
            stmt.setInt(2, v.getIdCliente());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirReserva(Reserva r) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO reserva (dataInicio, dataFim, horaEntrada, horaSaida,id_viatura) VALUES (?,?,?,?,?)");
            Date sqlDataInicio = new Date(r.getDataInicioConvertida(r.getDataInicio()).getTime());
            stmt.setDate(1, sqlDataInicio);
            Date sqlDataFim = new Date(r.getDataFimConvertida(r.getDataFim()).getTime());
            stmt.setDate(2, sqlDataFim);
            Time entrada = Time.valueOf(r.getHoraEntrada());
            stmt.setTime(3, entrada);
            Time saida = Time.valueOf(r.getHoraSaida());
            stmt.setTime(4, saida);
            stmt.setInt(5, r.getId_viatura());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirFaturacao(Faturacao f) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO faturacao (valor, id_viatura) VALUES (?,?)");
            stmt.setInt(1, f.getValor());
            stmt.setInt(2, f.getiDViatura());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirZona(Zona z) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO zona (nome) VALUES (?)");
            stmt.setString(1, z.getNome());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirPiso(Piso p) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO piso (numero) VALUES (?)");
            stmt.setInt(1, p.getNumero());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*Selecionar*/
    public void selecionarCliente(int Id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM cliente WHERE id=?");
            stmt.setInt(1, Id);
            rs = stmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfCols = rsMetaData.getColumnCount();
            while (rs.next()) {
                List<Object> values = new ArrayList<>();
                for (int i = 1; i <= numberOfCols; i++) {
                    Object object = rs.getObject(i);
                    values.add(object);
//                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
//            System.out.printf("%n");
                for (int i = 0; i < values.size(); i++) {
                    System.out.println(values.get(i));
                }
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Cliente obterCliente(int id) {
        Cliente result = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM cliente WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Cliente clienteRetorno = new Cliente();
            if (rs.next()) {
                clienteRetorno.setId(rs.getInt("id"));
                clienteRetorno.setNome(rs.getString("nome"));
                clienteRetorno.setPassword(rs.getString("password"));
                clienteRetorno.setDataNas(rs.getDate("dataNas").toString());
                var x = rs.getString("email");
                clienteRetorno.setEmail(rs.getString("email"));
                clienteRetorno.setNrFiscal(rs.getString("nrFiscal"));
                clienteRetorno.setTelefone(rs.getString("telefone"));
                clienteRetorno.setMorada(rs.getString("morada"));
            }
            conn.close();
            return clienteRetorno;

        } catch (Exception e) {
            System.out.println(e);
        }
        return new Cliente();
    }

    public void selecionarViaturaCliente(int iDCliente) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM viatura WHERE id_cliente=" + iDCliente);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfCols = rsMetaData.getColumnCount();
            while (rs.next()) {
                List<Object> values = new ArrayList<>();
                for (int i = 1; i <= numberOfCols; i++) {
                    Object object = rs.getObject(i);
                    values.add(object);
//                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
//            System.out.printf("%n");
                for (int i = 0; i < values.size(); i++) {
                    System.out.println(values.get(i));
                }
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selecionarFaturacaoCliente(int iDCliente) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = null;
            ResultSet rs = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM faturacao WHERE id_cliente=" + iDCliente);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfCols = rsMetaData.getColumnCount();
            while (rs.next()) {
                List<Object> values = new ArrayList<>();
                for (int i = 1; i <= numberOfCols; i++) {
                    Object object = rs.getObject(i);
                    values.add(object);
//                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
//            System.out.printf("%n");
                for (int i = 0; i < values.size(); i++) {
                    System.out.println(values.get(i));
                }

            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*Update*/
    public static void actualizarCliente(String nome, String password, String dataNascimento, String numeroFiscal, String numeroTelefone, String email, String morada) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE cliente SET password=?, dataNas=?, nrFiscal=?, telefone=?, email=?, morada=?, nome=? WHERE id=?");
            stmt.setString(1, password);
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date dataNascimentoJava = formatter1.parse(dataNascimento);
//        Date sqlDataNasc = new Date(dataNascimentoJava.getTime());
            stmt.setDate(2, Conversoes.obterDataConvertidaParaSqlDatecomParametroString(dataNascimento));
            stmt.setString(3, numeroFiscal);
            stmt.setString(4, numeroTelefone);
            stmt.setString(5, email);
            stmt.setString(6, morada);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*Obter lugares*/
    public void obterLugaresOcupados(String dataInicio, String dataFim) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT id_lugar FROM `reserva`,`lugar` WHERE (dataInicio >=? AND dataFim <=?) AND `reserva`.`id_lugar`=`lugar`.`id`;");
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date dataInicioJava = formatter1.parse(dataInicio);
//        java.util.Date dataFimJava = formatter1.parse(dataFim);
//        Date sqlDataInicio = new Date(dataInicioJava.getTime());
//        Date sqlDataFim = new Date(dataFimJava.getTime());
            stmt.setDate(1, Conversoes.obterDataConvertidaParaSqlDatecomParametroString(dataInicio));
            stmt.setDate(2, Conversoes.obterDataConvertidaParaSqlDatecomParametroString(dataFim));
            rs = stmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfCols = rsMetaData.getColumnCount();
            while (rs.next()) {
                List<Object> values = new ArrayList<>();
                for (int i = 1; i <= numberOfCols; i++) {
                    Object object = rs.getObject(i);
                    values.add(object);
//                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
//            System.out.printf("%n");
                for (int i = 0; i < values.size(); i++) {
                    System.out.println(values.get(i));
                }
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void obterLugaresLivres(String dataInicio, String dataFim) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT id_lugar FROM `reserva`,`lugar` WHERE (dataInicio >=? AND dataFim <=?) AND `reserva`.`id_lugar`!=`lugar`.`id`;");
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date dataInicioJava = formatter1.parse(dataInicio);
//        java.util.Date dataFimJava = formatter1.parse(dataFim);
//        Date sqlDataInicio = new Date(dataInicioJava.getTime());
//        Date sqlDataFim = new Date(dataFimJava.getTime());
            stmt.setDate(1, Conversoes.obterDataConvertidaParaSqlDatecomParametroString(dataInicio));
            stmt.setDate(2, Conversoes.obterDataConvertidaParaSqlDatecomParametroString(dataFim));
            rs = stmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfCols = rsMetaData.getColumnCount();
            while (rs.next()) {
                List<Object> values = new ArrayList<>();
                for (int i = 1; i <= numberOfCols; i++) {
                    Object object = rs.getObject(i);
                    values.add(object);
//                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
//            System.out.printf("%n");
                for (int i = 0; i < values.size(); i++) {
                    System.out.println(values.get(i));
                }
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public void actualizarFuncPreparedStatement(String mesPorExtenso, int numeroFuncionario) throws SQLException {
//        Connection conn = DBConnection.getConnection();
//        PreparedStatement stmt = conn.prepareStatement("UPDATE Funcionarios SET mesPorExtenso=? WHERE numeroFuncionario=?");
//        stmt.setString(1, mesPorExtenso);
//        stmt.setInt(2, numeroFuncionario);
////        stmt.setInt(3, func.getNumeroHorasExtra());
////        stmt.setInt(4, func.getValorHorasExtra());
////        stmt.setInt(5, func.getVencimentoBase());
//        stmt.executeUpdate();
//        conn.close();
//    }
//
//    public void eliminarFuncPreparedStatement(int numeroFuncionario) throws SQLException {
//        Connection conn = DBConnection.getConnection();
//        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Funcionarios WHERE numeroFuncionario=?");
//        stmt.setInt(1, numeroFuncionario);
//        stmt.executeUpdate();
//        conn.close();
//    }
    
}
