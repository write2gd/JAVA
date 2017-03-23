/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gd.java.test.tc;

/**
 *
 * @author dasg
 */
public class RunTimeExp {
    public static void main(String[] args) {
       
            for(int i=1;i<=10;i++){
                 try{
                System.out.println("Before Exp "+i);
            int a = 9/0;
            System.out.println("After Exp "+i);
            }                
        catch(Exception e){
            System.out.println("In Catch "+i);
                    }    
        finally{
            System.out.println("In Final "+i);
        }
            }
    }
}
