package sample;

import org.hibernate.pretty.Formatter;

public class SQLInsertsFormatter {


    public static String pasteInserts(String query, String inserts) {

        String[] arr = inserts.replace("<", "").split(">", 0);

        for (int i = 0; i < arr.length; i++) arr[i] = arr[i].trim();

        String resultLine = query;
        int index = 0;

        while (resultLine.contains("?") && arr.length > 0 && index < arr.length) {
            resultLine = resultLine.replaceFirst("\\?", "'" + arr[index] + "'");
            ++index;
        }

        return resultLine;
    }


    public static String format(String query) {

        Formatter formatter = new Formatter(query);
        return formatter.format().trim();
    }
}
