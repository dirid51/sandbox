package edu.ksu.sqlmaker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

public class MotorPoolMileage {

	public static void main(String[] args) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String content = new String(Files.readAllBytes(Paths.get(args[0])));
		List<String> records = Arrays.asList(content.split("\\n"));
		ArrayList<String> inserts = new ArrayList<String>();
		StringBuilder sql = new StringBuilder("insert into\n\tae_r_mtr_h (multitenant_id,meter_id,mtr_date,mtr_user,mtr_stat,mtr_reading,description,edit_date,edit_clerk)\nvalues\n");
		for (String r : records) {
			String[] recordArray = r.split("\\t");
			inserts.add("('1','" + recordArray[0] + "','2014-12-31 00:00:00','PGRATER','Y','" + recordArray[1].trim() + "',NULL,'" + LocalDateTime.now().format(formatter) + "','DATADUMP')");
		}
		Joiner joiner = Joiner.on(",\n");
		sql.append(joiner.join(inserts).trim() + ";");
		System.out.println(sql.toString());
	}

}