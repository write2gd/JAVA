/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dasg
 */
public class FileIndexing { 
  private FileIndexing() { }

    public static void main(String[] args)throws Exception{
     HashMap<String, Set<File>> st = new HashMap<>();

        // create inverted index of all files
        StdOut.println("Indexing files");
        for (String filename : args) {
            StdOut.println("  " + filename);
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String word = null;
            while((word = br.readLine())!= null) {
                if (!st.contains(word)) st.put(word, new HashSet<>());
                Set<File> set = st.get(word);
                set.add(file);
            }
        }


        // read queries from standard input, one per line
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.contains(query)) {
                Set<File> set = st.get(query);
                set.stream().forEach((file) -> {
                    StdOut.println("  " + file.getName());
                });
            }
        }

    }

}
