package library;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LibraryFormatDateTime {
	public LibraryFormatDateTime(){}
	
	public String TimestamptoString(Timestamp dateTime){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY, hh:mm a");
		String formatDate = sdf.format(dateTime);
		return formatDate;
	}
	
	public Timestamp DateTimeFormToTimestamp(String Datetime) {
		Datetime = Datetime + ":00";
		Timestamp result = Timestamp.valueOf(Datetime.replace("T", " "));
		return result;
	}
}
