package Homework3;

import Homework1.EmptyTableException;

import java.io.*;
import java.util.Scanner;

/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/
public class BlockTracer {

    public static boolean pri(Block block, String name){
        for(int j=0; j<block.getSize(); j++){
            if(block.getVariables()[j].getName().equals(name)){
                System.out.printf("%-30s","Variable name");
                System.out.printf("%-30s","Initial Value");
                System.out.println();
                System.out.printf("%-30s",block.getVariables()[j].getName());
                System.out.printf("%-30s",block.getVariables()[j].getInitialValue());
                System.out.println();
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws FullStackException {

        Block block = new Block();
        BlockStack stack = new BlockStack();
        BlockStack tempStack = new BlockStack();
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter File name and path: ");
        String fileName = in.nextLine();
        /**
         * read the input file
         */
        try{
            File file = new File(fileName);
            Scanner filein = new Scanner(file);
            while(filein.hasNextLine()){
                Variable variable = new Variable();
                String data = filein.nextLine();
                /**
                 * if current line have {, push the preivous block into the blockstack
                 * and create a new block for all upcoming varible in this bracket
                 */
                if(data.contains("{")){
                    try {
                        stack.push(block);
                        block = new Block();
                    } catch (FullStackException e) {}
                }
                /**
                 * if current line contains int, find out it is a variable declaration or print
                 * if it is a integer variable declaration. read the variable name and value accordingly
                 * store them as variable objects and store theses objects in the current block
                 * if it is a print method, determine whether its print all or print a specific
                 * variable.
                 */
                if(data.contains("int ")){
                    String newdata1;
                    if(data.contains("{")&&data.contains("}")){
                        newdata1 = data.substring(data.indexOf("i"),data.indexOf(";")+1);
                        if(newdata1.contains("=")){
                            String[] arr = newdata1.split(" ");
                            String[] val = arr[1].split("=");
                            variable.setName(val[0]);
                            variable.setInitialValue(Integer.parseInt(val[1].substring(0,val[1].indexOf(";"))));
                            block.addVariable(variable);
                        }
                        else{
                            String[] arr = newdata1.split(" ");
                            variable.setName(arr[1].substring(0,arr[1].indexOf(";")));
                            variable.setInitialValue(0);
                            block.addVariable(variable);
                        }
                    }
                    if(data.contains(",")){
                        String newdata = data.substring(data.indexOf("i"),data.indexOf(";")+1);
                        variable = new Variable();
                        String[] arr = newdata.split(", ");
                        String[] va1 = arr[0].split(" ");
                        if(arr[0].contains(" = ")){
                            variable.setName(va1[1]);
                            variable.setInitialValue(Integer.parseInt(va1[3]));
                            block.addVariable(variable);
                        }
                        else if(!arr[0].contains(" = ")){
                            variable = new Variable();
                            variable.setName(va1[1]);
                            variable.setInitialValue(0);
                            block.addVariable(variable);
                        }
                        for(int i=1; i<arr.length-1; i++){
                            variable = new Variable();
                            String[] vari = arr[i].split(" = ");
                            variable.setName(vari[0]);
                            variable.setInitialValue(Integer.parseInt(vari[1]));
                            block.addVariable(variable);
                        }
                        String vafinal = arr[arr.length-1].substring(0,arr[arr.length-1].indexOf(";"));
                        if(vafinal.contains(" = ")){
                            variable = new Variable();
                            String[] varf = vafinal.split(" = ");
                            variable.setName(varf[0]);
                            variable.setInitialValue(Integer.parseInt(varf[1]));
                            block.addVariable(variable);
                        }
                        else{
                            variable = new Variable();
                            variable.setName(vafinal);
                            variable.setInitialValue(0);
                            block.addVariable(variable);
                        }
                    }
                    else if(!data.contains("print")){
                        String newdata = data.substring(data.indexOf("i"),data.indexOf(";")+1);
                        if(newdata.contains("=")){
                            String[] arr = newdata.split(" ");
                            variable.setName(arr[1]);
                            variable.setInitialValue(Integer.parseInt(arr[3].substring(0,arr[3].indexOf(";"))));
                            block.addVariable(variable);
                        }
                        else{
                            String[] arr = newdata.split(" ");
                            variable.setName(arr[1].substring(0,arr[1].indexOf(";")));
                            variable.setInitialValue(0);
                            block.addVariable(variable);
                        }
                    }
                    if(data.contains("print")){
                        if(data.contains("LOCAL")){
                            if(block.getSize()!=0)
                            block.print();
                            else{
                                System.out.println("No local variable to print");
                                System.out.println();
                            }


                        }
                        else{
                            boolean found = false;
                            boolean finish = false;
                            String newstr = data.substring(data.indexOf("/"),data.lastIndexOf("/"));
                            String[] newstrarr = newstr.split(" ");
                            String varname = newstrarr[1].substring(0,newstrarr[1].indexOf("*"));
                            while(!found){
                                if(block.psVar(varname)){
                                    found = true;
                                }
                                else if(stack.getSize()<=1){
                                    System.out.println("Variable not found: "+varname);
                                    System.out.println();
                                    found = true;
                                }
                                else{
                                    tempStack.push(block);
                                    block = stack.pop();
//                                    if(block.psVar(varname)){
//                                        found = true;
//                                    }
                                }

                            }
                            while(found&&!finish){
                                if(!tempStack.isEmpty()){
                                    stack.push(tempStack.pop());
                                }
                                else{
                                    finish = true;
                                }
                            }
                        }
                    }
                }
                if(data.contains("}")){
                    stack.pop();
                }
            }
            /**
             * if file not exist, catch the exception and throw a warning.
             */
        }catch (IOException e){
            System.out.println("File not Found");
        }
//        Variable var = new Variable();
//        var.setInitialValue(3);
//        var.setName("jk");
//        block.addVariable(var);
//        block.print();





}


}
