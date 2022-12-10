package incometaxcalculator.data.management;

import incometaxcalculator.data.io.FileWriter;
import incometaxcalculator.data.io.TXTLogWriter;
import incometaxcalculator.data.io.XMLLogWriter;
import incometaxcalculator.exceptions.WrongFileFormatException;

public class LogWriterFactory {
    public FileWriter createLogWriter(String fileFormat)
            throws WrongFileFormatException {
        if (fileFormat.equals("txt")) {
            return new TXTLogWriter();
        } else if (fileFormat.equals("xml")) {
            return new XMLLogWriter();
        } else {
            throw new WrongFileFormatException();
        }
    }
}
