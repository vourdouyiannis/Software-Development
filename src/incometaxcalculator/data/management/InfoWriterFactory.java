package incometaxcalculator.data.management;

import incometaxcalculator.data.io.FileWriter;
import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.io.XMLInfoWriter;

import java.io.File;
import java.util.ArrayList;

public class InfoWriterFactory {
    public ArrayList<FileWriter> createInfoWriter(int taxRegistrationNumber ) {
        ArrayList<FileWriter> writersToReturn = new ArrayList<> ();

        if (new File(taxRegistrationNumber + "_INFO.xml").exists()) {
            writersToReturn.add(new XMLInfoWriter());
        }
        else {
            writersToReturn.add(new TXTInfoWriter());
            return writersToReturn;
        }

        if (new File(taxRegistrationNumber + "_INFO.txt").exists()) {
            writersToReturn.add(new TXTInfoWriter());
        }

        return writersToReturn;
    }//end of method
}
