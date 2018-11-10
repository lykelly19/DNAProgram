import java.util.Scanner;

public class DNA{

   static Scanner input = new Scanner(System.in);
   static String DNAStrand;
   static String mRNA = "";
   static String temp_mRNA = "";


   public static void main(String args[])  {

      System.out.println("Enter DNA Strand Bases: ");
      DNAStrand = input.nextLine();
      DNAStrand = DNAStrand.toUpperCase();
      System.out.println("DNA Strand: " + DNAStrand);
      transcribe();
      translate();
   }
   
   public static void transcribe(){
      
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
      
      System.out.println("\nTranscribed to mRNA");
      System.out.println("mRNA Strand: " + mRNA);
   }   
   
   public static void translate(){
   
      //search for AUG start codon
      for(int x=0; x<mRNA.length()-2; x++){
         if(mRNA.substring(x,x+3).equals("AUG")){
            System.out.println("\nStart codon AUG found. Beginning Translation");
            temp_mRNA = mRNA.substring(x,mRNA.length());
            break;
         }
      }
      
       //search for stop codons UAA, UAG, UGA
       if(temp_mRNA.length() > 0){
        
          for(int x=0; x<temp_mRNA.length()-2; x=x+3){
            if(temp_mRNA.substring(x,x+3).equals("UAA") || temp_mRNA.substring(x,x+3).equals("UAG") || temp_mRNA.substring(x,x+3).equals("UGA")){
               System.out.println("\nStop codon " + temp_mRNA.substring(x,x+3) + " found");
               break;
            }
            aminoAcids(temp_mRNA.substring(x,x+3));
         
        }
         
       }
   }
   
   public static void aminoAcids(String codon){

       switch(codon){
            case "AUG": System.out.print("met"); break;
            case "UUU": System.out.print("phe"); break;
            case "UUC": System.out.print("phe"); break;
         
        }
        
        System.out.print(" - ");
        
   }
}