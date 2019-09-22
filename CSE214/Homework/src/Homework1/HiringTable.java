
package Homework1;

import java.util.Scanner;


/**
 * @author Junjian Zhu R05
 *     e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/


public class HiringTable implements Cloneable {
    /**
     * State the Static variables
     */
    private static int MAX_APPLICANTS = 50;
    private static int MAX_COMPANIES = 3;
    private static int MAX_SKILLS = 3;
    private Applicant[] applicants = new Applicant[MAX_APPLICANTS];   //Create an Array of Applicants
    private int applicantsStored = 0;     //Memorize the amount of Applicants within the Array

    public static int getMaxApplicants() {
        return MAX_APPLICANTS;
    }

    public static int getMaxCompanies() {
        return MAX_COMPANIES;
    }

    public static int getMaxSkills() {
        return MAX_SKILLS;
    }


    public HiringTable(){}      //empty constructor

    public HiringTable(Applicant[] applicants){}

    private boolean equals (HiringTable a, HiringTable b){
        if(a.size()!=b.size()){
            return false;
        }
        for(int i =0;i<a.size(); i++){
            if(a.applicants[i].getApplicantName().equals(b.applicants[i].getApplicantName())&&
                    a.applicants[i].getGPA()==b.applicants[i].getGPA()&&
                    a.applicants[i].getCollege().equals(b.applicants[i].getCollege())){
                return true;
            }
        }
        return false;
    }

    /**
     * By using a additional variable that add or minus one when we are adding or
     * removing applicant we cant get the size of the Hiring System with O(1) Operations.
     * @return
     */

    public int size(){
        return applicantsStored;
    } //return the current number of applicant within the array.

    public void addApplicant(Applicant applicant)
            throws FullTableException{ //Add a Applicant object to the Applicant array

        if(applicantsStored < MAX_APPLICANTS) {
            applicants[applicantsStored] = applicant;
            applicantsStored++;
    }

        }


    /**
     *Go through all the Applicant objects within the hiring table to find out which applicant have the same name
     * as the input.
     * @param
     * @return
     */
    public Applicant getApplicant(String name){         // use a for loop to go through all the data with
//            try{for(int i = 0; i<applicantsStored; i++) {       //the array and find the one that shares the same name.
                for(int i = 0; i<applicantsStored; i++) {
                    if(applicants[i].getApplicantName().equalsIgnoreCase(name)){
                    return applicants[i];
                }
//                throw new Exception();
            }
//            catch (Exception e){
//                System.out.println("Applicant Not Found");
//            }
            return null;
        }

        public String[] getApplicantname(HiringTable table){
            String[] a =new String[table.size()];
        for(int i=0; i<table.size(); i++){
            a[i]=table.applicants[i].getApplicantName();
        }
        return a;
        }
        
    /**
     *Same logic as above, we first find out which applicant is the one that we are about to remove. get the location
     * in the array of this applicant. simply move all the applicant after this location one spot forward will remove
     * this applicant.
     * @param name the name of the applicant we are about to remove
     */
    public void removeApplicant(String name){
        boolean isValid = false;
        int location = 0;
            try{
                for(int i = 0; i<applicantsStored; i++) {
                if (applicants[i].getApplicantName().equalsIgnoreCase(name)) {
                    location = i;
                }
            }
                for(int i =location; i<applicantsStored; i++){
                    applicants[i] = applicants[i+1];
                }
                applicantsStored--;
                System.out.println("Applicant "+name+" has been successfully removed from the hiring system.");
            }
            catch (Exception e){
            }
        }

        public Object clone() throws CloneNotSupportedException{
            HiringTable clone = (HiringTable)super.clone();
            return clone;
        }

    /**
     * Refine search will use several if loop, if the input value of any one of the value required is null, skip this
     * variable and go to the next if loop and repeat the same step. once all the filters are finished, print out the remaining
     * applicants.
     * @param table which table we are looking for
     * @param company which company does the applicant need to come from
     * @param skill which skill is required for the applicants
     * @param college which college is required for the applicants
     * @param GPA what is the minimum gpa for the applicants
     */
        public static void refineSearch(HiringTable table, String company, String skill, String college, double GPA){
            int loc = table.size();
//        for(int i=0; i<table.size();i++){
//            for(int j=0; j<table.size(); j++){
//                if (table.applicants[j].getCollege().equalsIgnoreCase(college)){
//                    loc[i] =j;
//                }
//            }
//        }
            for (int i=0; i<loc; i++){
                String companyname;
                String skills;
                companyname = table.applicants[i].getCompanyName()[0]+" "+table.applicants[i].getCompanyName()[1]+" "+
                        table.applicants[i].getCompanyName()[2];
                skills = table.applicants[i].getSkills()[0]+" "+table.applicants[i].getSkills()[1]+" "+
                        table.applicants[i].getSkills()[2];
                companyname = companyname.toLowerCase();
                skills = skills.toLowerCase();
                if(company.equals("")||companyname.contains(company.toLowerCase())){
                    if(skill.equals("")||skills.contains(skill.toLowerCase())){
                        if(college.equals("")||college.equalsIgnoreCase(table.applicants[i].getCollege())){
                            if(GPA==0||table.applicants[i].getGPA()>=GPA){
                                System.out.println(table.applicants[i].toString());
                                System.out.println();
                            }
                        }
                    }
                }
//                if (table.applicants[i].getCollege().equalsIgnoreCase(college) || college.equalsIgnoreCase("")){
//                    if(table.applicants[i].getCompanyName()[0].equalsIgnoreCase(company)||
//                            table.applicants[i].getCompanyName()[1].equalsIgnoreCase(company)||
//                            table.applicants[i].getCompanyName()[2].equalsIgnoreCase(company)||
//                            company.equalsIgnoreCase("")){
//                         if(skill.equalsIgnoreCase("")||table.applicants[i].getSkills()[0].equalsIgnoreCase(skill)||
//                                 table.applicants[i].getSkills()[1].equalsIgnoreCase(skill)||
//                                 table.applicants[i].getSkills()[2].equalsIgnoreCase(skill)){
//                             if(table.applicants[i].getGPA()>=GPA||GPA==0){
//                                 System.out.println(table.applicants[i].toString());
//                             }
//                         }
//                    }
//                }


            }

        }

    /**
     * First display the top part of the chart, containing several element of the applicant,
     * then print out each applicant
     * within the applicant array accordingly.
     *
     */
    public void printApplicantTable(){
            System.out.printf("%-25s","Applicant");
            System.out.printf("%-30s","Company Name");
            System.out.printf("%-28s","GPA");
            System.out.printf("%-30s","College");
            System.out.printf("%-30s","Skills");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------" +
                    "-------------------------------------------");
            for(int i=0; i<applicantsStored; i++){
                    System.out.printf("%-25s",applicants[i].getApplicantName());
                    String company;
                    String skills;
                    if(applicants[i].getCompanyName()[0]==null){
                        company = "N/A";
                        System.out.printf("%-30s",company);
                    }
                    if(applicants[i].getCompanyName()[1]==null && applicants[i].getCompanyName()[0]!=null){
                        company = (applicants[i].getCompanyName()[0]);
                        System.out.printf("%-30s",company);

                    }
                    if(applicants[i].getCompanyName()[2]==null && applicants[i].getCompanyName()[1]!=null &&
                            applicants[i].getCompanyName()[0]!=null){
                        company = (applicants[i].getCompanyName()[0]+", "+applicants[i].getCompanyName()[1]);
                        System.out.printf("%-30s",company);
                    }
                    if(applicants[i].getCompanyName()[2]!=null){
                        company = (applicants[i].getCompanyName()[0]+", "+applicants[i].getCompanyName()[1]+", "+applicants[i].getCompanyName()[2]);
                        System.out.printf("%-30s",company);
                    }

                    System.out.printf("%-28s",applicants[i].getGPA());
                    System.out.printf("%-30s",applicants[i].getCollege());


                    if(applicants[i].getSkills()[0]==null){
                        skills = "N/A";
                        System.out.printf("%-30s",skills);
                    }
                    if(applicants[i].getSkills()[1]==null && applicants[i].getSkills()[0]!=null){
                        skills = (applicants[i].getSkills()[0]);
                        System.out.printf("%-30s",skills);
                    }
                    if(applicants[i].getSkills()[2]==null && applicants[i].getSkills()[1]!=null &&
                        applicants[i].getSkills()[0]!=null){
                        skills = (applicants[i].getSkills()[0]+", "+applicants[i].getSkills()[1]);
                        System.out.printf("%-30s",skills);
                        }
                    if(applicants[i].getSkills()[2]!=null){
                        skills = (applicants[i].getSkills()[0]+", "+applicants[i].getSkills()[1]+", "+
                                applicants[i].getSkills()[2]);
                        System.out.printf("%-30s",skills);
                    }
//                    System.out.print(" "+applicants[i].getSkills()[1]);
//                    System.out.print(" "+applicants[i].getSkills()[2]);
                    System.out.println();


            }
        }
        public Applicant getloc(int loc){
            return applicants[loc];
        }

}



