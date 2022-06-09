/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import io.vertx.core.Vertx;

/**
 *
 * @author LSIS- Grupo 3
 * 1201141 - Bernardo Oliveira
 * 1200928 - Carla Barbosa
 * 1201822 - Daniel Graça
 * 1201059 - Francisca Ribeiro
 * 1200638 - João Ferreira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new VerticleRSJson());

        System.out.println("serververticle running");
    }

}
