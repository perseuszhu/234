package Homework1;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Junjian Zhu
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

public class HiringSystem {
    public static void main(String[] args){
        HiringTable table = new HiringTable();          //Main hiring system
        Scanner in = new Scanner(System.in);
        HiringTable newTable = new HiringTable();       //Backup hiring system
        HiringTable tempTable = new HiringTable();
        HiringTable app1= new HiringTable();//Temporary hiring system when reverting
        boolean status = true;
        while(status) {
            System.out.println();
        System.out.println("(A)   Add Applicant"+"\n"+
        "(R)   Remove Applicant\n"+"(G)   Get Applicant\n"
        +"(P)   Print List\n"+"(RS)  Refine Search\n"+"(S)   Size\n"+
        "(B)   Backup\n"+"(CB)  Compare Backup\n"+"(RB)  Revert Backup\n"+
                "(Q)   Quit");
        System.out.println("Please Enter a Command: ");
        // Create the First menu.
            String command = in.nextLine();
            boolean validInput = false;
            if (command.equalsIgnoreCase("Q")) {
            System.out.println("Quitting program. . .");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ie){}
                status = false;
            }


            if (command.equalsIgnoreCase("A")) {
                Applicant tempa = new Applicant();
                System.out.println("Enter Applicant name: ");
                tempa.setApplicantName(in.nextLine());
                System.out.println("Enter Applicant college: ");
                tempa.setCollege(in.nextLine());
                System.out.println("Enter Applicant GPA: ");
                while (!validInput) {           //repeat try process if an exception is caught
                    try {
                        tempa.setGPA(in.nextDouble());
                        validInput = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("GPA can't be smaller then 0");
                        System.out.println("Enter Applicant GPA: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("GPA should be a Numberic value");
                        System.out.println("Enter Applicant GPA: ");
                        in.next();
                    }
                }

                    in.nextLine();
                    String[] companyname = new String[table.getMaxCompanies()];
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Enter up to " + (3 - i) + " companies");
                        String com = in.nextLine();
                        if (com.equals(""))
                            break;
                        companyname[i] = com;
                    }
                    String[] skills = new String[table.getMaxSkills()];
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Enter up to " + (3 - i) + " skills");
                        String ski = in.nextLine();
                        if (ski.equals(""))
                            break;
                        skills[i] = ski;
                    }
                    tempa.setCompanyName(companyname);
                    tempa.setSkills(skills);
                    try{
                        table.addApplicant(tempa);
                        System.out.println("Applicant "+tempa.getApplicantName()+" successfully added to" +
                                " the hiring system.");
                    }
                    catch (FullTableException e){
                        System.out.println("Table Full");
                    }
            }


            /**
             * initiate remove method in hiringtable
             */

            if(command.equalsIgnoreCase("R")){
                boolean isValid = false;
                System.out.println("Enter Applicant Name: ");
                while(!isValid){
                    try{
                        String name = in.nextLine();
                        table.removeApplicant(name);
                        isValid = true;
                    }catch (Exception e){
                        System.out.println("The applicant cannot be found, please try again.");
                        System.out.println("Enter Applicant Name: ");
                    }
                }

            }

            /**
             * first initiate the get method in hiringtable,
             * then print out the result accordingly.
             * depends on the number of
             * companies and skilss.
             */
            if(command.equalsIgnoreCase("G")){
                boolean validGet = false;
                System.out.println("Enter Applicant Name");
                while(!validGet){
                    try{
                        String name = in.nextLine();
//                        in.nextLine();
                        Applicant currentApplicant = table.getApplicant(name);
                        System.out.println();
                        System.out.println("Printing. . . .");
                        try{
                            Thread.sleep(1000);
                        }catch (InterruptedException ie){}
                        System.out.println();
                        System.out.println("Applicant Name: "+currentApplicant.getApplicantName());
                        String company;
                        String skills;
                        if(currentApplicant.getCompanyName()[0]==null){
                            company = "N/A";
                            System.out.println("Company: "+company);
                        }
                        if(currentApplicant.getCompanyName()[1]==null &&
                                currentApplicant.getCompanyName()[0]!=null){
                            company = (currentApplicant.getCompanyName()[0]);
                            System.out.println("Company: "+company);

                        }
                        if(currentApplicant.getCompanyName()[2]==null &&
                                currentApplicant.getCompanyName()[1]!=null &&
                                currentApplicant.getCompanyName()[0]!=null){
                            company = (currentApplicant.getCompanyName()[0]+" "+ currentApplicant.getCompanyName()[1]);
                            System.out.println("Company: "+company);
                        }
                        if(currentApplicant.getCompanyName()[2]!=null){
                            company = (currentApplicant.getCompanyName()[0]+" "+currentApplicant.getCompanyName()[1]+" "+
                                    currentApplicant.getCompanyName()[2]);
                            System.out.println("Company: "+company);
                        }

                        System.out.println("GPA: "+currentApplicant.getGPA());
                        System.out.println("College: "+currentApplicant.getCollege());


                        if(currentApplicant.getSkills()[0]==null){
                            skills = "N/A";
                            System.out.println("Skills: "+skills);
                        }
                        if(currentApplicant.getSkills()[1]==null &&
                                currentApplicant.getSkills()[0]!=null){
                            skills = (currentApplicant.getSkills()[0]);
                            System.out.println("Skills: "+skills);
                        }
                        if(currentApplicant.getSkills()[2]==null &&
                                currentApplicant.getSkills()[1]!=null &&
                                currentApplicant.getSkills()[0]!=null){
                            skills = (currentApplicant.getSkills()[0]+" "+currentApplicant.getSkills()[1]);
                            System.out.println("Skills: "+skills);
                        }
                        if(currentApplicant.getSkills()[2]!=null){
                            skills = (currentApplicant.getSkills()[0]+" "+currentApplicant.getSkills()[1]+" "+
                                    currentApplicant.getSkills()[2]);
                            System.out.println("Skills: "+skills);
                        }
//                        System.out.println(currentApplicant.toString());
                        validGet = true;
                    }catch(NullPointerException ex){
                        System.out.println("Applicant not found. Please Try again.");
                        System.out.println("Enter Applicant Name.");
                    }
                }

            }

            if(command.equalsIgnoreCase("P")){
                table.printApplicantTable();
            }

            if(command.equalsIgnoreCase("RS")){
                System.out.println("Enter a comapny to filter for:");
                String company = in.nextLine();
                System.out.println("Enter a skill to filter for: ");
                String skill = in.nextLine();
                System.out.println("Enter a college to filter for: ");
                String college = in.nextLine();
                in.nextLine();
                String GPA;
                System.out.println("Enter the minimum GPA to filter for: ");
                GPA = in.nextLine();
                double newG;
                if(!GPA.equalsIgnoreCase("")) {
                    newG = Double.valueOf(GPA);
                }
                else{
                    newG = 0.0;
                }

                table.refineSearch(table,company,skill,college,newG);


            }
            /**
             * use the size method in the Hiringtable to return
             * the current size of the applicant array
             *
             */

            if(command.equalsIgnoreCase("S")){
                int size = table.size();
                System.out.println("There are "+size+" applicants in the hiring system.");
            }

            if(command.equalsIgnoreCase("B")){
//            try{
//                newTable = (HiringTable)table.clone();
//                System.out.println("Successfully created backup!");
//            }catch(CloneNotSupportedException c){
//                System.out.println("Backup failed.");
//            }
                try {
                    for (int i = 0; i < table.size(); i++) {
                        app1.addApplicant(table.getloc(i));
                        System.out.println("Backup Successful!");
                    }
                }catch (FullTableException e){
                    System.out.println("Backup unsuccessful");
                }
            }

            if(command.equalsIgnoreCase("CB")){
            if(table.equals(app1)){
                System.out.println("Current list is the same as the backup copy.");
            }
            else{
                System.out.println("Current list is not the same as the backup copy.");
            }
            }

            if(command.equalsIgnoreCase("RB")){
//                tempTable = table;
//                table = newTable;
//                newTable = tempTable;
//                try {
//                    for (int i = 0; i < app1.size(); i++) {
//                        table.addApplicant(app1.getloc(i));
//                    }
//                }catch (FullTableException e){}
                tempTable = table;
                table=app1;
                app1 = tempTable;
                System.out.println("Successfully reverted to backup copy.");
            }

        }
}

}
