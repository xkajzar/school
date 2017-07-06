package com.sample;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.drools.runtime.rule.QueryResultsRow;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;



/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            
        	// load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	int i=0, j=0;
        	
    		
    		char[] substr1 = new char[50];
    		char[] substr2 = new char[50];
    		char[] substr3 = new char[50];
    		char c;
    		//kSession.getFactHandles()
    		
    		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    		while((c=(char) br.read())!='\n'){
    			i=0;
    			substr1[i]=c;
    			i++;
    		while((c=(char)br.read())!='\n' && c!= '<' ){
    		substr1[i]=c;	
    		i++;
    		}
    		if(c=='\n')
    			break;
    		j=i;
    		String sstr1=new String(substr1);
    		sstr1=sstr1.substring(0, j);
    		
    		
    		i=0;
    		
    		while((c=(char)br.read())!='<'){
    			substr2[i]=c;
    			i++;
    		}
    		
    		j=i;
    		String sstr2=new String(substr2);
    		sstr2=sstr2.substring(0, j);
    		
    		i=0;
    		
    		while((c=(char)br.read())!='\n'){
    			substr3[i]=c;
    			i++;
    		}
    		j=i-1;
    		String sstr3=new String(substr3);
    		sstr3=sstr3.substring(0, j);
    		
    		i=0;
    		
    		
    	/*	String sstr1=new String(substr1);
    		String sstr2=new String(substr2);
    		String sstr3=new String(substr3);*/
    		
    		System.out.println(sstr1 + " " +sstr2+ " " +sstr3);
    		
    		//System.out.println(sstr3 + sstr3.length());
    		kSession.insert(new Message(sstr1, sstr2, sstr3));
    		//System.out.println(str1.toString());
    		}
    		br.close();
    	

        
    i=0;
        	
        	// go !
            Message message[]= new Message[10];
            
            
            message[i] = new Message();
            message[i].setName("Jozo");
            message[i].setRule("je rodic");
            message[i].setName2("Jano");
            kSession.insert(message[i]);
 
            i++;
            message[i] = new Message();
            
            
            message[i].setName("Klara");
            message[i].setRule("je rodic");
            message[i].setName2("Jano");
            kSession.insert(message[i]);
            
            i++;
            message[i] = new Message();
            
            message[i].setName("Klara");
            message[i].setRule("je rodic");
            message[i].setName2("Juro");
            kSession.insert(message[i]);
            
            kSession.fireAllRules();
            System.out.println(kSession.getFactCount());
           
          

            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        
    	List<String> list;
    	protected String name;
        protected String rulestr;
        protected String name2;
    public Message(){
    	
    }
        
        public Message(String name, String rulestr,
        String name2) {
        this.name = name;
        this.rulestr=rulestr;
        this.name2=name2;
        }
        

		public String toString() {
        return "[UI_" + this.hashCode() + " " +
        name + " pravidlo: " + rulestr +
        " meno 2: " + name2 +"]";
        }
        public String getName() {

        return this.name;
        }
        public String getRulestr() {
        	return rulestr;
        }
        public void setRule(String rulestr) {
        	this.rulestr = rulestr;
        }
        public String getName2() {
        	return name2;
        }
        public void setName2(String name2) {
        	this.name2 = name2;
        }
        public void setName(String name) {
        	this.name = name;
        }
        
        
    }}
    		
    

    
   

 
