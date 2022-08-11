import java.io.IOException;
import java.time.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class example {

    public static void change25Days(String inpDate) throws IOException {

        //Get todays Date first and format it in dd-MM-yyyy
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = dateObj.format(formatter);

        //for formatting the user dateand checking it
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(sdf.parse(date));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // used to add days to user input date
        cal.add(Calendar.DAY_OF_MONTH, 25);
        String dateAfter = sdf.format(cal.getTime());
        
        //wether date equlas exaclty 25 days from now
        if(inpDate.equals(dateAfter)){

            Runtime.getRuntime().exec("cmd /C date "+inpDate);
            //date after adding 25 days to the given date
            System.out.println(dateAfter+" is the date after adding 25 days.");
       
        }
        else{
            System.out.println("no");
        }


        

    }

    public static void main(String[] args) throws Exception  {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Date to be changed in dd-MM-yyyy format:");
        //Read the input from the user
        String sDate1= sc.nextLine();

        change25Days(sDate1);




    }

}
