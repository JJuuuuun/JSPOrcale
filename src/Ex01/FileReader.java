package Ex01;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> getFileContents(String fileName) throws IOException {
        List<String> lst = new ArrayList<>();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8)
        );

        String line = null;
        while ((line = br.readLine()) != null) {
            lst.add(line);
        }

        return lst;
    }

    public List<Customers> getCustomersList(List<String> list) {
        List<Customers> customersList = new ArrayList<>();

        for (String str : list) {
            String [] strArr = str.split("\t");
            Customers customer = new Customers();

            customer.setCustomerID(Integer.parseInt(strArr[0]));
            customer.setCustomerName(strArr[1]);
            customer.setContactName(strArr[2]);
            customer.setAddress(strArr[3]);
            customer.setCity(strArr[4]);
            customer.setPostalCode(strArr[5]);
            customer.setCountry(strArr[6]);

            customersList.add(customer);
        }

        return customersList;
    }
}
