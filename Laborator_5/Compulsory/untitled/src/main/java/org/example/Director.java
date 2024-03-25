package org.example;

import java.io.File;

class Director {
    private final File directorPrincipal;

    public Director(String pathDirector) {
        this.directorPrincipal = new File(pathDirector);
        if (!this.directorPrincipal.exists())
            throw new IllegalArgumentException("Fisierul/documentul nu este un director/folder");
        if(!this.directorPrincipal.isDirectory())
            throw new IllegalArgumentException("Calea nu duce catre un folder/director");
    }

    public void displayComponents() {
        File[] subdirectoare = directorPrincipal.listFiles();
        if (subdirectoare == null || subdirectoare.length == 0)
        {
            System.out.println("Director vid");
            return;
        }

        for (File directorPersoana : subdirectoare)
        {
            if (directorPersoana.isDirectory())
            {
                System.out.println("ID Persoană: " + directorPersoana.getName());
                File[] documente = directorPersoana.listFiles();
                if (documente != null)
                    for (File document : documente)
                        if (document.isFile())
                            System.out.println("\tDocument: " + document.getName());
            }
        }

    }
}