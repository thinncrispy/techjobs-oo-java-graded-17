package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 =new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    //TODO: Create your unit tests here

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertEquals("Product tester", testJob.getName());
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String jobString = job.toString();
        assertEquals(true, jobString.startsWith(System.lineSeparator()));
        assertEquals(true, jobString.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = System.lineSeparator() +
                "ID: " + testJob.getId() + System.lineSeparator() +
                "Name: " + testJob.getName() + System.lineSeparator() +
                "Employer: " + testJob.getEmployer() + System.lineSeparator() +
                "Location: " + testJob.getLocation() + System.lineSeparator() +
                "Position Type: " + testJob.getPositionType() + System.lineSeparator() +
                "Core Competency: " + testJob.getCoreCompetency() + System.lineSeparator();
        assertEquals(jobString, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String emptyJobValues = System.lineSeparator() +
                "ID: " + testJob.getId() + System.lineSeparator() +
                "Name: " + testJob.getName() + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: " + testJob.getLocation() + System.lineSeparator() +
                "Position Type: " + testJob.getPositionType() + System.lineSeparator() +
                "Core Competency: " + testJob.getCoreCompetency() + System.lineSeparator();
        assertEquals(emptyJobValues, testJob.toString());

    }
}
