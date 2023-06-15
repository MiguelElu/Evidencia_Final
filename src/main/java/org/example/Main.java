package org.example;

import java.io.*;
import java.util.HashMap;

public class Main {

    static HashMap<String,String> login = new HashMap<>();

    public static void main(String[] args) throws IOException {
         load();
         loadd();



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
    public static void loadd() throws IOException {
        boolean success = true;
        while (success) {
            String inputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\doctores.txt";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(inputFilename));


                String line;
                String id = null;
                String nom = null;
                String esp = null;
                boolean primero = true;
                boolean segundo = true;
                String actual = null;
                while ((line = bufferedReader.readLine()) != null) {
                    primero = true;
                    segundo = true;
                    id = "";
                    nom = "";
                    esp = "";
                    for (int i = 0; i < line.length(); i++) {
                        actual = String.valueOf(line.charAt(i));
                        if (actual.equals(",")) {
                            if (primero) {
                                i = i + 1;
                                primero = false;
                            } else {
                                i = i + 1;
                                segundo = false;
                            }
                        }
                        if (primero&&segundo) {
                            id = id + line.charAt(i);

                        } else if (segundo){
                            nom = nom + line.charAt(i);
                        }
                        else esp = esp +line.charAt(i);
                    }

                    System.out.println(id+" "+ nom +" "+ esp);
                    success = false;

                }
                // bufferedWriter.write(line + "\n");

            } catch (IOException e) {
                System.out.println("IOException catched while reading: " + e.getMessage());
                String f = "doctores.txt";
                new File("C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db", f).createNewFile();
                String outputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\doctores.txt";
                BufferedWriter bufferedWriter = null;

                try {

                    bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));


                    bufferedWriter.write("d1,ejemplo,ejemplo\n");


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