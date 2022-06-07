/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testeFuncoes;

import DataBase.DAL;
import Model.AssociacaoJuriCompeticao;
import Model.AssociacaoRobotRonda;
import Model.AssociacaoRondaCompeticao;
import Model.Competicao;
import Model.Equipa;
import Model.Robot;
import Model.Ronda;
import java.util.Date;

/**
 *
 * @author joaoferreira
 */
public class testeFuncoesDAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAL d = new DAL();

        /*OBJECTOS*/

 /*Inserir competicao*/
//        Competicao c = new Competicao();
//        c.setNomeCompeticao("LSIS");
//        Date dataCriacao = new Date();
//        c.setDataCriacao(dataCriacao);
//        System.out.println(c.toString());
//        d.inserirCompeticao(c);

        /* Inserir ronda*/
//        Ronda r = new Ronda();
//        r.setIdCompeticao(1);
//        r.setTipoRonda("Competição");
//        System.out.println(r.toString());
//        d.inserirRonda(r);

        /*Inserir equipa*/
//        Equipa e = new Equipa ();
//        e.setNomeEquipa("Grupo 3");
//        System.out.println(e.toString());
//        d.inserirEquipa(e);

        /*Inserir robot*/
//        Robot rt = new Robot();
//        rt.setIdEquipa(1);
//        rt.setMacAdress("24:6F:28:B1:96:AC");
//        rt.setNomeRobot("kit");
//        System.out.println(rt.toString());
//        d.inserirRobot(rt);

        /*Actualizar*/
//        d.actualizarCompeticao(1, "LSIS1", new Date());
//        d.actualizarRonda(1, "Teste");
//        d.actualizarEquipa(1, "Grupo 03");
//        d.actualizarRobot(1, "thunderbolt", "24:6F:28:B1:96:AC");

        /*Eliminar*/
//        d.eliminarRobot(1);

        /*ASSOCIAÇÕES*/
 /*Inserir AssociacaoRondaCompeticao*/
//        AssociacaoRondaCompeticao aRc = new AssociacaoRondaCompeticao ();
//        aRc.setIdRonda(1);
//        aRc.setIdCompeticao(1);
//        System.out.println(aRc.toString());
//        d.inserirAssociacaoRondaCompeticao(aRc);

        /*Inserir AssociacaoRobotRonda*/
//        AssociacaoRobotRonda aRr = new AssociacaoRobotRonda();
//        aRr.setIdRobot(1);
//        aRr.setIdRonda(1);
//        aRr.setTempo(10.3);
//        aRr.setVelocidade(100);
//        System.out.println(aRr.toString());
//        d.inserirAssociacaoRobotRonda(aRr);

        /*Inserir AssociacaoJuriCompeticao*/
        AssociacaoJuriCompeticao aJc = new AssociacaoJuriCompeticao();
        aJc.setIdJuri(1);
        aJc.setIdCompeticao(1);
        System.out.println(aJc.toString());
        d.inserirAssociacaoJuriCompeticao(aJc);
    }

}