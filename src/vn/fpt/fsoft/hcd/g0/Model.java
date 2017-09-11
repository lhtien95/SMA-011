package vn.fpt.fsoft.hcd.g0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Model {
        
        static final String CLASS_FILE_PATH = ".\\Data\\class.txt";
        static final String STUDENT_FILE_PATH = ".\\Data\\student.txt";
        static final String SUBJECT_FILE_PATH = ".\\Data\\subject.txt";
        static final String GRADE_FILE_PATH = ".\\Data\\grade.txt";
        
        public boolean isExistedClass(String id) {
                
        		BufferedReader br = null;
                try{
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((id.toLowerCase()).equals(line.split("_")[0].toLowerCase())) {
                                        return true;
                                }
                        }
                        
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
                finally {
                		try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                }
                
                return false;
        }
        
        public boolean isEmptyClass(String id) {
                
	        	BufferedReader br = null;    
	        	try{
                        FileReader fr = new FileReader(STUDENT_FILE_PATH);
                        br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((id.toLowerCase()).equals(line.split("_")[5].toLowerCase())) {
                                        return false;
                                }
                        }
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
	        	finally {
		        		try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        }
                
                return true;
        }
        
        public boolean isExistedStudent(String id) {
                
        		BufferedReader br = null;
                try{
                        FileReader fr = new FileReader(STUDENT_FILE_PATH);
                        br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((id.toLowerCase()).equals(line.split("_")[0].toLowerCase())) {
                                        return true;
                                }
                        }
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
                finally {
		        		try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        }
                
                return false;
        }
        
        public boolean isExistedSubject(String id) {
                
                try{
                        FileReader fr = new FileReader(SUBJECT_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((id.toLowerCase()).equals(line.split("_")[0].toLowerCase())) {
                                        return true;
                                }
                        }
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
                
                return false;
        }
        
        public boolean isExistedGrade(String studentID, String subjectID) {
                
                try{
                        FileReader fr = new FileReader(GRADE_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        while((line = br.readLine()) != null) {
                                if ((studentID.toLowerCase()).equals(line.split("_")[0].toLowerCase())
                                     && subjectID.toLowerCase().equals(line.split("_")[1].toLowerCase())) {
                                        return true;
                                }
                        }
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
                
                return false;
        }
        
        public void addClassToFile(String id, String name) {
        	
        	try {
        	        FileWriter fw = new FileWriter(CLASS_FILE_PATH,true);
        		    BufferedWriter bw = new BufferedWriter(fw);
        		    bw.newLine();
        		    bw.append(id.toUpperCase()+"_"+name.toUpperCase());
    			    bw.close();
        	}
        	catch(FileNotFoundException e) {
                    e.printStackTrace();
            }
            catch(IOException ioe) {
                    ioe.printStackTrace();
            }
        	
        }
        
        public void renameClass(String id, String name) {
                
                try {
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        ArrayList<String> lineList = new ArrayList<String>();
                        String line;
                        
                        while((line = br.readLine()) != null) {
                            lineList.add(line);
                        }
                        br.close();
                        PrintWriter pr = new PrintWriter(CLASS_FILE_PATH);
                        for(int i=0; i < lineList.size() ;i++){
                            line = lineList.get(i);
                            if(line.split("_")[0].toLowerCase().equals(id.toLowerCase())) {
                                line= id.toUpperCase() + "_" + name.toUpperCase();
                            }
                            pr.println(line);
                        }
                        pr.flush();
                        pr.close();
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
                
        }
        
        public void deleteClass(String id) {
                
                try {
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        ArrayList<String> lineList = new ArrayList<String>();
                        String line;
                        
                        while((line = br.readLine()) != null) {
                            lineList.add(line);
                        }
                        br.close();
                        PrintWriter pr = new PrintWriter(CLASS_FILE_PATH);
                        for(int i=0; i < lineList.size() ;i++){
                            line = lineList.get(i);
                            if(line.split("_")[0].toLowerCase().equals(id.toLowerCase())) {
                                continue;
                            }
                            pr.println(line);
                        }
                        pr.flush();
                        pr.close();
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
        }
        
        public void listAllClass() {
                try{
                        FileReader fr = new FileReader(CLASS_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        while((line = br.readLine()) != null) {
                                View.showMessage(line.split("_")[0] + " " + line.split("_")[1] + "\n");
                        }
                }
                catch(Exception e){
                        e.printStackTrace();
                }
        }
        
        public void searchStudent(String keyword) {
                
                try {
                        FileReader fr = new FileReader(STUDENT_FILE_PATH);
                        BufferedReader br = new BufferedReader(fr);
                        String line;
                        
                        View.showMessage("Result\n");
                        while((line = br.readLine()) != null) {
                                if (line.split("_")[1].toLowerCase().contains(keyword.toLowerCase())) {
                                        View.showMessage(line.split("_")[1] + "\n");
                                }
                        }
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
        }
        
        public void addGradeToFile(String studentID, String subjectID, String grade) {
                
                try {
                        FileWriter fw = new FileWriter(GRADE_FILE_PATH,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.newLine();
                        bw.append(studentID.toUpperCase() + "_" + subjectID.toUpperCase() + "_" + grade);
                        bw.close();
                }
                catch(FileNotFoundException e) {
                        e.printStackTrace();
                }
                catch(IOException ioe) {
                        ioe.printStackTrace();
                }
                
            }

}
