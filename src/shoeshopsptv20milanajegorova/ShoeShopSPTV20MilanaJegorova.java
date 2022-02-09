package shoeshopsptv20milanajegorova;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShoeShopSPTV20MilanaJegorova {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        boolean working = true;
        while(working){
            System.out.println("\n0. Выход из программы");
            System.out.println("1. Добавить модель");
            System.out.println("2. Список продоваемых моделей");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список зарегистрированных покупателей");
            System.out.println("5. Покупка покупателем обуви");
            System.out.println("6. Доход магазина за всё время работы");
            System.out.println("7. Добавить денег покупателю\n");
            
            System.out.print("Выберите функцию: ");
            String choice = scanner.nextLine();
            
            switch(choice){
                case "0":
                    working = false;
                    break;
                case "1":
                    System.out.print("Введите название обуви: ");
                    String shoeName = scanner.nextLine();
                    System.out.print("Введите цену: ");
                    int shoePrice = scanner.nextInt();
                    Shoe shoe = new Shoe(shoeName, shoePrice);
                    String str = shoe.getName()+ "*"+ shoe.getPrice()+"\n";
                    File file = createFile("shoes.txt");
                    writeToFile(file, str);
                    break;
                case "2":
                    Shoe[] shoes = getShoes();
                    for (int i = 0; i < shoes.length; i++){
                        System.out.println(shoes[i].toString());
                    }
                    
                    
                    
            }
            
            
            
            
        }
    }
    
    public static File createFile(String fileName){
    try {
      File myObj = new File(fileName);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
      return myObj;
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      return new File(fileName);
    }
    }
    
    public static void writeToFile(File file, String str){
    try {
      FileWriter myWriter = new FileWriter(file, true);
      myWriter.write(str);
      myWriter.flush();
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
    public static Shoe[] getShoes(){
    try {
      File myObj = new File("shoes.txt");
      Scanner myReader = new Scanner(myObj);
      int iterator = 0;
      while (myReader.hasNextLine()) {
          myReader.nextLine();
          iterator ++;
      }
        Shoe[] shoes;
        shoes = new Shoe[iterator];
      iterator = 0;
      myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String sName = data.substring(0, data.indexOf("*"));
        int sPrice = Integer.parseInt(data.substring(data.indexOf("*")+1));
          
        shoes[iterator] = new Shoe(sName, sPrice);
        iterator ++; 
      }
      myReader.close();
      return shoes;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      return new Shoe[0];
    }
    
    }
}
