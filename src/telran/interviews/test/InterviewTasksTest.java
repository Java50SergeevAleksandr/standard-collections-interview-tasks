package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.DateRole;
import telran.interviews.InterviewTasks;

class InterviewTasksTest {
	DateRole d1 = new DateRole(LocalDate.parse("2017-10-12"), "Developer");
	DateRole d2 = new DateRole(LocalDate.parse("2020-01-01"), "Team Leader");
	DateRole d3 = new DateRole(LocalDate.parse("2023-08-15"), "Project Manager");
	List<DateRole> list;
	List<LocalDate> dates;
	List<DateRole> res;

	@BeforeEach
	void setUp() throws Exception {
		list = new LinkedList<>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		dates = new LinkedList<>();
		dates.add(LocalDate.parse("2015-01-01"));
		dates.add(LocalDate.parse("2018-01-01"));
		dates.add(LocalDate.parse("2023-01-01"));
		res = new LinkedList<>();
		res.add(new DateRole(LocalDate.parse("2015-01-01"), null));
		res.add(new DateRole(LocalDate.parse("2018-01-01"), "Developer"));
		res.add(new DateRole(LocalDate.parse("2023-01-01"), "Team Leader"));
	}

	@Test
	void displayShuffledTest() {
		int[] arr = { 1, 2, 3, 4, 5 };
		InterviewTasks.displayShuffled(arr);
		System.out.println();
		InterviewTasks.displayShuffled(arr);
		System.out.println();
		InterviewTasks.displayShuffled(arr);
		System.out.println();
		InterviewTasks.displayShuffled(arr);
		System.out.println();
	}

	@Test
	void datesRolesTest() {
		List<DateRole> results = InterviewTasks.rolesInDates(list, dates);
		for (int i = 0; i < results.size(); i++) {
			assertEquals(res.get(i), results.get(i));
		}
	}
}
