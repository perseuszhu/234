
package Homework1;

import java.util.Arrays;

/**
 * @author Junjian Zhu
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

public class Applicant {
    private String[] companyName;
    private String applicantName;
    private double GPA;
    private String College;
    private String[] skills;

    public Applicant(){}
    public Applicant(String[] companyName, String applicantName, double GPA,
                     String College, String[] skills){
        this.companyName = companyName;
        this.applicantName = applicantName;
        this.GPA = GPA;
        this.College = College;
        this.skills = skills;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String[] getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String[] companyName) {
        this.companyName = companyName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        if(GPA < 0){
            throw new IllegalArgumentException("GPA can't be smaller then 0");
        }
        this.GPA = GPA;
        }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Applicant Name:" +applicantName +"\n"+
                "Company Name:" + (companyName == null ? null : Arrays.asList(companyName)) +
                "\n" +
                "GPA: " + GPA +"\n"+
                "College: " + College + "\n" +
                "Skills: " + (skills == null ? null : Arrays.asList(skills));
    }
    public String toString1(){
        return  "%-25s"+applicantName +
                "%-30s" + (companyName == null ? null : Arrays.asList(companyName)) +
                "%-28s" + GPA +
                "%-30s" + College +
                "%-30s" + (skills == null ? null : Arrays.asList(skills));
    }
}
