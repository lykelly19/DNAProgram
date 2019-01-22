// Transcribes and translates an input DNA strand

import java.util.Scanner;

public class DNA{

   static Scanner input = new Scanner(System.in);
   static String DNAStrand;
   static String mRNA = "";
   static String temp_mRNA = "";
   static String letter_strand = "";


   public static void main(String args[])  {

      System.out.println("Enter DNA Strand Bases: ");
      DNAStrand = input.nextLine();
      DNAStrand = DNAStrand.toUpperCase();
      System.out.println("DNA Strand: " + DNAStrand);
      transcribe();
      translate();
   }
   
   public static void transcribe(){
      
      //match DNA and mRNA bases
      for(int x=0; x<DNAStrand.length();x++){  
         if(DNAStrand.substring(x,x+1).equals("A"))
            mRNA = mRNA + "U";
         else if(DNAStrand.substring(x,x+1).equals("G"))
            mRNA = mRNA + "C";
         else if(DNAStrand.substring(x,x+1).equals("T"))
            mRNA = mRNA + "A";
         else if(DNAStrand.substring(x,x+1).equals("C"))
            mRNA = mRNA + "G";
      }
      
      System.out.println("\nTranscribing to mRNA...");
      System.out.println("mRNA Strand: " + mRNA);
   }   
   
   public static void translate(){
   
      //search for AUG start codon
      for(int x=0; x<mRNA.length()-2; x++){
         if(mRNA.substring(x,x+3).equals("AUG")){
            System.out.println("\nStart codon AUG found. Beginning Translation...");
            temp_mRNA = mRNA.substring(x,mRNA.length());  //cut off anything before start codon
            break;
         }
      }
             
       if(temp_mRNA.length() > 0){  // only translates if AUG was found
        
          for(int x=0; x<temp_mRNA.length()-2; x=x+3){  // look at mRNA bases in groups of three (codons)
            if(temp_mRNA.substring(x,x+3).equals("UAA") || temp_mRNA.substring(x,x+3).equals("UAG") || temp_mRNA.substring(x,x+3).equals("UGA")){  //search for stop codons UAA, UAG, UGA
               System.out.println("\nStop codon " + temp_mRNA.substring(x,x+3) + " found");
               break;
            }
            
            aminoAcids(temp_mRNA.substring(x,x+3));
            
            if((temp_mRNA.substring(x+3,temp_mRNA.length())).length() < 3)
               System.out.print("\n\nNo stop codon found");
            else if(temp_mRNA.substring(x+3,x+6).equals("UAA") || temp_mRNA.substring(x+3,x+6).equals("UAG") || temp_mRNA.substring(x+3,x+6).equals("UGA"))
               System.out.print(" ");
            else            
               System.out.print(" - ");
         } 
       }
       else
         System.out.println("\nStart codon was not found for translation");
   }
   
   public static void aminoAcids(String codon){

       switch(codon){
            case "AUG": System.out.print("met"); letter_strand = letter_strand + "M"; break;
            case "UUU": System.out.print("phe"); letter_strand = letter_strand + "F"; break;
            case "UUC": System.out.print("phe"); letter_strand = letter_strand + "F"; break;
            case "UUA": System.out.print("leu"); letter_strand = letter_strand + "L"; break; 
            case "UUG": System.out.print("leu"); letter_strand = letter_strand + "L"; break;
            case "CUU": System.out.print("leu"); letter_strand = letter_strand + "L"; break;
            case "CUC": System.out.print("leu"); letter_strand = letter_strand + "L"; break;
            case "CUA": System.out.print("leu"); letter_strand = letter_strand + "L"; break;
            case "CUG": System.out.print("leu"); letter_strand = letter_strand + "L"; break;
            case "AUU": System.out.print("ile"); break;
            case "AUC": System.out.print("ile"); break;
            case "AUA": System.out.print("ile"); break;
            case "GUU": System.out.print("val"); break;
            case "GUC": System.out.print("val"); break;
            case "GUA": System.out.print("val"); break;
            case "GUG": System.out.print("val"); break;
            case "UCU": System.out.print("ser"); break;
            case "UCC": System.out.print("ser"); break;
            case "UCA": System.out.print("ser"); break;
            case "UCG": System.out.print("ser"); break;
            case "CCU": System.out.print("pro"); break;
            case "CCC": System.out.print("pro"); break;
            case "CCA": System.out.print("pro"); break;
            case "CCG": System.out.print("pro"); break;
            case "ACU": System.out.print("thr"); break;
            case "ACC": System.out.print("thr"); break;
            case "ACA": System.out.print("thr"); break;
            case "ACG": System.out.print("thr"); break;
            case "GCU": System.out.print("ala"); break;
            case "GCC": System.out.print("ala"); break;
            case "GCA": System.out.print("ala"); break;
            case "GCG": System.out.print("ala"); break;
            case "UAU": System.out.print("tyr"); break;
            case "UAC": System.out.print("tyr"); break;
            case "CAU": System.out.print("his"); break;
            case "CAC": System.out.print("his"); break;
            case "CAA": System.out.print("gln"); break;
            case "CAG": System.out.print("gln"); break;
            case "AAU": System.out.print("asn"); break;
            case "AAC": System.out.print("asn"); break;
            case "AAA": System.out.print("lys"); break;
            case "AAG": System.out.print("lys"); break;
            case "GAU": System.out.print("asp"); break;
            case "GAC": System.out.print("asp"); break;
            case "GAA": System.out.print("glu"); break;
            case "GAG": System.out.print("glu"); break;
            case "UGU": System.out.print("cys"); break;
            case "UGC": System.out.print("cys"); break;
            case "UGG": System.out.print("trp"); break;
            case "CGU": System.out.print("arg"); break;
            case "CGC": System.out.print("arg"); break;
            case "CGA": System.out.print("arg"); break;
            case "CGG": System.out.print("arg"); break;
            case "AGU": System.out.print("ser"); break;
            case "AGC": System.out.print("ser"); break;
            case "AGA": System.out.print("arg"); break;
            case "AGG": System.out.print("arg"); break;
            case "GGU": System.out.print("gly"); break;
            case "GGC": System.out.print("gly"); break;
            case "GGA": System.out.print("gly"); break;
            case "GGG": System.out.print("gly"); break;
        }
   }
}