import java.util.Scanner;

public class DNA{

   static Scanner input = new Scanner(System.in);
   static String DNAStrand;
   static String mRNA = "";


   public static void main(String args[])  {

      System.out.println("Enter DNA Strand Bases: ");
      DNAStrand = input.nextLine();
      DNAStrand = DNAStrand.toUpperCase();
      System.out.println("DNA Strand: " + DNAStrand);
      transcribe();
   }
   
   public static void transcribe(){
      
      for(int x=1; x<DNAStrand.length()+1;x++){
         if(DNAStrand.substring(x-1,x).equals("A"))
            mRNA = mRNA + "U";
         else if(DNAStrand.substring(x-1,x).equals("G"))
            mRNA = mRNA + "C";
         else if(DNAStrand.substring(x-1,x).equals("T"))
            mRNA = mRNA + "A";
         else if(DNAStrand.substring(x-1,x).equals("C"))
            mRNA = mRNA + "G";
         
      }
      System.out.println("\nTranscribed to mRNA");
      System.out.println("mRNA Strand: " + mRNA);
   }   
}