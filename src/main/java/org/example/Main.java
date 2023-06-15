package org.example;

import java.io.*;
import java.util.HashMap;

public class Main {

    static HashMap<String,String> login = new HashMap<>();

    public static void main(String[] args) throws IOException {
         load();



    }

    public static void load() throws IOException {
        boolean success = true;
        while (success) {
            String inputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\usuarios_contrasenas.txt";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(inputFilename));


                String line;
                String user = null;
                String pass = null;
                boolean primero = true;
                String actual = null;
                while ((line = bufferedReader.readLine()) != null) {
                    primero = true;
                    user = "";
                    pass = "";
                    for (int i = 0; i < line.length(); i++) {
                        actual = String.valueOf(line.charAt(i));
                        if (actual.equals(",")) {
                            i = i + 1;
                            primero = false;
                        }
                        if (primero) {
                            user = user + line.charAt(i);

                        } else {
                            pass = pass + line.charAt(i);
                        }
                    }
                    login.put(user, pass);
                    System.out.println(user + pass);
                    success = false;

                }
                // bufferedWriter.write(line + "\n");

            } catch (IOException e) {
                System.out.println("IOException catched while reading: " + e.getMessage());
                String f = "usuarios_contrasenas.txt";
                new File("C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db", f).createNewFile();
                String outputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\usuarios_contrasenas.txt";
                BufferedWriter bufferedWriter = null;

                try {

                    bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));


                    bufferedWriter.write("admin,admin\n");


                } catch (IOException e2) {
                    System.out.println("IOException catched while reading: " + e2.getMessage());
                } finally {
                    try {

                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (IOException e2) {
                        System.out.println("IOException catched while closing: " + e.getMessage());
                    }
                }

            }

        }
    }

}