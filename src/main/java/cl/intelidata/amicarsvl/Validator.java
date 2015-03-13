/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicarsvl;

import cl.intelidata.amicarsvl.util.MCrypt;

/**
 *
 * @author Maze
 */
public class Validator {

    public Boolean validateInputs(String user, String process) {
        return user != null && process != null;
    }

    public String desencryptInput(String input) {
        String decrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            decrypted = new String(mcrypt.decrypt(input));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decrypted;
    }

    public String encryptInputs(String input) {
        String encrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            encrypted = MCrypt.bytesToHex(mcrypt.encrypt("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encrypted;
    }
}
