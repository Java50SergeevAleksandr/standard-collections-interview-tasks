package telran.interviews;

import java.time.LocalDate;
import java.util.*;

public class InterviewTasks {
	static public void displayShuffled(int[] ar) {
		Arrays.stream(ar).unordered().parallel().forEach(e -> System.out.printf("%d", e));
	}

	static public void displayShuffled2(int[] ar) {
		new Random().ints(0, ar.length).distinct().limit(ar.length).forEach(e -> System.out.printf("%d", e));
	}

	static public List<DateRole> rolesInDates(List<DateRole> datesRoles, List<LocalDate> dates) {
		TreeMap<LocalDate, String> vault = new TreeMap<>();
		datesRoles.stream().forEach(dr -> vault.put(dr.date(), dr.role()));
		return dates.stream().map(d -> {
			Map.Entry<LocalDate, String> entry = vault.floorEntry(d);
			return new DateRole(d, entry == null ? null : entry.getValue());
		}).toList();
	}

	static public List<DateRole> rolesInDates1(List<DateRole> datesRoles, List<LocalDate> dates) {
		List<DateRole> res = new LinkedList<>();

		for (int i = 0; i < dates.size(); i++) {
			String role = null;

			for (int j = 0; j < datesRoles.size(); j++) {
				if (datesRoles.get(j).date().toString().compareTo(dates.get(i).toString()) <= 0) {
					role = datesRoles.get(j).role();
				}
			}

			res.add(new DateRole(dates.get(i), role));
		}

		return res;
	}

}
