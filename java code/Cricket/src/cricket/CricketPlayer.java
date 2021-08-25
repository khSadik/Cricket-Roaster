/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket;

/**
 *
 * @author sadik
 */
public class CricketPlayer {
        private String playerName;
        private int jerseyNumber;
        private double salary;
        public CricketPlayer(String playerName, int jerseyNumber, double salary) {
                
                this.playerName = playerName;
                this.jerseyNumber = jerseyNumber;
                this.salary = salary;
        }
        public String getPlayerName() {
                return playerName;
        }
        public int getJerseyNumber() {
                return jerseyNumber;
        }
        public double getSalary() {
                return salary;
        }       
    
}
