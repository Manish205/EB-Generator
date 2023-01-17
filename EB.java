import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    EBill b = new EBill();
    b.input_data();
    b.calculate_bill();
    b.display();
  }
}
class EBill{

   int ConsumerNo;
   String ConsumerName;
   int PrevReading;
   int CurrReading;
   String EBConn;
   double Bill;
   void input_data()
   {
     Scanner sc = new Scanner(System.in);
     System.out.println("\n Enter Consumer Number: ");
     ConsumerNo = sc.nextInt();
     System.out.println("\n Enter Consumer ConsumerName: ");
     ConsumerName = sc.next();
     System.out.println("\n Enter Previous Units: ");
     PrevReading = sc.nextInt();
     System.out.println("\n Enter Current Units consumed: ");
     CurrReading = sc.nextInt();
     System.out.println("Enter the types of EB Connection(domestic or commercial)");
     EBConn = sc.next();

   }
   double calculate_bill()
   {
     int choice;
     if(EBConn=="domestic")
      choice = 1;
     else
      choice = 2;
     switch(choice)
     {
       case 1:  if(CurrReading >= 0 && CurrReading <= 50)
                  Bill = CurrReading * 0;
                else if(CurrReading >= 51 && CurrReading <= 100)
                  Bill = (50*0)+((CurrReading-50)*2);
                else if(CurrReading >= 150 && CurrReading <= 300)
                  Bill = (50*0)+(50*2)+((CurrReading-100)*4);
                else
                  Bill = (50*0)+(50*2)+(150*4)+((CurrReading-250)*6);
                break;
       case 2:  if(CurrReading >= 0 && CurrReading <= 20)
                  Bill = CurrReading * 0;
                else if(CurrReading >= 21 && CurrReading <= 100)
                  Bill = (20*0)+((CurrReading-20)*4);
                else if(CurrReading >= 101 && CurrReading <= 200)
                  Bill = (20*0)+(80*4)+((CurrReading-100)*6);
                else
                  Bill = (20*0)+(80*4)+(100*6)+((CurrReading-200)*8);
                break;
     }
     return Bill;
   }
   void display()
   {
     System.out.println("__________________________");
     System.out.println("ELECTRICITY BILL");
     System.out.println("__________________________");
     System.out.println("Consumer Number: "+ ConsumerNo);
     System.out.println("Consumer Name: "+ ConsumerName);
     System.out.println("Consumer Previous Units: "+ PrevReading);
     System.out.println("Consumer Current Units: "+ CurrReading);
     System.out.println("Type of EBConnection: "+ EBConn);
     System.out.println("__________________________");
     System.out.println("Total Amount(Rs.): "+ Bill);
   }
}
