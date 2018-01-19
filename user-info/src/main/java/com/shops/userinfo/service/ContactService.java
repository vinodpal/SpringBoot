package com.shops.userinfo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shops.userinfo.model.Contact;

public class ContactService {
	public static List<Contact> readCsvFile(String csvFile, String userid) {

       // String csvFile = "/home/nanobi/bank.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Contact> listContact = null;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			listContact = new ArrayList<>();
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] splitLine = line.split(cvsSplitBy);
				Contact contact = new Contact();

				if (splitLine[0] != null)
					contact.setFirstname(splitLine[0]);
				if (splitLine[1] != null)
					contact.setLastname(splitLine[1]);
				if (splitLine[2] != null)
					contact.setEmail(splitLine[2]);
				if (splitLine[3] != null)
					contact.setPhone(splitLine[3]);
				contact.setUserid(userid);
				listContact.add(contact);

			}
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return  listContact ;

    }
}
