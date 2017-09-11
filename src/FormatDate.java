import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatDate {
    public String plainDateToFormattedDate(String plainDate){

        String stringDate = plainDate;
        //System.out.println(stringDate);
        LocalDate localDate;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        localDate = LocalDate.parse(stringDate,dateTimeFormatter);
        //System.out.println(localDate);



        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String formattedDate = localDate.format(dateTimeFormatter2);
        return formattedDate;


    }
}
