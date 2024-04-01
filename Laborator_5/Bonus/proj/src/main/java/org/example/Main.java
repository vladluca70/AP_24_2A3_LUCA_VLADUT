package org.example;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(new File("C://Users//vladl//Desktop//java_labs//Bonus//proj//users.xls"));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            Map<String, List<String>> abilitiesMap = new HashMap<>();

            for (Row row : sheet)
            {
                Cell userNameCell = row.getCell(0);
                if (userNameCell != null && userNameCell.getCellType() == CellType.STRING) {
                    String userName = userNameCell.getStringCellValue();

                    for (int i = 1; i < row.getLastCellNum(); i++) {
                        Cell abilityCell = row.getCell(i);
                        if (abilityCell != null && abilityCell.getCellType() == CellType.STRING) {
                            String ability = abilityCell.getStringCellValue();

                            List<String> usersWithAbility = abilitiesMap.getOrDefault(ability, new ArrayList<>());
                            usersWithAbility.add(userName);
                            abilitiesMap.put(ability, usersWithAbility);
                        }
                    }
                }
            }

            for (Map.Entry<String, List<String>> entry : abilitiesMap.entrySet()) {
                System.out.println(entry.getKey() + "={" + String.join(", ", entry.getValue()) + "}");
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
