import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 

 public class Main {
      static class Transaction {
    private String transactionType;
    private double amount;
    private long accountNum;
    private Date date;
    Scanner sc = new Scanner(System.in);
    public Transaction() {
    }
    public void transaction(long accountNum, String            transactionType,double amount) {
        this.accountNum= accountNum;
        this.transactionType = transactionType;
        this.amount = amount;
        date = new Date();
        operation();
    }
        private void operation() {
     if (transactionType.equalsIgnoreCase("Opening")) {
    try{
              // Create file
              FileWriter fstream = new FileWriter("MyFile.txt", true);
              BufferedWriter out =new BufferedWriter(fstream);
              int userId=(int) (findMaxId()+1);
              out.write(Integer.toString(userId)+"\n");
              out.write(amount+"\n");
              out.write(date+"\n");
              //Close the output stream
              out.close();
             }catch (IOException e) {
                 System.err.println("Caught IOException: " + e.getMessage());
             }
           }

        else if (transactionType.equalsIgnoreCase("withdraw")) {
         Path path = Paths.get("MyFile.txt");
   if (Files.exists(path)) {
    findUpdate() ;
   }else{
    System.out.println("File not Found");
   }
        }

        else if (transactionType.equalsIgnoreCase("deposit")) {
         Path path = Paths.get("MyFile.txt");
   if (Files.exists(path)) {
    findUpdate() ;
   }else{
    System.out.println("File not Found");
   }
        }

        else if (transactionType.equalsIgnoreCase("showInfo")) {
         Path path = Paths.get("MyFile.txt");
   if (Files.exists(path)) {
          findDisplay();
         }else{
    System.out.println("File not Found");
   }
        }

        else {
            System.out.println("Invalid option");
            return;
        }

    }
 private int findMaxId() {
  try{
   BufferedReader reader = new BufferedReader(new FileReader("MyFile.txt"));
   int count=0;
   while ((reader.readLine()) != null)
   {
    count=count+1;
   }
   reader.close();
   // Logic for finding maximum Id
   return count/3;
  }
  catch (Exception e)
  {
   System.err.format("Exception occurred trying to read '%s'.", "MyFile.txt");
   e.printStackTrace();
  }
  return 0;
 }

 private void findDisplay() {
  try{
   BufferedReader reader = new BufferedReader(new FileReader("MyFile.txt"));
   String line;
   String trmpaccountNum=Long.toString(accountNum);
   int count=1;
   while ((line = reader.readLine()) != null)
   {
    //my logic for displaying 2 more lines after found
    if(count>1){
              trmpaccountNum =line;
             }
     if((line.equals(trmpaccountNum))&&(count<4)){
      System.out.println(line);
      count=count+1;
       }
      }
   reader.close();
  }
  catch (Exception e)
  {
   System.err.format("Exception occurred trying to read '%s'.", "MyFile.txt");
   e.printStackTrace();
  }
 }
 private void findUpdate() {
  try{
   BufferedReader reader = new BufferedReader(new FileReader("MyFile.txt"));
  
   FileWriter fstream = new FileWriter("TempFile.txt", true);
            BufferedWriter out =new BufferedWriter(fstream);
  
            String line;
   String trmpaccountNum=Long.toString(accountNum);
   int count=1;
   while ((line = reader.readLine()) != null)
   {
   
    //my logic for updating 3 lines after found
    if(count>1){
              trmpaccountNum =line;
             }
     if((line.equals(trmpaccountNum))&&(count<4)){
      double temp_amount = 0;
      if (count==1){
       out.write(accountNum+"\n");
      }
      else if (count==2){
       if(transactionType.equalsIgnoreCase("withdraw")){
        temp_amount=Double.parseDouble(line)-amount;
       }else if(transactionType.equalsIgnoreCase("deposit")){
        temp_amount=amount+Double.parseDouble(line);
       }
       if(temp_amount<0){
        System.out.println("Could not update \n");
        out.write(Double.toString(amount)+"\n");
       }else{
        System.out.println(Double.toString(temp_amount)+" is updated value\n");
        out.write(Double.toString(temp_amount)+"\n");
       }
      }
      else if(count==3){
       out.write(date+"\n");
      }
       count=count+1;
                    }else{
                      out.write(line+"\n");//System.out.println("Account not found in file");
                    }
          }
   out.close();
   reader.close();
  // Rename the temporary file and delete original file
    File f1 = new File("MyFile.txt");
    f1.delete();
    File f2 = new File("TempFile.txt");
    boolean b = f2.renameTo(f1);
    if(b){
    }else{
     System.out.println("Updated has Error");
    }
   // Rename the temporary file and delete original file
  }
  catch (Exception e)
  {
   System.err.format("Exception occurred trying to read '%s'.", "MyFile.txt");
   e.printStackTrace();
  }
 }
}




static class Start {
  int count=0;
  List<String> FileRecords;
  public void StartBank(){
  @SuppressWarnings("resource")
  Scanner input = new Scanner(System.in);
  char mainYesOrNo = 'Y';
  while (mainYesOrNo =='Y'){
   System.out.print("\t\t     ================================\n");
   System.out.print("\t\t     Welcome To Bank Managment System  \n");
   if(count<1){
    count=count+1;
   }else{
    System.out.print("\t\t                    Again        \n");
   }
   System.out.print("\t\t     ================================\n");
  
   System.out.print("\tQ:What do you want to do?\n\n");
   if(count<2){
    System.out.print("\t\t1 : Start\n\n");
    count=count+1;
   }else{
    System.out.print("\t\t1 : Start Again\n\n");
   }
   System.out.print("\t\t2 : Exit\n\n");
   System.out.println("\t\t\tYou Select : ");
   int switchChoice = input.nextInt();
   switch (switchChoice)
   {
  
    case 1: {
     start();
     break;
    }
    case 2: {
     return;
    }
    default: {
      System.out.println("Invalid Selection");
      error();
       break;
    }
   }
   System.out.println("\n\tDo u want to run your Program Again \n\t\t\tY = yes\n\t\t\tN = No\n");
   System.out.println("You Select : ");
  
   mainYesOrNo =(input.next()).charAt(0);
   if(Character.isLowerCase(mainYesOrNo )){
    mainYesOrNo =Character.toUpperCase(mainYesOrNo );
   }//End If
  }//End While
 }
 private List<String> readFile(String filename) {
  List<String> records = new ArrayList<String>();
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = reader.readLine()) != null)
      {
        records.add(line);
      }
      reader.close();
      return records;
    }
    catch (Exception e)
    {
      System.err.format("Exception occurred trying to read '%s'.", filename);
      e.printStackTrace();
      return null;
    }
 }
 private void start() {
  String choice, ch, operation;
        Transaction transac = new Transaction();
        Scanner sc = new Scanner(System.in);
        double amount;
        long accountNo=0;

        do {
        
         System.out.print("\tQ:What do you want to do next?\n\n");
   System.out.print("\t\t1 : New account\n\n");
   System.out.print("\t\t2 : Transaction\n\n");
   System.out.print("\t\t3 : View Account Information\n\n");
   System.out.print("\t\tq : Exit\n\n");
            System.out.println("Your choice: ");
            choice = sc.next();
            switch (choice) {
            case "1":
                double openingBalance;
                System.out.println("Enter the opening balance :");
                openingBalance = sc.nextDouble();
                transac.transaction(accountNo, "Opening", openingBalance);
                accountNo=accountNo+1;
                break;
            case "2":
             System.out.print("\tQ:What do you want to do for Transaction?\n\n");
             System.out.print("\t\ta : Deposit\n\n");
             System.out.print("\t\tb : Withdraw\n\n");
                ch = sc.next();
                if (ch.equalsIgnoreCase("a"))
                    operation = "Deposit";
                else if (ch.equalsIgnoreCase("b"))
                    operation = "Withdraw";
                else {
                    operation = "Invalid option";
                }
                System.out.println("Account Number:");
                accountNo = sc.nextLong();
                System.out.println("Amount:");
                amount = sc.nextDouble();
                transac.transaction(accountNo, operation, amount);
                break;
            case "3":
            
             System.out.println("Account Number:");
                accountNo = sc.nextLong();
                operation = "showInfo";
                transac.transaction(accountNo, operation, 0);
                break;
            case "q":
                System.out.println("Thank you!");
                return;
            default:
                error();
            }
        } while (choice != "q");
        sc.close();
 }
 public static void error() {
  System.out.print("\t\t     *****************************\n");
  System.out.print("\t\t     |-----------> ERROR <--------| \n");
  System.out.print("\t\t     *****************************\n");
  System.out.print("\t\t     You Select some thin wrong\n");
  System.out.print("\t\t                OR\n");
  System.out.print("\t\t  There may be some othere Problem\n");
  System.out.print("\t\t It is better for you to try again...!\n");
  System.out.print("\t\t     *****************************\n");
 }
}
 public static void main(String[] args) {
  Start objectStart = new Start();
   objectStart.StartBank();
}
}
