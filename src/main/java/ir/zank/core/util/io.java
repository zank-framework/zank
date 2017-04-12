/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.zank.core.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnm
 */
public class io {
    
    public void savetocsv(String data,String filename) {

        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(filename, true)));
            out.println(data);
            out.close();
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
    }

    public List<String> readfromfile(File f) {
        List<String> out = new ArrayList();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.length() != 0) {
                    out.add(sCurrentLine);
                }
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("File robot8.txt Readed...." + out.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return out;
    }
    public String stringfromfile(File f) {
        String out ="";

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.length() != 0) {
                    out+=(sCurrentLine)+"\n";
                }
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return out;
    }
}
