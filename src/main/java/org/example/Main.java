package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static HashMap<String,String> login = new HashMap<>();
    static ArrayList<doctor> doctores = new ArrayList<doctor>();
    static ArrayList<paciente> pacientes = new ArrayList<paciente>();
    static ArrayList<cita> citas = new ArrayList<cita>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        load();
        loadd();
        loadp();
        loadc();
         boolean activousuario = true;
         while (activousuario){
             System.out.println("Ingrese usuario");
             String res = br.readLine();

             if (login.containsKey(res)) {
                 System.out.println("Ingrese contraseña");
                 String pass = br.readLine();
                 if (pass.equals(login.get(res))){
                     activousuario = false;
                 } else {System.out.println("Error de contraseña");}
             }else {System.out.println("Error de usuario");}

         }



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
                    doctor temp = new doctor(id,nom,esp);
                    doctores.add(temp);

                }
                // bufferedWriter.write(line + "\n");
               success = false;
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
    public static void loadp() throws IOException {
        boolean success = true;
        while (success) {
            String inputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\pacientes.txt";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(inputFilename));


                String line;
                String id = null;
                String nom = null;

                boolean primero = true;

                String actual = null;
                while ((line = bufferedReader.readLine()) != null) {
                    primero = true;

                    id = "";
                    nom = "";

                    for (int i = 0; i < line.length(); i++) {
                        actual = String.valueOf(line.charAt(i));
                        if (actual.equals(",")) {

                                i = i + 1;
                                primero = false;

                            }

                        if (primero) {
                            id = id + line.charAt(i);

                        } else
                            nom = nom + line.charAt(i);
                        }
                    paciente temp = new paciente(id,nom);
                    pacientes.add(temp);
                    }
                success = false;


                // bufferedWriter.write(line + "\n");

            } catch (IOException e) {
                System.out.println("IOException catched while reading: " + e.getMessage());
                String f = "pacientes.txt";
                new File("C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db", f).createNewFile();
                String outputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\pacientes.txt";
                BufferedWriter bufferedWriter = null;

                try {

                    bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));


                    bufferedWriter.write("d1,ejemplo\n");


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

    public static void loadc() throws IOException {
        boolean success = true;
        while (success) {
            String inputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\citas.txt";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(inputFilename));


                String line;
                String id = null;
                String fecha = null;
                String motivo = null;
                boolean primero = true;
                boolean segundo = true;
                String actual = null;
                while ((line = bufferedReader.readLine()) != null) {
                    primero = true;
                    segundo = true;
                    id = "";
                    fecha = "";
                    motivo = "";
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
                            fecha = fecha + line.charAt(i);
                        }
                        else motivo = motivo +line.charAt(i);
                    }
                    cita temp = new cita(id,fecha,motivo);
                    citas.add(temp);

                }
                // bufferedWriter.write(line + "\n");
                success = false;
            } catch (IOException e) {
                System.out.println("IOException catched while reading: " + e.getMessage());
                String f = "citas.txt";
                new File("C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db", f).createNewFile();
                String outputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\EvidFinal\\db\\citas.txt";
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