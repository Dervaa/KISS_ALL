package LAB2.BaseFormatter;

import LAB2.Interface.IDateFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StandardDateFormatter implements IDateFormatter {

    public StandardDateFormatter() {
        System.out.println("StandardDateFormatter instance created");
    }

    @Override
    public String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        return sdf.format(date);
    }
}

